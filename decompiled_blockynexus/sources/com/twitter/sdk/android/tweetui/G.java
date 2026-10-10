package com.twitter.sdk.android.tweetui;

/* JADX INFO: compiled from: TweetRepository.java */
/* JADX INFO: loaded from: classes5.dex */
class G extends t<com.twitter.sdk.android.core.y> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f20328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.twitter.sdk.android.core.c f20329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ I f20330e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    G(I i, com.twitter.sdk.android.core.c cVar, com.twitter.sdk.android.core.i iVar, long j, com.twitter.sdk.android.core.c cVar2) {
        super(cVar, iVar);
        this.f20330e = i;
        this.f20328c = j;
        this.f20329d = cVar2;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.y> kVar) {
        this.f20330e.f20335a.a(kVar.f20217a).b().create(Long.valueOf(this.f20328c), false).enqueue(this.f20329d);
    }
}
