package com.floorplanner.dispatch.core;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class XDispatch implements DispatchAsync {

    private final ServiceSet services;

    @Inject XDispatch(ServiceSet services) {
        this.services = services;
    }

    public <A extends Action<R>, R extends Result> void execute(A action,
            AsyncCallback<R> callback) {
        for (Service s : services) {
            if (s.maybeExecute(action, callback)) {
                break;
            }
        }
    }

}
