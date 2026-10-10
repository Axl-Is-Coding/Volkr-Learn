package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2405l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f15300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f15302c;

    RunnableC2405l(A a2, JSONObject jSONObject, b.f.d.g.a.c cVar) {
        this.f15302c = a2;
        this.f15300a = jSONObject;
        this.f15301b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15302c.f15110c.showInterstitial(this.f15300a, this.f15301b);
    }
}
