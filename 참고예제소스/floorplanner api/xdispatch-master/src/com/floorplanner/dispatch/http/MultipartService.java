package com.floorplanner.dispatch.http;

import com.floorplanner.dispatch.core.Service;
import com.google.gwt.user.client.rpc.AsyncCallback;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public class MultipartService implements Service {

    @Override
    public <A extends Action<R>, R extends Result>
    boolean maybeExecute(A action, AsyncCallback<R> callback) {
        if (action instanceof MultipartAction) {
            MultipartAction<R> a = (MultipartAction<R>) action;
            a.execute(callback);
            return true;
        }
        return false;
    }

}
