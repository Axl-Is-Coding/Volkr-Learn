package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ W f15183a;

    N(W w) {
        this.f15183a = w;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15183a.f15236c.onOfferwallInitFail(this.f15183a.f15235b);
    }
}
