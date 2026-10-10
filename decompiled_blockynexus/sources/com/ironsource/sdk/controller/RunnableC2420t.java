package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2420t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f15333b;

    RunnableC2420t(A a2, String str) {
        this.f15333b = a2;
        this.f15332a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15333b.c(this.f15332a);
    }
}
