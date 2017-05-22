package com.floorplanner.dispatch.http;

import com.google.gwt.http.client.RequestBuilder;
import net.customware.gwt.dispatch.shared.Result;

public abstract class JSONHTTPAction<R extends Result> implements HTTPAction<R> {

    @Override public RequestBuilder prepareRequest(RequestBuilder request) {
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-Type", "application/json");
        return request;
    }

}
