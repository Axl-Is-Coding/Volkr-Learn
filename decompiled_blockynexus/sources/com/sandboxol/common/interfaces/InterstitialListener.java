package com.sandboxol.common.interfaces;

/* JADX INFO: loaded from: classes3.dex */
public interface InterstitialListener extends AdsBaseListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i);

    void onAdImpression();

    void onAdLeftApplication();

    void onAdLoaded();

    void onAdOpened();
}
