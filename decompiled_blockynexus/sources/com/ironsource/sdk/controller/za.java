package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class za implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15375b;

    za(WebController.c cVar, String str) {
        this.f15375b = cVar;
        this.f15374a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15374a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        Log.d(WebController.this.TAG, "onOfferWallInitFail(message:" + str + ")");
        WebController.this.mOnOfferWallListener.onOfferwallInitFail(str);
    }
}
