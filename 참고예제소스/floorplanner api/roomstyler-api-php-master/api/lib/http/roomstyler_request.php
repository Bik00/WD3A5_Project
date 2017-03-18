<?php

  class RoomstylerRequest extends RoomstylerBase {

    protected $_settings = [];
    protected $_whitelabeled = false;

    const DELETE = 'DELETE';
    const POST = 'POST';
    const GET = 'GET';
    const PUT = 'PUT';
    const PATCH = 'PATCH';

    const AUTH_USER = 'USER';
    const AUTH_API = 'API';
    const AUTH_ALL = 'ALL';

    public function __construct(array $settings, $whitelabeled = false) {
      $this->_settings = $settings;
      $this->_whitelabeled = $whitelabeled;
    }

    public function update_setting($setting, $value) {
      $this->_settings[$setting] = $value;
    }

    public function update_settings($arr) {
      $this->_settings = array_merge($this->_settings, $arr);
    }

    public function send($type, $path, array $args = [], $method = self::GET, $auth_type = self::AUTH_ALL) {
      $parent_attrs = isset($this->_settings['parent_attrs']) ? $this->_settings['parent_attrs'] : [];

      if ($auth_type != self::AUTH_API && $this->_settings['token'])
        $args = array_merge($args, ['token' => $this->_settings['token']]);

      # if the request isn't GET then we don't want to add any query params
      $url = $this->build_url($path, ($method == self::GET ? $args : []));
      $res = $this->curl_fetch($url, $args, $method, $auth_type);

      if ($type == NULL) return $res;

      $final_res = $this->collection_from_response($type, $res, $parent_attrs);

      if (!$this->_settings['debug']) return $final_res;
      return [
        'result' => $final_res,
        'request_info' => new RoomstylerResponse([
          'path' => str_replace('\/\/', '\/[MISSING]\/', $path),
          'full_path' => str_replace('\/\/', '\/[MISSING]\/', $url),
          'arguments' => $args,
          'method' => $method,
          'status' => $res['status'],
          'headers' => $res['headers'],
          'body' => $res['body'],
          'errors' => $res['errors']])];
    }

    private function build_url($path, $args = NULL) {
      $base_path = $this->_settings['protocol'] . '://';
      if ($this->_settings['whitelabel'] && $this->_whitelabeled)
        $base_path .= $this->_settings['whitelabel']['name'] . '.';
      if ($this->_settings['host']) $base_path .= $this->_settings['host'] . '/';
      if ($this->_settings['prefix']) $base_path .= $this->_settings['prefix'];
      $url = $base_path . '/' . $path;

      if ($args) return ($url . '?' . http_build_query($args));
      return $url;
    }

    private function curl_fetch($url, array $params, $mtd, $auth_type = self::AUTH_ALL) {
      $curl = curl_init();

      curl_setopt_array($curl, [
        CURLINFO_HEADER_OUT => true,
        CURLOPT_HEADER => true,
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_URL => $url,
        CURLOPT_HTTPHEADER => $this->_settings['request_headers'],
        CURLOPT_CONNECTTIMEOUT => $this->_settings['connect_timeout'],
        CURLOPT_TIMEOUT => $this->_settings['timeout'],
        CURLOPT_USERAGENT => $this->_settings['user_agent']]);

      # request authentication through http basic, we don't always want to do this since some requests crash when accessed through multiple sources
      # here we need to filter for requests that only allow "normal authenticated user" access
      if ($auth_type != self::AUTH_USER && $this->_settings['whitelabel']) {
        curl_setopt($curl, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);
        curl_setopt($curl, CURLOPT_USERPWD, join(':', $this->_settings['whitelabel']));
      }

      # request method handling is done prior to this step.
      # if a request needs to be post (e.g. on DELETE, PATCH etc...) it will use curls custom request option
      if ($mtd == self::POST) curl_setopt($curl, CURLOPT_POST, true);
      else if ($mtd != self::GET || $mtd != self::POST) curl_setopt($curl, CURLOPT_CUSTOMREQUEST, $mtd);

      if ($mtd != self::GET && !empty($params)) curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($params));

      $raw = curl_exec($curl);
      $curl_info = curl_getinfo($curl);
      $http_status = curl_getinfo($curl, CURLINFO_HTTP_CODE);
      curl_close($curl);

      $response_headers = substr($raw, 0, $curl_info['header_size']);
      $body = substr($raw, $curl_info['header_size']);
      $errors = [];

      if ($body && $http_status < 400) $body = json_decode($body);
      else $errors = json_decode($body, true);

      $res = ['body' => $body,
              'headers' => [
                'request' => self::parse_header_str($curl_info['request_header']),
                'response' => self::parse_header_str($response_headers)],
              'status' => $http_status,
              'errors' => $errors];

      return $res;
    }

    private function collection_from_response($type, $res, $parent_attrs) {
      # check if JSON response root node contains a property (either plural or singular) for what we're trying to fetch
      # if found, reassign $res to this property and continue creating collection
      $singular_type = strtolower(str_replace('Roomstyler', '', $type));
      $plural_type = parent::to_plural($singular_type);
      $out = [];
      $errors = [];
      $status = $res['status'];

      # some results have an 'errors' hash, others have a single 'error' hash
      # this is an attempt to gather errors in a consistent way
      if (isset($res['errors']))
        if (is_array($res['errors'])) $errors = $res['errors'];
        else if (is_object($res['errors'])) $errors = get_object_vars($res['errors']);
        else if (is_string($res['errors'])) $errors[] = $res['errors'];

      if (isset($res['error'])) array_push($errors, $res['error']);

      # wrap errors in RoomstylerError object, if an array is returned, we don't want
      # to create a new instance with the same errors.
      $errors = new RoomstylerError($errors, ['http_status' => $status,
                                              'custom_http_errors_for' => $singular_type]);

      $res = $res['body'];
      # some results have a singular name root node, others may have a plural root node
      # this is another attempt to make the returned results consistent
      if (is_object($res))
        if (property_exists($res, $plural_type)) $res = $res->$plural_type;
        else if (property_exists($res, $singular_type)) $res = $res->$singular_type;

      # SearchMeta request is different since it fetches multiple nested resources
      # therefore we wrap the nested resources within the class instead
      if ($singular_type == 'searchmeta') return new RoomstylerSearchMeta($res, $errors, $status);

      # if result is an array then we want to return an array of wrapped objects
      if (is_array($res))
        # if the count is only one, there's probably a root node wrapping the data
        if (count($res) == 1) $out = new $type(array_shift($res), $this->_settings, $this->_whitelabeled, $errors, $status, $parent_attrs);
        else foreach($res as $_ => $obj) $out[] = new $type($obj, $this->_settings, $this->_whitelabeled, $errors, $status, $parent_attrs);
      else $out = new $type($res, $this->_settings, $this->_whitelabeled, $errors, $status, $parent_attrs);
      return $out;
    }

    private static function parse_header_str($header_str) {
      $out = [];
      $header_lines = preg_split('/\r\n|\n|\r/', $header_str);
      $header_lines = array_filter($header_lines, function($value) { return strlen($value) > 0; });

      foreach ($header_lines as $line) {
        $split_header = explode(': ', $line);
        if (count($split_header) == 1) $out['HTTP'][] = $split_header[0];
        else $out[$split_header[0]] = $split_header[1];
      }

      return $out;
    }

  }
?>
