package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ga implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15152b;

    Ga(WebController.c cVar, String str) {
        this.f15152b = cVar;
        this.f15151a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(WebController.this.TAG, "onBannerLoadSuccess()");
        WebController.this.mDSBannerListener.a(this.f15151a);
    }
}
