package com.floorplanner.dispatch.core;

import java.util.HashMap;
import java.util.Map;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

/**
 * Dispatcher which support caching of data in memory.
 */
public class CachingDispatchAsync implements DispatchAsync {

    private DispatchAsync dx;
    private Map<Class<?>, Result> cache = new HashMap<Class<?>, Result>();

    @Inject public CachingDispatchAsync(DispatchAsync dispatcher) {
        this.dx = dispatcher;
    }

    /**
     * Simple cache where action's class is the key.
     */
    @Override public <A extends Action<R>, R extends Result> void execute(
            final A action, final AsyncCallback<R> callback) {
        executeWithCache(action, callback);
    }

    /**
     * Execute the give Action. If the Action was executed before it will get
     * fetched from the cache
     * @param <A>
     *            Action implementation
     * @param <R>
     *            Result implementation
     * @param action
     *            the action
     * @param callback
     *            the callback
     */
    @SuppressWarnings("unchecked") public
            <A extends Action<R>, R extends Result> void executeWithCache(
                    final A action, final AsyncCallback<R> callback) {
        final Result r = cache.get(action.getClass());

        if (r != null) {
            callback.onSuccess((R) r);
        } else {
            dx.execute(action, new AsyncCallback<R>() {

                public void onFailure(Throwable caught) {
                    callback.onFailure(caught);
                }

                public void onSuccess(R result) {
                    cache.put(action.getClass(), (Result) result);
                    callback.onSuccess(result);
                }

            });
        }
    }

    /**
     * Clear the cache.
     */
    public void clear() {
        cache.clear();
    }
}
