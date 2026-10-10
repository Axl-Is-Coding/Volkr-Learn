package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ua, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2423ua implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15344b;

    RunnableC2423ua(WebController.c cVar, String str) {
        this.f15344b = cVar;
        this.f15343a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(WebController.this.TAG, "onInterstitialInitSuccess()");
        WebController.this.mDSInterstitialListener.a(SSAEnums$ProductType.Interstitial, this.f15343a, (com.ironsource.sdk.data.a) null);
    }
}
