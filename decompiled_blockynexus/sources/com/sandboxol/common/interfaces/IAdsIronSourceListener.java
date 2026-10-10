package com.sandboxol.common.interfaces;

import android.app.Activity;

/* JADX INFO: loaded from: classes3.dex */
public interface IAdsIronSourceListener {
    void initIronSource(Activity activity, boolean z, String str);

    boolean isIronInterstitialLoad();

    boolean isIronRewardVideoLoad();

    void loadIronInterstitialAd();

    void onPause(Activity activity);

    void onResume(Activity activity);

    void setIronInterstitialListener(InterstitialAdapter interstitialAdapter);

    void setIronRewardVideoListener(RewardVideoAdapter rewardVideoAdapter);

    void showIronInterstitialAd();

    void showIronInterstitialAd(String str);

    void showIronRewardVideo();

    void showIronRewardVideo(String str);
}
