package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ua implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15228b;

    Ua(WebController.c cVar, String str) {
        this.f15228b = cVar;
        this.f15227a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebController.this.mOnOfferWallListener.onOWShowSuccess(this.f15227a);
    }
}
