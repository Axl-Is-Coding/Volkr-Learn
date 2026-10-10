package com.ironsource.sdk.controller;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.sdk.controller.WebController;
import com.sandboxol.blockmango.config.GameStringConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdViewsJSAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2385b implements com.ironsource.sdk.ISNAdView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f15254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Xa f15255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.f.d.b.a f15256c = b.f.d.b.a.a();

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.b$a */
    /* JADX INFO: compiled from: AdViewsJSAdapter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15260d;

        private a() {
        }
    }

    public C2385b(Activity activity) {
        this.f15254a = activity;
    }

    public void a(Xa xa) {
        this.f15255b = xa;
    }

    @Override // com.ironsource.sdk.ISNAdView.d
    public void a(String str, JSONObject jSONObject) {
        if (this.f15255b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f15255b.a(str, jSONObject);
    }

    @Override // com.ironsource.sdk.ISNAdView.d
    public void a(String str, String str2, String str3) {
        a(str, com.ironsource.sdk.utils.j.a(str2, str3));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    void a(String str, WebController.c.a aVar) throws Exception {
        a aVarA = a(str);
        com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f();
        try {
            String str2 = aVarA.f15257a;
            byte b2 = -1;
            switch (str2.hashCode()) {
                case -1384357108:
                    if (str2.equals("removeAdView")) {
                        b2 = 3;
                    }
                    break;
                case 691453791:
                    if (str2.equals("sendMessage")) {
                        b2 = 1;
                    }
                    break;
                case 842351363:
                    if (str2.equals("loadWithUrl")) {
                        b2 = 0;
                    }
                    break;
                case 1633780878:
                    if (str2.equals("isExternalAdViewInitiated")) {
                        b2 = 2;
                    }
                    break;
            }
            if (b2 == 0) {
                this.f15256c.a(this, aVarA.f15258b, this.f15254a, aVarA.f15259c, aVarA.f15260d);
                return;
            }
            if (b2 == 1) {
                this.f15256c.b(aVarA.f15258b, aVarA.f15259c, aVarA.f15260d);
            } else {
                if (b2 != 2) {
                    if (b2 == 3) {
                        this.f15256c.a(aVarA.f15258b, aVarA.f15259c, aVarA.f15260d);
                        return;
                    }
                    throw new IllegalArgumentException(String.format("%s | unsupported AdViews API", aVarA.f15257a));
                }
                this.f15256c.a(aVarA.f15258b, aVarA.f15259c);
            }
        } catch (Exception e2) {
            fVar.a("errMsg", e2.getMessage());
            String strA = this.f15256c.a(aVarA.f15258b);
            if (!TextUtils.isEmpty(strA)) {
                fVar.a("adViewId", strA);
            }
            aVar.a(false, aVarA.f15260d, fVar);
        }
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f15257a = jSONObject.optString(GameStringConstant.FUNCTION_NAME);
        aVar.f15258b = jSONObject.optJSONObject("functionParams");
        aVar.f15259c = jSONObject.optString("success");
        aVar.f15260d = jSONObject.optString("fail");
        return aVar;
    }
}
