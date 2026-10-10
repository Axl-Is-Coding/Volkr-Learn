package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ha implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15158c;

    Ha(WebController.c cVar, String str, String str2) {
        this.f15158c = cVar;
        this.f15156a = str;
        this.f15157b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(WebController.this.TAG, "onLoadBannerFail()");
        String str = this.f15156a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        WebController.this.mDSBannerListener.c(this.f15157b, str);
    }
}
