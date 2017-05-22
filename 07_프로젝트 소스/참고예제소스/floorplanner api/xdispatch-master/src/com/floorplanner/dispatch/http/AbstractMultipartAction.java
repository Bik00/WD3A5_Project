package com.floorplanner.dispatch.http;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.HTML;
import net.customware.gwt.dispatch.shared.Result;

public abstract class AbstractMultipartAction<R extends Result> implements
        MultipartAction<R> {

    private static final HTML DUMMY = new HTML();

    protected final FormPanel form;
    private HandlerRegistration reg;

    public AbstractMultipartAction(FormPanel form) {
        this.form = form;
    }

    protected class SubmitHandler implements SubmitCompleteHandler {

        private final AsyncCallback<R> cb;

        protected SubmitHandler(AsyncCallback<R> callback) {
            this.cb = callback;
        }

        @Override
        public void onSubmitComplete(SubmitCompleteEvent event) {
            DUMMY.setHTML(event.getResults());
            if (DUMMY.getText().trim().isEmpty()) {
                cb.onSuccess(null);
            } else {
                cb.onFailure(new RequestException("Server errors"));
            }
            reg.removeHandler();
        }
    }

    @Override
    public void execute(AsyncCallback<R> callback) {
        this.reg = form.addSubmitCompleteHandler(new SubmitHandler(callback));
        form.submit();
    }

    @Override
    public FormPanel getForm() {
        return form;
    }

    private static final long serialVersionUID = 1L;
}

