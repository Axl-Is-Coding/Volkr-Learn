package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ta implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15223c;

    Ta(WebController.c cVar, String str, String str2) {
        this.f15223c = cVar;
        this.f15221a = str;
        this.f15222b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15221a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        Log.d(WebController.this.TAG, "onRVShowFail(message:" + this.f15221a + ")");
        WebController.this.mDSRewardedVideoListener.d(this.f15222b, str);
    }
}
