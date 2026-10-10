package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Pa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.a f15197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15199c;

    Pa(WebController.c cVar, com.ironsource.sdk.data.a aVar, String str) {
        this.f15199c = cVar;
        this.f15197a = aVar;
        this.f15198b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Integer.parseInt(this.f15197a.b()) <= 0) {
            WebController.this.mDSRewardedVideoListener.b(this.f15198b);
        } else {
            Log.d(WebController.this.TAG, "onRVInitSuccess()");
            WebController.this.mDSRewardedVideoListener.a(SSAEnums$ProductType.RewardedVideo, this.f15198b, this.f15197a);
        }
    }
}
