package com.floorplanner.dispatch.celery;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Socket {

    private static class SocketJSO extends JavaScriptObject {

        protected SocketJSO() {
        }

        private static final native SocketJSO connect(String endpoint) /*-{
            var sock = $wnd.io.connect(endpoint);
            return sock;
        }-*/;

        private final native void connect() /*-{
            this.socket.connect();
        }-*/;

        private final native void disconnect() /*-{
            this.disconnect();
        }-*/;
        
        private final native boolean isConnected() /*-{
            return this.socket.connected;
        }-*/;

        private final native <T extends JavaScriptObject> void on(
                String event, AsyncCallback<T> cb) /*-{
            this.on(event, function(data) {
                cb.@com.google.gwt.user.client.rpc.AsyncCallback::onSuccess(Ljava/lang/Object;)(data);
            });
        }-*/;

        private final native void emit(String event, JavaScriptObject data) /*-{
            this.emit(event, data);
        }-*/;

    }

    public static Socket connect(String endpoint) {
        return new Socket(endpoint);
    }

    private SocketJSO jso;

    protected Socket(String endpoint) {
        this.jso = SocketJSO.connect(endpoint);
    }

    public void connect() {
        jso.connect();
    }

    public void disconnect() {
        jso.disconnect();
    }

    public void emit(String event, JavaScriptObject data) {
        jso.emit(event, data);
    }

    public boolean isConnected() {
        return jso.isConnected();
    }

    public <T extends JavaScriptObject> void on(
            String event, AsyncCallback<T> cb) {
        jso.on(event, cb);
    }

}
