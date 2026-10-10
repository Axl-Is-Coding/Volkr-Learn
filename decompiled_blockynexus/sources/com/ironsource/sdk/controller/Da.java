package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Da implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15137b;

    Da(WebController.c cVar, String str) {
        this.f15137b = cVar;
        this.f15136a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(WebController.this.TAG, "onBannerInitSuccess()");
        WebController.this.mDSBannerListener.a(SSAEnums$ProductType.Banner, this.f15136a, (com.ironsource.sdk.data.a) null);
    }
}
