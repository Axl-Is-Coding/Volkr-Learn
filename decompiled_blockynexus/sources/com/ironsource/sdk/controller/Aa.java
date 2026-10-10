package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15115b;

    Aa(WebController.c cVar, String str) {
        this.f15115b = cVar;
        this.f15114a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebController.this.mDSInterstitialListener.c(this.f15114a);
    }
}
