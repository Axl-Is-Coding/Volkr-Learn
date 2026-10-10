package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: IronSourceBannerLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class Q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IronSourceBannerLayout f14721b;

    Q(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14721b = ironSourceBannerLayout;
        this.f14720a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14721b.mIsBannerDisplayed) {
            this.f14721b.mBannerListener.d(this.f14720a);
            return;
        }
        try {
            if (this.f14721b.mBannerView != null) {
                this.f14721b.removeView(this.f14721b.mBannerView);
                this.f14721b.mBannerView = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f14721b.mBannerListener != null) {
            this.f14721b.mBannerListener.d(this.f14720a);
        }
    }
}
