package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Va implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15233b;

    Va(WebController.c cVar, String str) {
        this.f15233b = cVar;
        this.f15232a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15232a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        WebController.this.mOnOfferWallListener.onOWShowFail(str);
    }
}
