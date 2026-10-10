package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ISDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2378x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f15069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C f15070c;

    RunnableC2378x(C c2, String str, com.ironsource.mediationsdk.logger.b bVar) {
        this.f15070c = c2;
        this.f15068a = str;
        this.f15069b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15070c.f14632b.a(this.f15068a, this.f15069b);
        this.f15070c.e("onInterstitialAdLoadFailed() instanceId=" + this.f15068a + " error=" + this.f15069b.b());
    }
}
