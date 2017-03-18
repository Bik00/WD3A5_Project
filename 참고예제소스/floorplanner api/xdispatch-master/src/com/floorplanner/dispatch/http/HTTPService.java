package com.floorplanner.dispatch.http;

import com.floorplanner.dispatch.core.Service;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public class HTTPService implements Service {

    protected class RestCallback<R extends Result> implements RequestCallback {

        private final AsyncCallback<R> callback;
        private final HTTPAction<R> action;

        RestCallback(AsyncCallback<R> callback, HTTPAction<R> action) {
            this.callback = callback;
            this.action = action;
        }

        @Override
        public void onError(Request request, Throwable exception) {
            callback.onFailure(exception);
        }

        @Override
        public void onResponseReceived(Request request,
                                       Response response) {
            if (response.getStatusCode() > 199
                    && response.getStatusCode() < 400) {
                callback.onSuccess(action.prepareResult(response));
            } else {
                callback.onFailure(new Throwable("Server responded with: "
                        + Integer.toString(response.getStatusCode()) + " - "
                        + response.getStatusText()));
            }
        }

    }

    @Override
    public <A extends Action<R>, R extends Result> boolean maybeExecute(
            A action, AsyncCallback<R> callback) {
        if (action instanceof HTTPAction) {
            HTTPAction<R> a = (HTTPAction<R>) action;
            RequestBuilder request = prepareRequest(a);
            request.setCallback(new RestCallback<R>(callback, a));
            try {
                request.send();
            } catch (RequestException e) {
                callback.onFailure(e);
            }
            return true;
        }
        return false;
    }

    protected RequestBuilder prepareRequest(HTTPAction<?> action) {
        UrlBuilder url = new UrlBuilder();
        url.setProtocol(Window.Location.getProtocol());
        url.setHost(Window.Location.getHost());
        String port = Window.Location.getPort();
        if (port != null && port.length() > 0) {
            url.setPort(Integer.parseInt(port));
        }
        return action.prepareRequest(new RequestBuilder(action.getMethod(),
                action.prepareUrl(url).buildString()));
    }

}
