package com.google.ads.mediation.facebook;

import android.content.Context;
import android.util.Log;
import com.google.ads.mediation.facebook.h;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;

/* JADX INFO: compiled from: FacebookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class a implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f12587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdSize f12589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediationAdRequest f12590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter f12591e;

    a(FacebookAdapter facebookAdapter, Context context, String str, AdSize adSize, MediationAdRequest mediationAdRequest) {
        this.f12591e = facebookAdapter;
        this.f12587a = context;
        this.f12588b = str;
        this.f12589c = adSize;
        this.f12590d = mediationAdRequest;
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a() {
        this.f12591e.createAndLoadBannerAd(this.f12587a, this.f12588b, this.f12589c, this.f12590d);
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a(String str) {
        Log.w(FacebookMediationAdapter.TAG, "Failed to load ad from Facebook: " + str);
        if (this.f12591e.mBannerListener != null) {
            this.f12591e.mBannerListener.onAdFailedToLoad(this.f12591e, 0);
        }
    }
}
