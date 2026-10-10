package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ma implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SSAEnums$ProductType f15178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSONObject f15181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ WebController.c f15182e;

    Ma(WebController.c cVar, SSAEnums$ProductType sSAEnums$ProductType, String str, String str2, JSONObject jSONObject) {
        this.f15182e = cVar;
        this.f15178a = sSAEnums$ProductType;
        this.f15179b = str;
        this.f15180c = str2;
        this.f15181d = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        SSAEnums$ProductType sSAEnums$ProductType = this.f15178a;
        if (sSAEnums$ProductType != SSAEnums$ProductType.Interstitial && sSAEnums$ProductType != SSAEnums$ProductType.RewardedVideo) {
            if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWall) {
                WebController.this.mOnOfferWallListener.onOfferwallEventNotificationReceived(this.f15180c, this.f15181d);
            }
        } else {
            b.f.d.g.a.a adProductListenerByProductType = WebController.this.getAdProductListenerByProductType(this.f15178a);
            if (adProductListenerByProductType != null) {
                adProductListenerByProductType.a(this.f15178a, this.f15179b, this.f15180c, this.f15181d);
            }
        }
    }
}
