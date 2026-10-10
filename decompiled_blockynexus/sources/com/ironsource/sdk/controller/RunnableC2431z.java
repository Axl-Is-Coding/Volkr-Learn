package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2431z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f15373e;

    RunnableC2431z(A a2, String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.c cVar) {
        this.f15373e = a2;
        this.f15369a = str;
        this.f15370b = str2;
        this.f15371c = dVar;
        this.f15372d = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15373e.f15110c.initInterstitial(this.f15369a, this.f15370b, this.f15371c, this.f15372d);
    }
}
