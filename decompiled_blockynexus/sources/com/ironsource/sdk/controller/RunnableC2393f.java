package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2393f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ControllerActivity f15275a;

    RunnableC2393f(ControllerActivity controllerActivity) {
        this.f15275a = controllerActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15275a.getWindow().addFlags(128);
    }
}
