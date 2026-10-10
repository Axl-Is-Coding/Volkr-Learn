package com.google.android.ads.mediationtestsuite.utils;

import com.google.android.ads.mediationtestsuite.dataobjects.TestResult;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* JADX INFO: compiled from: NativeAdManager.java */
/* JADX INFO: loaded from: classes.dex */
class n implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f12687a;

    n(o oVar) {
        this.f12687a = oVar;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
        this.f12687a.f12688f = unifiedNativeAd;
        this.f12687a.f12663a.setLastTestResult(TestResult.SUCCESS);
        this.f12687a.f12666d.onAdLoaded();
    }
}
