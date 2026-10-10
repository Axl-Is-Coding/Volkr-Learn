package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2401j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f15291c;

    RunnableC2401j(A a2, String str, b.f.d.g.a.c cVar) {
        this.f15291c = a2;
        this.f15289a = str;
        this.f15290b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15291c.f15110c.loadInterstitial(this.f15289a, this.f15290b);
    }
}
