package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.TwitterException;

/* JADX INFO: compiled from: ResetTweetCallback.java */
/* JADX INFO: loaded from: classes5.dex */
class w extends com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BaseTweetView f20463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final I f20464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> f20465c;

    w(BaseTweetView baseTweetView, I i, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        this.f20463a = baseTweetView;
        this.f20464b = i;
        this.f20465c = cVar;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.models.m> kVar) {
        this.f20464b.b(kVar.f20217a);
        this.f20463a.setTweet(kVar.f20217a);
        com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar = this.f20465c;
        if (cVar != null) {
            cVar.a(kVar);
        }
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar = this.f20465c;
        if (cVar != null) {
            cVar.a(twitterException);
        }
    }
}
