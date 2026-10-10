package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class E implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ K f14654b;

    E(K k, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14654b = k;
        this.f14653a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14654b.f14671b.a(this.f14653a);
            this.f14654b.a("onInterstitialAdLoadFailed() error=" + this.f14653a.b());
        }
    }
}
