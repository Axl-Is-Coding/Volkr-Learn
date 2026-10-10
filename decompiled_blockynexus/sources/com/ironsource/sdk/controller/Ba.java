package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ba implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15121c;

    Ba(WebController.c cVar, String str, String str2) {
        this.f15121c = cVar;
        this.f15119a = str;
        this.f15120b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15119a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        WebController.this.mDSInterstitialListener.b(this.f15120b, str);
    }
}
