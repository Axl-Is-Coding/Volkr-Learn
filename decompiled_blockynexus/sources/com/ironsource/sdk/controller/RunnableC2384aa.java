package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.aa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: OpenUrlActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2384aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OpenUrlActivity f15253a;

    RunnableC2384aa(OpenUrlActivity openUrlActivity) {
        this.f15253a = openUrlActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15253a.getWindow().getDecorView().setSystemUiVisibility(com.ironsource.sdk.utils.i.a(this.f15253a.j));
    }
}
