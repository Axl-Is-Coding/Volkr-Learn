package com.ironsource.sdk.controller;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.la, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class C2406la extends com.ironsource.sdk.service.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController f15303b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2406la(WebController webController, JSONObject jSONObject, Context context) {
        super(jSONObject, context);
        this.f15303b = webController;
    }

    @Override // com.ironsource.sdk.service.a, com.ironsource.sdk.service.a.d
    public void a(String str, JSONObject jSONObject) {
        if (jSONObject == null || !this.f15303b.mIsWebControllerReady) {
            return;
        }
        try {
            jSONObject.put("connectionType", str);
            this.f15303b.sendConnectionInfoChanged(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.sdk.service.a, com.ironsource.sdk.service.a.d
    public void b(String str, JSONObject jSONObject) {
        if (this.f15303b.mIsWebControllerReady) {
            this.f15303b.sendConnectionTypeChanged(str);
        }
    }

    @Override // com.ironsource.sdk.service.a, com.ironsource.sdk.service.a.d
    public void onDisconnected() {
        if (this.f15303b.mIsWebControllerReady) {
            this.f15303b.sendConnectionTypeChanged("none");
        }
    }
}
