package com.ironsource.sdk.controller;

import android.content.Context;
import android.webkit.WebView;
import com.ironsource.sdk.controller.WebController;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OMIDJSAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15246a = "Y";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15247b;

    /* JADX INFO: compiled from: OMIDJSAdapter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15250c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15251d;

        private a() {
        }
    }

    public Y(Context context) {
        this.f15247b = context;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    void a(String str, WebController.c.a aVar, WebView webView) throws Exception {
        a aVarA = a(str);
        com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f();
        try {
            String str2 = aVarA.f15248a;
            byte b2 = -1;
            switch (str2.hashCode()) {
                case -1655974669:
                    if (str2.equals("activate")) {
                        b2 = 0;
                    }
                    break;
                case -984459207:
                    if (str2.equals("getOmidData")) {
                        b2 = 4;
                    }
                    break;
                case 70701699:
                    if (str2.equals("finishSession")) {
                        b2 = 2;
                    }
                    break;
                case 1208109646:
                    if (str2.equals("impressionOccurred")) {
                        b2 = 3;
                    }
                    break;
                case 1850541012:
                    if (str2.equals("startSession")) {
                        b2 = 1;
                    }
                    break;
            }
            if (b2 == 0) {
                b.f.d.d.a.a.a(this.f15247b);
                fVar = b.f.d.d.a.a.b();
            } else if (b2 == 1) {
                b.f.d.d.a.a.a(aVarA.f15249b, webView);
            } else if (b2 == 2) {
                b.f.d.d.a.a.a();
            } else if (b2 == 3) {
                b.f.d.d.a.a.c();
            } else {
                if (b2 != 4) {
                    throw new IllegalArgumentException(String.format("%s | unsupported OMID API", aVarA.f15248a));
                }
                fVar = b.f.d.d.a.a.b();
            }
            aVar.a(true, aVarA.f15250c, fVar);
        } catch (Exception e2) {
            fVar.a("errMsg", e2.getMessage());
            com.ironsource.sdk.utils.f.c(f15246a, "OMIDJSAdapter " + aVarA.f15248a + " Exception: " + e2.getMessage());
            aVar.a(false, aVarA.f15251d, fVar);
        }
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f15248a = jSONObject.optString("omidFunction");
        aVar.f15249b = jSONObject.optJSONObject("omidParams");
        aVar.f15250c = jSONObject.optString("success");
        aVar.f15251d = jSONObject.optString("fail");
        return aVar;
    }
}
