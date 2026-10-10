package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.n;

/* JADX INFO: compiled from: OAuth2Service.java */
/* JADX INFO: loaded from: classes5.dex */
class h extends com.twitter.sdk.android.core.c<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.twitter.sdk.android.core.c f20200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OAuth2Service f20201b;

    h(OAuth2Service oAuth2Service, com.twitter.sdk.android.core.c cVar) {
        this.f20201b = oAuth2Service;
        this.f20200a = cVar;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<j> kVar) {
        j jVar = kVar.f20217a;
        this.f20201b.a(new g(this, jVar), jVar);
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        n.e().e("Twitter", "Failed to get app auth token", twitterException);
        com.twitter.sdk.android.core.c cVar = this.f20200a;
        if (cVar != null) {
            cVar.a(twitterException);
        }
    }
}
