package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Qa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f15205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f15206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f15207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f15208f;
    final /* synthetic */ String g;
    final /* synthetic */ String h;
    final /* synthetic */ WebController.c i;

    Qa(WebController.c cVar, String str, String str2, int i, boolean z, int i2, boolean z2, String str3, String str4) {
        this.i = cVar;
        this.f15203a = str;
        this.f15204b = str2;
        this.f15205c = i;
        this.f15206d = z;
        this.f15207e = i2;
        this.f15208f = z2;
        this.g = str3;
        this.h = str4;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f15203a.equalsIgnoreCase(SSAEnums$ProductType.RewardedVideo.toString())) {
            WebController.this.mDSRewardedVideoListener.a(this.f15204b, this.f15205c);
            return;
        }
        if (this.f15203a.equalsIgnoreCase(SSAEnums$ProductType.OfferWall.toString()) && this.f15206d && WebController.this.mOnOfferWallListener.onOWAdCredited(this.f15205c, this.f15207e, this.f15208f) && !TextUtils.isEmpty(this.g)) {
            if (com.ironsource.sdk.utils.d.d().a(this.g, WebController.this.mApplicationKey, WebController.this.mUserId)) {
                WebController.this.responseBack(this.h, true, null, null);
            } else {
                WebController.this.responseBack(this.h, false, "Time Stamp could not be stored", null);
            }
        }
    }
}
