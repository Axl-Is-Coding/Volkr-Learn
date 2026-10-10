package com.ironsource.sdk.controller;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ta, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2421ta implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SSAEnums$ProductType f15334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ WebController f15337d;

    RunnableC2421ta(WebController webController, SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar, String str) {
        this.f15337d = webController;
        this.f15334a = sSAEnums$ProductType;
        this.f15335b = dVar;
        this.f15336c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        SSAEnums$ProductType sSAEnums$ProductType = SSAEnums$ProductType.RewardedVideo;
        SSAEnums$ProductType sSAEnums$ProductType2 = this.f15334a;
        if (sSAEnums$ProductType != sSAEnums$ProductType2 && SSAEnums$ProductType.Interstitial != sSAEnums$ProductType2 && SSAEnums$ProductType.Banner != sSAEnums$ProductType2) {
            if (SSAEnums$ProductType.OfferWall == sSAEnums$ProductType2) {
                this.f15337d.mOnOfferWallListener.onOfferwallInitFail(this.f15336c);
                return;
            } else {
                if (SSAEnums$ProductType.OfferWallCredits == sSAEnums$ProductType2) {
                    this.f15337d.mOnOfferWallListener.onGetOWCreditsFailed(this.f15336c);
                    return;
                }
                return;
            }
        }
        com.ironsource.sdk.data.d dVar = this.f15335b;
        if (dVar == null || TextUtils.isEmpty(dVar.f())) {
            return;
        }
        b.f.d.g.a.a adProductListenerByProductType = this.f15337d.getAdProductListenerByProductType(this.f15334a);
        Log.d(this.f15337d.TAG, "onAdProductInitFailed (message:" + this.f15336c + ")(" + this.f15334a + ")");
        if (adProductListenerByProductType != null) {
            adProductListenerByProductType.a(this.f15334a, this.f15335b.f(), this.f15336c);
        }
    }
}
