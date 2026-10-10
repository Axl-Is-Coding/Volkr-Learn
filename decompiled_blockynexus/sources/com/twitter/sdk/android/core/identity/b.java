package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.l;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.n;

/* JADX INFO: compiled from: OAuthController.java */
/* JADX INFO: loaded from: classes5.dex */
class b extends com.twitter.sdk.android.core.c<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OAuthController f20139a;

    b(OAuthController oAuthController) {
        this.f20139a = oAuthController;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(k<l> kVar) {
        OAuthController oAuthController = this.f20139a;
        oAuthController.f20132b = kVar.f20217a.f20204a;
        String strA = oAuthController.f20136f.a(this.f20139a.f20132b);
        n.e().d("Twitter", "Redirecting user to web view to complete authorization flow");
        OAuthController oAuthController2 = this.f20139a;
        oAuthController2.a(oAuthController2.f20134d, new f(this.f20139a.f20136f.a(this.f20139a.f20135e), this.f20139a), strA, new e());
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        n.e().e("Twitter", "Failed to get request token", twitterException);
        this.f20139a.a(1, new TwitterAuthException("Failed to get request token"));
    }
}
