package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ra implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f15210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15211c;

    Ra(WebController.c cVar, String str, int i) {
        this.f15211c = cVar;
        this.f15209a = str;
        this.f15210b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebController.this.mDSInterstitialListener.onInterstitialAdRewarded(this.f15209a, this.f15210b);
    }
}
