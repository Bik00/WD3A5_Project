package com.floorplanner.dispatch.celery;

import java.util.List;
import java.util.Map;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JsUtils {

    public static JSONValue jsonValue(Object value) {
        JSONValue j = null;
        if (value instanceof Float) {
            j = new JSONNumber((Float) value);
        } else if (value instanceof Double) {
            j = new JSONNumber((Double) value);
        } else if (value instanceof Integer) {
            j = new JSONNumber((Integer) value);
        } else if (value instanceof Boolean) {
            j = JSONBoolean.getInstance((Boolean) value);
        } else if (value instanceof String) {
            j = new JSONString((String) value);
        } else if (value instanceof Object[]) {
            JSONArray jary = new JSONArray();
            Object[] ary = (Object[]) value;
            for (int i = 0; i < ary.length; i++) {
                jary.set(i, jsonValue(ary[i]));
            }
            j = jary;
        } else if (value instanceof List<?>) {
            JSONArray ary = new JSONArray();
            List<?> list = (List<?>) value;
            for (int i = 0, l = ((List<?>) value).size(); i < l; i++) {
                ary.set(i, jsonValue(list.get(i)));
            }
            j = ary;
        } else if (value instanceof Map<?, ?>) {
            JSONObject obj = new JSONObject();
            Map<?, ?> map = (Map<?, ?>) value;
            for (Map.Entry<?, ?> e : map.entrySet()) {
                obj.put(e.getKey().toString(), jsonValue(e.getValue()));
            }
            j = obj;
        } else if (value == null) {
            j = JSONNull.getInstance();
        }
        return j;
    }

}
