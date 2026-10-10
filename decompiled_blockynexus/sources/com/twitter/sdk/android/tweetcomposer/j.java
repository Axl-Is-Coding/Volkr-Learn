package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.y;

/* JADX INFO: compiled from: TweetUploadService.java */
/* JADX INFO: loaded from: classes5.dex */
class j extends com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f20313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f20314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TweetUploadService f20315c;

    j(TweetUploadService tweetUploadService, y yVar, String str) {
        this.f20315c = tweetUploadService;
        this.f20313a = yVar;
        this.f20314b = str;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.models.h> kVar) {
        this.f20315c.a(this.f20313a, this.f20314b, kVar.f20217a.f20231a);
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        this.f20315c.a(twitterException);
    }
}
