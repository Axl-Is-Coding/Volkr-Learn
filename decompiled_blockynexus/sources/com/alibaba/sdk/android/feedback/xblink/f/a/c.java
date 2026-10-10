package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.xblink.e.a f3806d = null;

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        if (this.f3806d == null) {
            this.f3806d = this.f3803b.getUrlFilter();
        }
        String string = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WVWebUrl", "intercept: param decode error param=" + str);
            }
            try {
                string = new JSONObject(str).getString("url");
            } catch (JSONException unused2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WVWebUrl", "intercept: param parse to JSON error, param=" + str);
            }
        }
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        if (this.f3806d == null || !this.f3806d.a(string)) {
            if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WVWebUrl", "intercept: fail, url=" + string);
            }
            bVar.b(mVar);
        } else {
            if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WVWebUrl", "intercept: success, url= " + string);
            }
            bVar.a(mVar);
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"intercept".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
