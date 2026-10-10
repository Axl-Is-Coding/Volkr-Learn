package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ca implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15125c;

    Ca(WebController.c cVar, String str, String str2) {
        this.f15125c = cVar;
        this.f15123a = str;
        this.f15124b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15123a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        WebController.this.mDSInterstitialListener.a(this.f15124b, str);
    }
}
