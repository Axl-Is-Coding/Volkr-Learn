package com.ironsource.sdk.controller;

import android.view.ViewGroup;

/* JADX INFO: compiled from: ControllerView.java */
/* JADX INFO: loaded from: classes2.dex */
class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ControllerView f15135a;

    D(ControllerView controllerView) {
        this.f15135a = controllerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup windowDecorViewGroup = this.f15135a.getWindowDecorViewGroup();
        if (windowDecorViewGroup != null) {
            windowDecorViewGroup.removeView(this.f15135a);
        }
    }
}
