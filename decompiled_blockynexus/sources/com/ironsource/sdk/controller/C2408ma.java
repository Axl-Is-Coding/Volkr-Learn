package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ma, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class C2408ma implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebController f15308a;

    C2408ma(WebController webController) {
        this.f15308a = webController;
    }

    @Override // com.ironsource.sdk.controller.Xa
    public void a(String str, JSONObject jSONObject) {
        this.f15308a.injectJavascript(this.f15308a.generateJSToInject(str, jSONObject.toString()));
    }
}
