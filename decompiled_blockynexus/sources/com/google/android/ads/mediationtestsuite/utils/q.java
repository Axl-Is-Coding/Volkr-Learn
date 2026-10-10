package com.google.android.ads.mediationtestsuite.utils;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* JADX INFO: compiled from: RewardedAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends AdManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RewardedVideoAdListener f12690f;
    private RewardedVideoAd g;

    public q(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
        super(networkConfig, adLoadCallback);
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void c() {
        RewardedVideoAd rewardedVideoAd = this.g;
        if (rewardedVideoAd == null || !rewardedVideoAd.isLoaded()) {
            return;
        }
        this.g.show();
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void a(Context context) {
        this.g = MobileAds.getRewardedVideoAdInstance(context);
        this.g.setRewardedVideoAdListener(new p(this));
        this.g.loadAd(this.f12663a.getAdUnitIdForTestLoad(), this.f12665c);
    }
}
