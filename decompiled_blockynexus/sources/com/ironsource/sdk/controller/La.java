package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class La implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SSAEnums$ProductType f15173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController.c f15175c;

    La(WebController.c cVar, SSAEnums$ProductType sSAEnums$ProductType, String str) {
        this.f15175c = cVar;
        this.f15173a = sSAEnums$ProductType;
        this.f15174b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        SSAEnums$ProductType sSAEnums$ProductType = this.f15173a;
        if (sSAEnums$ProductType != SSAEnums$ProductType.RewardedVideo && sSAEnums$ProductType != SSAEnums$ProductType.Interstitial) {
            if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWall) {
                WebController.this.mOnOfferWallListener.onOWAdClosed();
            }
        } else {
            b.f.d.g.a.a adProductListenerByProductType = WebController.this.getAdProductListenerByProductType(this.f15173a);
            if (adProductListenerByProductType != null) {
                adProductListenerByProductType.b(this.f15173a, this.f15174b);
            }
        }
    }
}
