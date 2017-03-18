package com.floorplanner.dispatch.jsonp;

import com.google.gwt.http.client.RequestBuilder;

public class JSONRequest extends RequestBuilder {

    public JSONRequest(Method httpMethod, String url) {
        super(httpMethod, url);
        setHeader("Accept", "application/json");
        setHeader("Content-Type", "application/json");
    }

}
