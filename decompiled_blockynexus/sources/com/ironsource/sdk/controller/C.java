package com.ironsource.sdk.controller;

import android.view.ViewGroup;

/* JADX INFO: compiled from: ControllerView.java */
/* JADX INFO: loaded from: classes2.dex */
class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ControllerView f15122a;

    C(ControllerView controllerView) {
        this.f15122a = controllerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup windowDecorViewGroup = this.f15122a.getWindowDecorViewGroup();
        if (windowDecorViewGroup != null) {
            windowDecorViewGroup.addView(this.f15122a);
        }
    }
}
