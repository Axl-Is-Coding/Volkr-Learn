package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.sandboxol.blockmango.config.GameStringConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ControllerMessageHandler.java */
/* JADX INFO: loaded from: classes2.dex */
final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15116a = "com.ironsource.sdk.controller.B";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2397h f15117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2392ea f15118c;

    B(C2397h c2397h, C2392ea c2392ea) {
        this.f15117b = c2397h;
        this.f15118c = c2392ea;
    }

    private void a(Exception exc) {
        exc.printStackTrace();
        com.ironsource.sdk.utils.f.c(f15116a, "messageHandler failed with exception " + exc.getMessage());
    }

    private void b(String str, String str2, String str3) {
        this.f15117b.a(a(str, str2, str3));
    }

    @JavascriptInterface
    public void messageHandler(String str, String str2, String str3) {
        try {
            com.ironsource.sdk.utils.f.c(f15116a, "messageHandler(" + str + " " + str3 + ")");
            if (this.f15118c.a(str, str2, str3)) {
                a(str, str2);
            } else {
                b(str, str2, str3);
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void a(String str, String str2) throws Exception {
        this.f15117b.a(str, str2);
    }

    private String a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(GameStringConstant.FUNCTION_NAME, com.ironsource.sdk.utils.i.b(str));
            jSONObject.put(NativeProtocol.WEB_DIALOG_PARAMS, com.ironsource.sdk.utils.i.b(str2));
            jSONObject.put("hash", com.ironsource.sdk.utils.i.b(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
