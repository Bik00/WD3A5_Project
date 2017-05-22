package com.floorplanner.dispatch.http;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FormPanel;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SignedMultipartService extends MultipartService {

    public interface Signatory {

        /**
         * Add signature to the form.
         * @param form
         */
        void sign(FormPanel form);

        /**
         * Removes signature from the form.
         * @param form
         */
        void clean(FormPanel form);

    }

    private final List<Signatory> signatories = new ArrayList<Signatory>();

    public SignedMultipartService(Signatory... signatories) {
        Collections.addAll(this.signatories, signatories);
    }

    public void add(Signatory signatory) {
        signatories.add(signatory);
    }

    @Override
    public <A extends Action<R>, R extends Result>
    boolean maybeExecute(A action, AsyncCallback<R> callback) {
        if (action instanceof MultipartAction) {
            MultipartAction<R> a = (MultipartAction<R>) action;

            for (Signatory s: signatories) {
                s.sign(a.getForm());
            }
            a.execute(callback);
            for (Signatory s: signatories) {
                s.clean(a.getForm());
            }

            return true;
        }
        return false;
    }

}
