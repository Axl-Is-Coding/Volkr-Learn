package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class O implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ W f15186a;

    O(W w) {
        this.f15186a = w;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15186a.f15236c.onOWShowFail(this.f15186a.f15235b);
    }
}
