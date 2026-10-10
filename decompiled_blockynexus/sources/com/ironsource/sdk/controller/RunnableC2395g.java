package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2395g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ControllerActivity f15276a;

    RunnableC2395g(ControllerActivity controllerActivity) {
        this.f15276a = controllerActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15276a.getWindow().clearFlags(128);
    }
}
