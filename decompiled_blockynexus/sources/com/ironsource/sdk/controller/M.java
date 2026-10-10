package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC2399i f15176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ W f15177b;

    M(W w, InterfaceC2399i interfaceC2399i) {
        this.f15177b = w;
        this.f15176a = interfaceC2399i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15176a.a();
    }
}
