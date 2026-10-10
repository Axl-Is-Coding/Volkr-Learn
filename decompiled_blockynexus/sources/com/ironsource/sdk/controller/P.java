package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class P implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.e f15195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ W f15196b;

    P(W w, b.f.d.g.e eVar) {
        this.f15196b = w;
        this.f15195a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15195a.onGetOWCreditsFailed(this.f15196b.f15235b);
    }
}
