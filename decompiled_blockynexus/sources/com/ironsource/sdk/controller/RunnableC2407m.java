package com.ironsource.sdk.controller;

import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2407m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f15305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ A f15307d;

    RunnableC2407m(A a2, com.ironsource.sdk.data.d dVar, Map map, b.f.d.g.a.c cVar) {
        this.f15307d = a2;
        this.f15304a = dVar;
        this.f15305b = map;
        this.f15306c = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15307d.f15110c.showInterstitial(this.f15304a, this.f15305b, this.f15306c);
    }
}
