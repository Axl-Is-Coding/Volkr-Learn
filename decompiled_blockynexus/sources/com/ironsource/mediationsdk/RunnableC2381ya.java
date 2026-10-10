package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ya, reason: case insensitive filesystem */
/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2381ya implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ca f15076b;

    RunnableC2381ya(Ca ca, String str) {
        this.f15076b = ca;
        this.f15075a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15076b.f14634b.b(this.f15075a);
        this.f15076b.f("onRewardedVideoAdClosed() instanceId=" + this.f15075a);
    }
}
