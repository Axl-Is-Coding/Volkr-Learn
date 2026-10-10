package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Sa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15217c;

    Sa(WebController.c cVar, String str, String str2) {
        this.f15217c = cVar;
        this.f15215a = str;
        this.f15216b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f15215a;
        if (str == null) {
            str = "We're sorry, some error occurred. we will investigate it";
        }
        Log.d(WebController.this.TAG, "onRVInitFail(message:" + str + ")");
        WebController.this.mDSRewardedVideoListener.a(SSAEnums$ProductType.RewardedVideo, this.f15216b, str);
    }
}
