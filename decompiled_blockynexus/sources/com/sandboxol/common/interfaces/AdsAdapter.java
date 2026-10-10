package com.sandboxol.common.interfaces;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class AdsAdapter implements IAdsAdMobListener, IAdsIronSourceListener {
    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void initAdMobAds(Context context, String str, String str2) {
    }

    public void initIronSource(Activity activity, boolean z, String str) {
    }

    public boolean isIronInterstitialLoad() {
        return false;
    }

    public boolean isIronRewardVideoLoad() {
        return false;
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public boolean isMobInterstitialLoad() {
        return false;
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public boolean isMobRewardVideoLoad() {
        return false;
    }

    public void loadIronInterstitialAd() {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void loadMobInterstitialAd() {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void loadMobRewardedVideoAd(String str) {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void onMobDestroy(Context context) {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void onMobPause(Context context) {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void onMobResume(Context context) {
    }

    public void onPause(Activity activity) {
    }

    public void onResume(Activity activity) {
    }

    public void setIronInterstitialListener(InterstitialAdapter interstitialAdapter) {
    }

    public void setIronRewardVideoListener(RewardVideoAdapter rewardVideoAdapter) {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void setMobInterstitialListener(InterstitialAdapter interstitialAdapter) {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void setMobRewardVideoListener(RewardVideoAdapter rewardVideoAdapter) {
    }

    public void showIronInterstitialAd() {
    }

    public void showIronInterstitialAd(String str) {
    }

    public void showIronRewardVideo() {
    }

    public void showIronRewardVideo(String str) {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void showMobInterstitialAd() {
    }

    @Override // com.sandboxol.common.interfaces.IAdsAdMobListener
    public void showMobRewardedVideoAd() {
    }
}
