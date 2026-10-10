package com.google.android.ads.mediationtestsuite.utils;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* JADX INFO: compiled from: BannerAdManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends AdManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AdView f12672f;

    public e(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
        super(networkConfig, adLoadCallback);
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void a(Context context) {
        if (this.f12672f == null) {
            this.f12672f = new AdView(context);
        }
        this.f12672f.setAdUnitId(this.f12663a.getAdUnitIdForTestLoad());
        this.f12672f.setAdSize(AdSize.BANNER);
        this.f12672f.setAdListener(this.f12666d);
        this.f12672f.loadAd(this.f12665c);
    }

    @Override // com.google.android.ads.mediationtestsuite.utils.AdManager
    public void c() {
    }

    public AdView d() {
        return this.f12672f;
    }
}
