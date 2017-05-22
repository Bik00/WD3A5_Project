package com.floorplanner.dispatch.http;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.user.client.Window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SignedHTTPService extends HTTPService {

    public interface Signatory {

        RequestBuilder sign(RequestBuilder request);

        UrlBuilder sign(UrlBuilder url);

    }

    private final List<Signatory> signatories = new ArrayList<Signatory>();

    public SignedHTTPService(Signatory... signatories) {
        Collections.addAll(this.signatories, signatories);
    }

    public void add(Signatory signatory) {
        signatories.add(signatory);
    }

    @Override
    protected RequestBuilder prepareRequest(HTTPAction<?> action) {
        UrlBuilder url = new UrlBuilder();
        url.setProtocol(Window.Location.getProtocol());
        url.setHost(Window.Location.getHost());
        String port = Window.Location.getPort();
        if (port != null && port.length() > 0) {
            url.setPort(Integer.parseInt(port));
        }

        for (Signatory sig: signatories) {
            sig.sign(url);
        }

        RequestBuilder request = action.prepareRequest(new RequestBuilder(
                action.getMethod(), action.prepareUrl(url).buildString()));

        for (Signatory sig: signatories) {
            sig.sign(request);
        }

        return request;
    }

}
