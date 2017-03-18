package com.floorplanner.dispatch.jsonp;

import net.customware.gwt.dispatch.shared.Action;

import com.floorplanner.dispatch.core.JSOResult;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class JSONPAction<R extends JavaScriptObject> implements
        Action<JSOResult<R>> {

    protected class JsonpCallback implements AsyncCallback<R> {

        private final AsyncCallback<JSOResult<R>> callback;

        protected JsonpCallback(AsyncCallback<JSOResult<R>> cb) {
            this.callback = cb;
        }

        @Override public void onFailure(Throwable caught) {
            callback.onFailure(caught);
        }

        @Override public void onSuccess(R result) {
            callback.onSuccess(new JSOResult<R>(result));
        }

    }

    private JsonpRequestBuilder jsonp = new JsonpRequestBuilder();

    protected abstract String getEndpoint();

    void send(AsyncCallback<JSOResult<R>> callback) {
        jsonp.requestObject(getEndpoint(), new JsonpCallback(callback));
    }

    private static final long serialVersionUID = 1L;
}
