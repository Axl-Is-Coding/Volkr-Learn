package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class ya implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebController.c f15368a;

    ya(WebController.c cVar) {
        this.f15368a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(WebController.this.TAG, "onOfferWallInitSuccess()");
        WebController.this.mOnOfferWallListener.onOfferwallInitSuccess();
    }
}
