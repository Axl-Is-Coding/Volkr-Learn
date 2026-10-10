package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.sandboxol.blockmango.config.GameStringConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BannerJSAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2387c implements com.ironsource.sdk.ISNAdView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15261a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ISNAdView f15262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Xa f15263c;

    public void a(Xa xa) {
        this.f15263c = xa;
    }

    public void a(ISNAdView iSNAdView) {
        this.f15262b = iSNAdView;
        this.f15262b.setControllerDelegate(this);
    }

    @Override // com.ironsource.sdk.ISNAdView.d
    public void a(String str, JSONObject jSONObject) {
        if (this.f15263c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f15263c.a(str, jSONObject);
    }

    @Override // com.ironsource.sdk.ISNAdView.d
    public void a(String str, String str2, String str3) {
        a(str, com.ironsource.sdk.utils.j.a(str2, str3));
    }

    void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(GameStringConstant.FUNCTION_NAME);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("functionParams");
            String strOptString2 = jSONObject.optString("success");
            String strOptString3 = jSONObject.optString("fail");
            if (TextUtils.isEmpty(strOptString)) {
                com.ironsource.sdk.utils.f.c(f15261a, "BannerJSAdapter | sendMessageToISNAdView | Invalid message format: " + str);
                return;
            }
            if (this.f15262b == null) {
                a(strOptString3, "Send message to ISNAdView failed", "");
            } else {
                this.f15262b.receiveMessageFromController(strOptString, jSONObjectOptJSONObject, strOptString2, strOptString3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
