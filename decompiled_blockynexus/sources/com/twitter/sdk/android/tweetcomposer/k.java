package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.m;

/* JADX INFO: compiled from: TweetUploadService.java */
/* JADX INFO: loaded from: classes5.dex */
class k extends com.twitter.sdk.android.core.c<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TweetUploadService f20316a;

    k(TweetUploadService tweetUploadService) {
        this.f20316a = tweetUploadService;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<m> kVar) {
        this.f20316a.a(kVar.f20217a.getId());
        this.f20316a.stopSelf();
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        this.f20316a.a(twitterException);
    }
}
