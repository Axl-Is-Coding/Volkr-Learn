package com.google.ads.mediation.facebook;

import com.google.ads.mediation.facebook.FacebookAdapter;

/* JADX INFO: compiled from: FacebookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class e implements FacebookAdapter.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter.g f12601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter.f f12602b;

    e(FacebookAdapter.f fVar, FacebookAdapter.g gVar) {
        this.f12602b = fVar;
        this.f12601a = gVar;
    }

    @Override // com.google.ads.mediation.facebook.FacebookAdapter.e
    public void a() {
        FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 3);
    }

    @Override // com.google.ads.mediation.facebook.FacebookAdapter.e
    public void b() {
        FacebookAdapter.this.mNativeListener.onAdLoaded(FacebookAdapter.this, this.f12601a);
    }
}
