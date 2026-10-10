package com.google.ads.mediation.facebook;

import com.google.ads.mediation.facebook.FacebookAdapter;

/* JADX INFO: compiled from: FacebookAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class f implements FacebookAdapter.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter.a f12603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FacebookAdapter.f f12604b;

    f(FacebookAdapter.f fVar, FacebookAdapter.a aVar) {
        this.f12604b = fVar;
        this.f12603a = aVar;
    }

    @Override // com.google.ads.mediation.facebook.FacebookAdapter.e
    public void a() {
        FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 3);
    }

    @Override // com.google.ads.mediation.facebook.FacebookAdapter.e
    public void b() {
        FacebookAdapter.this.mNativeListener.onAdLoaded(FacebookAdapter.this, this.f12603a);
    }
}
