package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class U implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15226c;

    U(W w, b.f.d.g.a.c cVar, String str) {
        this.f15226c = w;
        this.f15224a = cVar;
        this.f15225b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15224a.b(this.f15225b, this.f15226c.f15235b);
    }
}
