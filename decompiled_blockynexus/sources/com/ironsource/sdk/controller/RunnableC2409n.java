package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2409n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.b f15312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f15313e;

    RunnableC2409n(A a2, String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.b bVar) {
        this.f15313e = a2;
        this.f15309a = str;
        this.f15310b = str2;
        this.f15311c = dVar;
        this.f15312d = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15313e.f15110c.initBanner(this.f15309a, this.f15310b, this.f15311c, this.f15312d);
    }
}
