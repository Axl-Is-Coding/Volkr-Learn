package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15231c;

    V(W w, b.f.d.g.a.c cVar, com.ironsource.sdk.data.d dVar) {
        this.f15231c = w;
        this.f15229a = cVar;
        this.f15230b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15229a.b(this.f15230b.f(), this.f15231c.f15235b);
    }
}
