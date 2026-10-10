package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2413p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f15320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f15321b;

    RunnableC2413p(A a2, JSONObject jSONObject) {
        this.f15321b = a2;
        this.f15320a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15321b.f15110c.updateConsentInfo(this.f15320a);
    }
}
