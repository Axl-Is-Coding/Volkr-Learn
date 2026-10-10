package com.google.android.ads.mediationtestsuite.utils;

import android.text.TextUtils;
import com.google.android.ads.mediationtestsuite.dataobjects.TestResult;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: compiled from: RewardedAdManager.java */
/* JADX INFO: loaded from: classes.dex */
class p implements RewardedVideoAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f12689a;

    p(q qVar) {
        this.f12689a = qVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewarded(RewardItem rewardItem) {
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewarded(rewardItem);
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdClosed() {
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdFailedToLoad(int i) {
        if (this.f12689a.f12667e.booleanValue()) {
            return;
        }
        this.f12689a.f12663a.setLastTestResult(TestResult.getFailureResult(i));
        q qVar = this.f12689a;
        qVar.f12664b.onAdFailedToLoad(qVar, i);
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewardedVideoAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLeftApplication() {
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLoaded() {
        if (this.f12689a.f12667e.booleanValue() || !TextUtils.equals(this.f12689a.g.getMediationAdapterClassName(), this.f12689a.f12663a.getAdapter().getClassName())) {
            return;
        }
        this.f12689a.f12663a.setLastTestResult(TestResult.SUCCESS);
        q qVar = this.f12689a;
        qVar.f12664b.onAdLoaded(qVar);
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdOpened() {
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoCompleted() {
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewardedVideoCompleted();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoStarted() {
        if (this.f12689a.f12690f != null) {
            this.f12689a.f12690f.onRewardedVideoStarted();
        }
    }
}
