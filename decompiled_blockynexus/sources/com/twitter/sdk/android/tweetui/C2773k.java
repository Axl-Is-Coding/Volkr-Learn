package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.TwitterException;
import java.util.Locale;

/* JADX INFO: renamed from: com.twitter.sdk.android.tweetui.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BaseTweetView.java */
/* JADX INFO: loaded from: classes5.dex */
class C2773k extends com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f20434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseTweetView f20435b;

    C2773k(BaseTweetView baseTweetView, long j) {
        this.f20435b = baseTweetView;
        this.f20434a = j;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.models.m> kVar) {
        this.f20435b.setTweet(kVar.f20217a);
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        com.twitter.sdk.android.core.n.e().d("TweetUi", String.format(Locale.ENGLISH, "loadTweet failure for Tweet Id %d.", Long.valueOf(this.f20434a)));
    }
}
