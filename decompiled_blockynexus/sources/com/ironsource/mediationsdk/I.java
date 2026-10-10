package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ K f14664b;

    I(K k, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14664b = k;
        this.f14663a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14664b.f14671b.b(this.f14663a);
            this.f14664b.a("onInterstitialAdShowFailed() error=" + this.f14663a.b());
        }
    }
}
