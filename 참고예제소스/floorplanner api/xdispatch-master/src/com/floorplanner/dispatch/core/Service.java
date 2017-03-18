package com.floorplanner.dispatch.core;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Service {

    <A extends Action<R>, R extends Result> boolean maybeExecute(A action,
            AsyncCallback<R> callback);

}
