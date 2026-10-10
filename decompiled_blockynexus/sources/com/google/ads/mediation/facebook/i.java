package com.google.ads.mediation.facebook;

import com.google.ads.mediation.facebook.h;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* JADX INFO: compiled from: FacebookMediationAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class i implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InitializationCompleteCallback f12610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FacebookMediationAdapter f12611b;

    i(FacebookMediationAdapter facebookMediationAdapter, InitializationCompleteCallback initializationCompleteCallback) {
        this.f12611b = facebookMediationAdapter;
        this.f12610a = initializationCompleteCallback;
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a() {
        this.f12610a.onInitializationSucceeded();
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a(String str) {
        this.f12610a.onInitializationFailed("Initialization failed: " + str);
    }
}
