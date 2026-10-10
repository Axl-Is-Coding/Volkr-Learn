package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class K implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15167c;

    K(W w, b.f.d.g.a.c cVar, com.ironsource.sdk.data.d dVar) {
        this.f15167c = w;
        this.f15165a = cVar;
        this.f15166b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15165a.a(this.f15166b.d(), this.f15167c.f15235b);
    }
}
