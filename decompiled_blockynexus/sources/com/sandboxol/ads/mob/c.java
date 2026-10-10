package com.sandboxol.ads.mob;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.sandboxol.common.interfaces.AdsAdapter;
import com.sandboxol.common.interfaces.InterstitialAdapter;
import com.sandboxol.common.interfaces.RewardVideoAdapter;

/* JADX INFO: compiled from: AdsMobUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends AdsAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f16042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RewardedVideoAd f16043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterstitialAd f16044c;

    public static c a() {
        if (f16042a == null) {
            f16042a = new c();
        }
        return f16042a;
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void initAdMobAds(Context context, String str, String str2) {
        super.initAdMobAds(context, str, str2);
        MobileAds.initialize(context, str);
        this.f16043b = MobileAds.getRewardedVideoAdInstance(context);
        this.f16044c = new InterstitialAd(context);
        this.f16044c.setAdUnitId(str2);
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public boolean isMobInterstitialLoad() {
        super.isMobInterstitialLoad();
        InterstitialAd interstitialAd = this.f16044c;
        if (interstitialAd != null) {
            return interstitialAd.isLoaded();
        }
        return false;
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public boolean isMobRewardVideoLoad() {
        super.isMobRewardVideoLoad();
        RewardedVideoAd rewardedVideoAd = this.f16043b;
        if (rewardedVideoAd != null) {
            return rewardedVideoAd.isLoaded();
        }
        return false;
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void loadMobInterstitialAd() {
        super.loadMobInterstitialAd();
        InterstitialAd interstitialAd = this.f16044c;
        if (interstitialAd != null) {
            interstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void loadMobRewardedVideoAd(String str) {
        super.loadMobRewardedVideoAd(str);
        RewardedVideoAd rewardedVideoAd = this.f16043b;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.loadAd(str, new AdRequest.Builder().build());
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void onMobDestroy(Context context) {
        super.onMobDestroy(context);
        RewardedVideoAd rewardedVideoAd = this.f16043b;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy(context);
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void onMobPause(Context context) {
        super.onMobPause(context);
        RewardedVideoAd rewardedVideoAd = this.f16043b;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.pause(context);
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void onMobResume(Context context) {
        super.onMobResume(context);
        RewardedVideoAd rewardedVideoAd = this.f16043b;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.resume(context);
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void setMobInterstitialListener(InterstitialAdapter interstitialAdapter) {
        super.setMobInterstitialListener(interstitialAdapter);
        this.f16044c.setAdListener(new b(this, interstitialAdapter));
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void setMobRewardVideoListener(RewardVideoAdapter rewardVideoAdapter) {
        super.setMobRewardVideoListener(rewardVideoAdapter);
        RewardedVideoAd rewardedVideoAd = this.f16043b;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.setRewardedVideoAdListener(new a(this, rewardVideoAdapter));
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void showMobInterstitialAd() {
        super.showMobInterstitialAd();
        InterstitialAd interstitialAd = this.f16044c;
        if (interstitialAd == null || !interstitialAd.isLoaded()) {
            return;
        }
        this.f16044c.show();
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsAdMobListener
    public void showMobRewardedVideoAd() {
        super.showMobRewardedVideoAd();
        RewardedVideoAd rewardedVideoAd = this.f16043b;
        if (rewardedVideoAd == null || !rewardedVideoAd.isLoaded()) {
            return;
        }
        this.f16043b.show();
    }
}
