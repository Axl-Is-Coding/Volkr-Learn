package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.TwitterException;

/* JADX INFO: compiled from: LoggingCallback.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class t<T> extends com.twitter.sdk.android.core.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.twitter.sdk.android.core.c f20454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.twitter.sdk.android.core.i f20455b;

    t(com.twitter.sdk.android.core.c cVar, com.twitter.sdk.android.core.i iVar) {
        this.f20454a = cVar;
        this.f20455b = iVar;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        this.f20455b.e("TweetUi", twitterException.getMessage(), twitterException);
        com.twitter.sdk.android.core.c cVar = this.f20454a;
        if (cVar != null) {
            cVar.a(twitterException);
        }
    }
}
