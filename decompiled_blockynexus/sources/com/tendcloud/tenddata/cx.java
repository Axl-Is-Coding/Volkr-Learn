package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public abstract class cx {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected JSONObject f19979b = new JSONObject();

    protected void a(String str, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (a(obj)) {
                return;
            }
            this.f19979b.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public Object a_() {
        return this.f19979b;
    }

    protected void a(String str, JSONObject jSONObject) {
        if (str == null) {
            return;
        }
        try {
            if (jSONObject.has(str)) {
                jSONObject.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    protected boolean a(Object obj) {
        return obj instanceof JSONObject ? ((JSONObject) obj).length() <= 0 : (obj instanceof JSONArray) && ((JSONArray) obj).length() <= 0;
    }
}
