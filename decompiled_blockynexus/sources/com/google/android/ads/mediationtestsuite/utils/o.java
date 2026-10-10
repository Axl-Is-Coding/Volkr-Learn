package com.google.android.ads.mediationtestsuite.utils;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* JADX INFO: compiled from: NativeAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends AdManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private UnifiedNativeAd f12688f;

    public o(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
        super(networkConfig, adLoadCallback);
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void c() {
    }

    public UnifiedNativeAd d() {
        return this.f12688f;
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void a(Context context) {
        new AdLoader.Builder(context, this.f12663a.getAdUnitIdForTestLoad()).forUnifiedNativeAd(new n(this)).withNativeAdOptions(new NativeAdOptions.Builder().build()).withAdListener(this.f12666d).build().loadAd(this.f12665c);
    }
}
