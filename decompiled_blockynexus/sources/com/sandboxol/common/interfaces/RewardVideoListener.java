package com.sandboxol.common.interfaces;

/* JADX INFO: loaded from: classes3.dex */
public interface RewardVideoListener extends AdsBaseListener {
    void onRewardedVideoAdClosed();

    void onRewardedVideoAdFailedToLoad();

    void onRewardedVideoAdLoaded(boolean z);

    void onRewardedVideoAdOpened();

    void onRewardedVideoCompleted();

    void onRewardedVideoStarted();
}
