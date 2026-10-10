package com.ironsource.sdk.controller;

/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CountDownTimerC2418s f15328a;

    r(CountDownTimerC2418s countDownTimerC2418s) {
        this.f15328a = countDownTimerC2418s;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15328a.f15330a.c("Controller download timeout");
    }
}
