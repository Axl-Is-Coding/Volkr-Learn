package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C f14593c;

    A(C c2, String str, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14593c = c2;
        this.f14591a = str;
        this.f14592b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14593c.f14632b.b(this.f14591a, this.f14592b);
        this.f14593c.e("onInterstitialAdShowFailed() instanceId=" + this.f14591a + " error=" + this.f14592b.b());
    }
}
