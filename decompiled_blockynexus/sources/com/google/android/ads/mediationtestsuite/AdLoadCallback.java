package com.google.android.ads.mediationtestsuite;

import com.google.android.ads.mediationtestsuite.utils.AdManager;

/* JADX INFO: loaded from: classes.dex */
public interface AdLoadCallback {
    void onAdFailedToLoad(AdManager adManager, int i);

    void onAdLoaded(AdManager adManager);
}
