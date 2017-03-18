package com.floorplanner.dispatch.celery;

import static com.floorplanner.dispatch.celery.JsUtils.jsonValue;

import java.util.HashMap;
import java.util.Map;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.floorplanner.dispatch.celery.CeleryAction.CeleryResult;
import com.floorplanner.dispatch.celery.CeleryAction.CeleryResult.Status;
import com.floorplanner.dispatch.celery.CeleryAction.TaskInfo;
import com.floorplanner.dispatch.core.JSOResult;
import com.floorplanner.dispatch.core.Service;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

@SuppressWarnings({ "rawtypes", "unchecked" }) public class CeleryService
        implements Service {

    public static class CeleryException extends RuntimeException {

        protected CeleryException(String msg) {
            super(msg);
        }

        private static final long serialVersionUID = 1L;
    }

    private class ResultCallback implements AsyncCallback<CeleryResult> {

        @Override public void onFailure(Throwable caught) {
        }

        @Override public void onSuccess(CeleryResult result) {
            String taskID = result.getTaskID();
            AsyncCallback cb = callbacks.get(taskID);
            if (result.isSuccess()) {
                cb.onSuccess(new JSOResult(result.getResult()));
            } else if (result.getStatus() != Status.RETRY) {
                cb.onFailure(new CeleryException("result state was "
                        + result.getStatus().toString() + "\n\n"
                        + result.getTraceback()));
            }
            switch (result.getStatus()) {
            case RETRY:
                break;
            default:
                callbacks.remove(taskID);
            }
            if (callbacks.size() == 0) {
                socket.disconnect();
            }
        }

    }

    private static JavaScriptObject jsonTask(String exchange, TaskInfo info) {
        JSONObject task = new JSONObject();
        if (exchange != null) {
            task.put("exchange", jsonValue(exchange));
        }
        task.put("id", jsonValue(info.id));
        task.put("task", jsonValue(info.task));
        task.put("args", jsonValue(info.args));
        task.put("kwargs", jsonValue(info.kwargs));
        task.put("retries", jsonValue(info.retries));
        task.put("expires", JSONNull.getInstance());
        task.put("eta", JSONNull.getInstance());
        return task.getJavaScriptObject();
    }

    private Socket socket;
    private final String endpoint;
    private final Map<String, AsyncCallback> callbacks =
            new HashMap<String, AsyncCallback>();
    private final ResultCallback handleResult = new ResultCallback();

    public CeleryService(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override public
            <A extends Action<R>, R extends Result> boolean maybeExecute(
                    A action, AsyncCallback<R> callback) {
        if (!(action instanceof CeleryAction)) {
            return false;
        }
        ensureSocket();
        CeleryAction celer = (CeleryAction) action;
        TaskInfo info = celer.getTaskInfo();
        callbacks.put(info.id, callback);
        socket.emit("celery", jsonTask(celer.getExchange(), info));
        return true;
    }

    private void ensureSocket() {
        if (socket == null) {
            socket = Socket.connect(endpoint);
            socket.on("celery.result", handleResult);
        } else if (!socket.isConnected()) {
            socket.connect();
        }
    }

}
