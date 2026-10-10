package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.analytics.pro.au;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3805d = "a";

    public void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        mVar.a(au.w, "android");
        mVar.a("version", "4.5.1");
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("Base", "isWindVaneSDK: version=4.5.1");
        }
        bVar.a(mVar);
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if ("isWindVaneSDK".equals(str)) {
            a(bVar, str2);
            return true;
        }
        if ("plusUT".equals(str)) {
            b(bVar, str2);
            return true;
        }
        if ("isInstall".equals(str)) {
            c(bVar, str2);
            return true;
        }
        if (!"isAppsInstalled".equals(str)) {
            return false;
        }
        d(bVar, str2);
        return true;
    }

    public void b(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("eid");
            jSONObject.getString("a1");
            jSONObject.getString("a2");
            jSONObject.getString("a3");
            if (i >= 9100 && i < 9200) {
                z = true;
            }
        } catch (JSONException unused) {
        }
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        if (!z) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("Base", "plusUT: parameter error, param=" + str);
            mVar.a("HY_PARAM_ERR");
            bVar.b(mVar);
            return;
        }
        bVar.a(mVar);
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("Base", "plusUT: param=" + str);
        }
    }

    public void c(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        String string;
        try {
            string = new JSONObject(str).getString("android");
        } catch (JSONException unused) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("Base", "isInstall parse params error, params: " + str);
            string = null;
        }
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        boolean zA = com.alibaba.sdk.android.feedback.xblink.i.a.a(this.f3802a, string);
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("Base", "isInstall " + zA + " for package " + string);
        }
        if (zA) {
            bVar.a(mVar);
        } else {
            bVar.b(mVar);
        }
    }

    public void d(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
            PackageManager packageManager = this.f3802a.getPackageManager();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    PackageInfo packageInfo = null;
                    try {
                        packageInfo = packageManager.getPackageInfo(jSONObject.getJSONObject(next).optString("android"), 0);
                    } catch (Exception unused) {
                    }
                    mVar.a(next, packageInfo == null ? "0" : "1");
                } catch (JSONException e2) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.b(f3805d, e2 + "");
                    mVar.a(next, "0");
                }
            }
            mVar.a();
            com.alibaba.sdk.android.feedback.xblink.f.c.a(bVar, mVar.b());
        } catch (JSONException e3) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b(f3805d, e3 + "");
            com.alibaba.sdk.android.feedback.xblink.f.c.b(bVar, "{}");
        }
    }
}
