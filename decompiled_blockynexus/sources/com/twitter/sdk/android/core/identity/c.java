package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.l;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.n;

/* JADX INFO: compiled from: OAuthController.java */
/* JADX INFO: loaded from: classes5.dex */
class c extends com.twitter.sdk.android.core.c<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OAuthController f20140a;

    c(OAuthController oAuthController) {
        this.f20140a = oAuthController;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(k<l> kVar) {
        Intent intent = new Intent();
        l lVar = kVar.f20217a;
        intent.putExtra(FirebaseAnalytics.Param.SCREEN_NAME, lVar.f20205b);
        intent.putExtra("user_id", lVar.f20206c);
        intent.putExtra("tk", lVar.f20204a.f20267b);
        intent.putExtra("ts", lVar.f20204a.f20268c);
        this.f20140a.f20131a.a(-1, intent);
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        n.e().e("Twitter", "Failed to get access token", twitterException);
        this.f20140a.a(1, new TwitterAuthException("Failed to get access token"));
    }
}
