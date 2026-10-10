package com.google.android.ads.mediationtestsuite.utils;

import com.google.android.ads.mediationtestsuite.dataobjects.TestResult;
import com.google.android.gms.ads.AdListener;

/* JADX INFO: compiled from: AdManager.java */
/* JADX INFO: loaded from: classes.dex */
class a extends AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdManager f12668a;

    a(AdManager adManager) {
        this.f12668a = adManager;
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
        if (this.f12668a.f12667e.booleanValue()) {
            return;
        }
        this.f12668a.f12663a.setLastTestResult(TestResult.getFailureResult(i));
        AdManager adManager = this.f12668a;
        adManager.f12664b.onAdFailedToLoad(adManager, i);
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        if (this.f12668a.f12667e.booleanValue()) {
            return;
        }
        this.f12668a.f12663a.setLastTestResult(TestResult.SUCCESS);
        AdManager adManager = this.f12668a;
        adManager.f12664b.onAdLoaded(adManager);
    }
}
