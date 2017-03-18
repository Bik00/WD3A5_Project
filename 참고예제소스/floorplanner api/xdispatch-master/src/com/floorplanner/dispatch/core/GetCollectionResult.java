package com.floorplanner.dispatch.core;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONParser;

public class GetCollectionResult<T extends JavaScriptObject> implements Result {

    private final JsArray<T> ary;

    public GetCollectionResult(String payload) {
        this.ary =
                JSONParser.parseStrict(payload).isArray().getJavaScriptObject()
                        .cast();
    }

    public JsArray<T> asArray() {
        return ary;
    }

    public List<T> asList() {
        List<T> result = new ArrayList<T>();
        for (int i = 0, l = ary.length(); i < l; i++) {
            result.add(ary.get(i));
        }
        return result;
    }

    private static final long serialVersionUID = 1L;
}
