package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.xa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2429xa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15364b;

    RunnableC2429xa(WebController.c cVar, String str) {
        this.f15364b = cVar;
        this.f15363a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebController.this.mDSInterstitialListener.a(SSAEnums$ProductType.Interstitial, this.f15363a);
        WebController.this.mDSInterstitialListener.d(this.f15363a);
    }
}
