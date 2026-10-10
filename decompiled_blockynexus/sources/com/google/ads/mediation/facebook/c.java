package com.google.ads.mediation.facebook;

import android.content.Context;
import android.util.Log;
import com.google.ads.mediation.facebook.h;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

/* JADX INFO: compiled from: FacebookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class c implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f12596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NativeMediationAdRequest f12598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter f12599d;

    c(FacebookAdapter facebookAdapter, Context context, String str, NativeMediationAdRequest nativeMediationAdRequest) {
        this.f12599d = facebookAdapter;
        this.f12596a = context;
        this.f12597b = str;
        this.f12598c = nativeMediationAdRequest;
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a() {
        this.f12599d.createAndLoadNativeAd(this.f12596a, this.f12597b, this.f12598c);
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a(String str) {
        Log.w(FacebookMediationAdapter.TAG, "Failed to load ad from Facebook: " + str);
        if (this.f12599d.mNativeListener != null) {
            this.f12599d.mNativeListener.onAdFailedToLoad(this.f12599d, 0);
        }
    }
}
