package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.va, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2425va implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15349c;

    RunnableC2425va(WebController.c cVar, String str, String str2) {
        this.f15349c = cVar;
        this.f15347a = str;
        this.f15348b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15347a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        Log.d(WebController.this.TAG, "onInterstitialInitFail(message:" + str + ")");
        WebController.this.mDSInterstitialListener.a(SSAEnums$ProductType.Interstitial, this.f15348b, str);
    }
}
