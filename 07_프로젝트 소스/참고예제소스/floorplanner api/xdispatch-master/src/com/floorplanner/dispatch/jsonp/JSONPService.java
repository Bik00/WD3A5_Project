package com.floorplanner.dispatch.jsonp;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.floorplanner.dispatch.core.Service;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class JSONPService implements Service {

    @SuppressWarnings({ "rawtypes", "unchecked" }) @Override 
    public <A extends Action<R>, R extends Result> boolean maybeExecute(
            A action, AsyncCallback<R> callback) {
        if (action instanceof JSONPAction) {
            JSONPAction a = (JSONPAction) action;
            try {
                a.send(callback);
            } catch (Exception e) {
                callback.onFailure(e);
            }
            return true;
        }
        return false;
    }

}
