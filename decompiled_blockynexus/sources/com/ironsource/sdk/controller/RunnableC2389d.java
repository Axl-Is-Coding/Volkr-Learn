package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2389d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ControllerActivity f15270a;

    RunnableC2389d(ControllerActivity controllerActivity) {
        this.f15270a = controllerActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15270a.getWindow().getDecorView().setSystemUiVisibility(com.ironsource.sdk.utils.i.a(this.f15270a.i));
    }
}
