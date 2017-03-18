package com.floorplanner.dispatch.core;

import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.core.client.JavaScriptObject;

public class JSOResult<T extends JavaScriptObject> implements Result {

    private final T obj;

    public JSOResult(T value) {
        this.obj = value;
    }

    public T getValue() {
        return obj;
    }

    private static final long serialVersionUID = 1L;
}
