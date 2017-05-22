package com.floorplanner.dispatch.celery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.customware.gwt.dispatch.shared.Action;

import com.floorplanner.dispatch.core.JSOResult;
import com.google.gwt.core.client.JavaScriptObject;

public interface CeleryAction<R extends JavaScriptObject> extends
        Action<JSOResult<R>> {

    public static class CeleryResult extends JavaScriptObject {

        enum Status {
            RECEIVED, RETRY, REVOKED, SUCCESS, STARTED, FAILURE, PENDING
        }

        public final native <T extends JavaScriptObject> T getResult() /*-{
            return this.result;
        }-*/;

        public final Status getStatus() {
            return Status.valueOf(getStatusNative());
        }

        private final native String getStatusNative() /*-{
            return this.status;
        }-*/;

        public final native String getTaskID() /*-{
            return this.task_id;
        }-*/;

        public final native String getTraceback() /*-{
            return this.traceback;
        }-*/;

        public final boolean isSuccess() {
            return getStatus() == Status.SUCCESS;
        }

        protected CeleryResult() {
        }

    }

    public class TaskInfo {

        String id;
        String task;
        List<Object> args = new ArrayList<Object>();
        Map<String, Object> kwargs = new HashMap<String, Object>();

        int retries = 0;
        String expires = null;
        String eta = null;

        public TaskInfo() {
            this.id = UUID.uuid();
        }

        public TaskInfo(String name) {
            this();
            this.task = name;
        }

        public TaskInfo(String name, Collection<Object> args) {
            this(name);
            args.addAll(args);
        }

        public TaskInfo(String name, Collection<Object> args,
                Map<String, Object> kwargs) {
            this(name, args);
            kwargs.putAll(kwargs);
        }

        /**
         * Adds an argument to Celery task.
         * @param arg
         */
        public void arg(Object... arg) {
            for (Object a : arg) {
                args.add(a);
            }
        }

        /**
         * Adds a keyword argument to Celery task.
         * @param kw
         * @param arg
         */
        public void kwarg(String kw, Object arg) {
            kwargs.put(kw, arg);
        }

    }

    /**
     * Exchange to publish the task. Return null for server configured default
     * exchange.
     * @return
     */
    String getExchange();

    /**
     * Object containing the name of task, and all arguments.
     * @return
     */
    TaskInfo getTaskInfo();

}
