package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.wa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2377wa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f15066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ca f15067c;

    RunnableC2377wa(Ca ca, String str, com.ironsource.mediationsdk.logger.b bVar) {
        this.f15067c = ca;
        this.f15065a = str;
        this.f15066b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15067c.f14634b.a(this.f15065a, this.f15066b);
        this.f15067c.f("onRewardedVideoAdLoadFailed() instanceId=" + this.f15065a + "error=" + this.f15066b.b());
    }
}
