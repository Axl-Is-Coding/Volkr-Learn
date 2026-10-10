package com.twitter.sdk.android.core;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: GuestSessionProvider.java */
/* JADX INFO: loaded from: classes5.dex */
class f extends c<com.twitter.sdk.android.core.internal.oauth.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f20121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f20122b;

    f(g gVar, CountDownLatch countDownLatch) {
        this.f20122b = gVar;
        this.f20121a = countDownLatch;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(k<com.twitter.sdk.android.core.internal.oauth.b> kVar) {
        this.f20122b.f20124b.a(new e(kVar.f20217a));
        this.f20121a.countDown();
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        this.f20122b.f20124b.a(0L);
        this.f20121a.countDown();
    }
}
