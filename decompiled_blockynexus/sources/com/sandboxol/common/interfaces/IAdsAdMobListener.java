package com.sandboxol.common.interfaces;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IAdsAdMobListener {
    void initAdMobAds(Context context, String str, String str2);

    boolean isMobInterstitialLoad();

    boolean isMobRewardVideoLoad();

    void loadMobInterstitialAd();

    void loadMobRewardedVideoAd(String str);

    void onMobDestroy(Context context);

    void onMobPause(Context context);

    void onMobResume(Context context);

    void setMobInterstitialListener(InterstitialAdapter interstitialAdapter);

    void setMobRewardVideoListener(RewardVideoAdapter rewardVideoAdapter);

    void showMobInterstitialAd();

    void showMobRewardedVideoAd();
}
