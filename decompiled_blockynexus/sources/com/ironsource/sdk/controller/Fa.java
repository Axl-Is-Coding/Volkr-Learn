package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Fa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15144c;

    Fa(WebController.c cVar, String str, String str2) {
        this.f15144c = cVar;
        this.f15142a = str;
        this.f15143b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15142a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        Log.d(WebController.this.TAG, "onBannerInitFail(message:" + str + ")");
        WebController.this.mDSBannerListener.a(SSAEnums$ProductType.Banner, this.f15143b, str);
    }
}
