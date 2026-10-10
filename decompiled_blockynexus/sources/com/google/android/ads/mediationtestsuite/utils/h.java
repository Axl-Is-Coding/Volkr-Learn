package com.google.android.ads.mediationtestsuite.utils;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.gms.ads.InterstitialAd;

/* JADX INFO: compiled from: InterstitialAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends AdManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InterstitialAd f12674f;

    public h(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
        super(networkConfig, adLoadCallback);
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void a(Context context) {
        if (this.f12674f == null) {
            this.f12674f = new InterstitialAd(context);
        }
        this.f12674f.setAdUnitId(this.f12663a.getAdUnitIdForTestLoad());
        this.f12674f.setAdListener(this.f12666d);
        this.f12674f.loadAd(this.f12665c);
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void c() {
        InterstitialAd interstitialAd = this.f12674f;
        if (interstitialAd == null || !interstitialAd.isLoaded()) {
            return;
        }
        this.f12674f.show();
    }
}
