package com.ironsource.sdk.ISNAdView;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNAdViewLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends JSONObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f15094a;

    f(h hVar) throws Error, RuntimeException {
        this.f15094a = hVar;
        try {
            put("configs", this.f15094a.a(this.f15094a.f15098b, this.f15094a.f15100d.a()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
