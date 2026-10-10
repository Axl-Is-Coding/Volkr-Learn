package com.twitter.sdk.android.tweetui;

/* JADX INFO: compiled from: TweetRepository.java */
/* JADX INFO: loaded from: classes5.dex */
class H extends t<com.twitter.sdk.android.core.y> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f20332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.twitter.sdk.android.core.c f20333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ I f20334e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    H(I i, com.twitter.sdk.android.core.c cVar, com.twitter.sdk.android.core.i iVar, long j, com.twitter.sdk.android.core.c cVar2) {
        super(cVar, iVar);
        this.f20334e = i;
        this.f20332c = j;
        this.f20333d = cVar2;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.y> kVar) {
        this.f20334e.f20335a.a(kVar.f20217a).b().destroy(Long.valueOf(this.f20332c), false).enqueue(this.f20333d);
    }
}
