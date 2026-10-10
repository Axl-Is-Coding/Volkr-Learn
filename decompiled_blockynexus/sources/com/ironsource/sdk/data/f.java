package com.ironsource.sdk.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SSAObj.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f15398a;

    public f() {
        this.f15398a = new JSONObject();
    }

    private void f(String str) {
        try {
            this.f15398a = new JSONObject(str);
        } catch (Exception unused) {
            this.f15398a = new JSONObject();
        }
    }

    public JSONObject a() {
        return this.f15398a;
    }

    public Object b(String str) {
        try {
            return a().get(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean c(String str) {
        try {
            return this.f15398a.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public String d(String str) {
        try {
            return this.f15398a.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean e(String str) {
        return a().isNull(str);
    }

    public String toString() {
        JSONObject jSONObject = this.f15398a;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean a(String str) {
        return a().has(str);
    }

    public f(String str) {
        f(str);
    }

    public List a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(a(jSONArray.get(i)));
        }
        return arrayList;
    }

    public void a(String str, String str2) {
        try {
            this.f15398a.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            this.f15398a.put(str, jSONObject);
        } catch (Exception unused) {
        }
    }

    private Map<String, Object> a(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, a(jSONObject.get(next)));
        }
        return map;
    }

    private Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
        }
        return obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }
}
