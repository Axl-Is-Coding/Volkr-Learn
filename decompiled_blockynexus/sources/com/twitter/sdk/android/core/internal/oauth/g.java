package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.n;

/* JADX INFO: compiled from: OAuth2Service.java */
/* JADX INFO: loaded from: classes5.dex */
class g extends com.twitter.sdk.android.core.c<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f20198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f20199b;

    g(h hVar, j jVar) {
        this.f20199b = hVar;
        this.f20198a = jVar;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<c> kVar) {
        this.f20199b.f20200a.a(new com.twitter.sdk.android.core.k(new b(this.f20198a.b(), this.f20198a.a(), kVar.f20217a.f20189a), null));
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        n.e().e("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", twitterException);
        this.f20199b.f20200a.a(twitterException);
    }
}
