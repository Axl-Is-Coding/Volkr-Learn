package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BannerCallbackThrottler.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2327j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IronSourceBannerLayout f14852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BannerCallbackThrottler f14854c;

    RunnableC2327j(BannerCallbackThrottler bannerCallbackThrottler, IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14854c = bannerCallbackThrottler;
        this.f14852a = ironSourceBannerLayout;
        this.f14853b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14854c.invokeCallback(this.f14852a, this.f14853b);
    }
}
