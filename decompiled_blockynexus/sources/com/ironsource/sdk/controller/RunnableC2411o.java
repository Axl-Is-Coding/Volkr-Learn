package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2411o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f15316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.b f15317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f15318c;

    RunnableC2411o(A a2, JSONObject jSONObject, b.f.d.g.a.b bVar) {
        this.f15318c = a2;
        this.f15316a = jSONObject;
        this.f15317b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15318c.f15110c.loadBanner(this.f15316a, this.f15317b);
    }
}
