request = require 'request'
Promise = require 'bluebird'
config = require 'config'

log = require('./log').getLogger 'sender-3d', 'DEBUG'

if not process.env.FP_API_KEY
  console.error "environment var FP_API_KEY not set!"
  process.exit 0

AUTH = "Basic #{new Buffer(process.env.FP_API_KEY + ":" + "x").toString("base64")}"

render_project_url = (project_id, type='3d') ->
  "http://tim.floorplanner.com/projects/#{project_id}/render#{type}.json"

module.exports = ({id, success_url, width, height, logo, corner}) ->
  new Promise (resolve, reject) ->
    payload =
      callback: "#{config.SERVER}/render3d_complete"
      width: width
      height: height
      view: 'top'
      combine: false
      formats: ['jpg']

    if logo
      payload.logo = logo

    log.info "sending 3d render request for project #{id}"
    log.debug payload

    options =
      url: render_project_url(id, "3d")
      body: JSON.stringify(payload)
      headers:
        "Content-Type": "application/json"
        "Authorization" : AUTH

    request.post options, (err, response, body) ->
      if err
        log.error err
        return reject(err)
      resolve body
