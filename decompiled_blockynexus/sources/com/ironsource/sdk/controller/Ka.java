package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ka implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15169b;

    Ka(WebController.c cVar, String str) {
        this.f15169b = cVar;
        this.f15168a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15168a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        WebController.this.mOnOfferWallListener.onGetOWCreditsFailed(str);
    }
}
