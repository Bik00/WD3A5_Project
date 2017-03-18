package com.floorplanner.dispatch.http;

import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FormPanel;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public interface MultipartAction<R extends Result> extends Action<R> {

    public enum Action {
        GET, POST, PUT, DELETE
    };

    public enum Format {
        JSON, XML, URL_ENCODED
    };

    void execute(AsyncCallback<R> callback);

    FormPanel getForm();

    R getResult(Response response);

}
