package com.ironsource.sdk.service;

import android.content.Context;
import android.os.Build;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConnectivityAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements com.ironsource.sdk.service.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ironsource.sdk.service.a.c f15399a;

    protected a(JSONObject jSONObject, Context context) {
        this.f15399a = a(jSONObject, context);
        com.ironsource.sdk.utils.f.c(a.class.getSimpleName(), "created ConnectivityAdapter with strategy " + this.f15399a.getClass().getSimpleName());
    }

    public JSONObject a(Context context) {
        return this.f15399a.a(context);
    }

    @Override // com.ironsource.sdk.service.a.d
    public void a(String str, JSONObject jSONObject) {
    }

    public void b(Context context) {
        this.f15399a.b(context);
    }

    @Override // com.ironsource.sdk.service.a.d
    public void b(String str, JSONObject jSONObject) {
    }

    public void c(Context context) {
        this.f15399a.c(context);
    }

    @Override // com.ironsource.sdk.service.a.d
    public void onDisconnected() {
    }

    public void a() {
        this.f15399a.release();
    }

    private com.ironsource.sdk.service.a.c a(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt("connectivityStrategy") == 1) {
            return new com.ironsource.sdk.service.a.b(this);
        }
        boolean zB = com.ironsource.environment.a.b(context, "android.permission.ACCESS_NETWORK_STATE");
        if (Build.VERSION.SDK_INT >= 23 && zB) {
            return new com.ironsource.sdk.service.a.f(this);
        }
        return new com.ironsource.sdk.service.a.b(this);
    }
}
