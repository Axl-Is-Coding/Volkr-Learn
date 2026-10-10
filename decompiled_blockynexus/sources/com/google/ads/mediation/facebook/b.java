package com.google.ads.mediation.facebook;

import android.content.Context;
import android.util.Log;
import com.google.ads.mediation.facebook.h;
import com.google.android.gms.ads.mediation.MediationAdRequest;

/* JADX INFO: compiled from: FacebookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class b implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f12592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediationAdRequest f12594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter f12595d;

    b(FacebookAdapter facebookAdapter, Context context, String str, MediationAdRequest mediationAdRequest) {
        this.f12595d = facebookAdapter;
        this.f12592a = context;
        this.f12593b = str;
        this.f12594c = mediationAdRequest;
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a() {
        this.f12595d.createAndLoadInterstitial(this.f12592a, this.f12593b, this.f12594c);
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a(String str) {
        Log.w(FacebookMediationAdapter.TAG, "Failed to load ad from Facebook: " + str);
        if (this.f12595d.mInterstitialListener != null) {
            this.f12595d.mInterstitialListener.onAdFailedToLoad(this.f12595d, 0);
        }
    }
}
