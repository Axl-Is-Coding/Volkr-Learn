package com.ironsource.sdk.utils;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: WPADUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", str);
            jSONObject.put("adViewId", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
