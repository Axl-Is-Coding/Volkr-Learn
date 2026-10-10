package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class za implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f15080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ca f15081c;

    za(Ca ca, String str, com.ironsource.mediationsdk.logger.b bVar) {
        this.f15081c = ca;
        this.f15079a = str;
        this.f15080b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15081c.f14634b.b(this.f15079a, this.f15080b);
        this.f15081c.f("onRewardedVideoAdShowFailed() instanceId=" + this.f15079a + "error=" + this.f15080b.b());
    }
}
