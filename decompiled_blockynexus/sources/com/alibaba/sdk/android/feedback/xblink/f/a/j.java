package com.alibaba.sdk.android.feedback.xblink.f.a;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j extends com.alibaba.sdk.android.feedback.xblink.f.a {
    private void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt("code");
            jSONObject.getString("msg");
            bVar.a(new com.alibaba.sdk.android.feedback.xblink.f.m());
        } catch (JSONException unused) {
            com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
            mVar.a("HY_PARAM_ERR");
            bVar.b(mVar);
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"onLoginStatus".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
