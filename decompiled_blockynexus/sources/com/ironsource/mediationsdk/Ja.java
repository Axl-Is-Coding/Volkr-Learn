package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ La f14669b;

    Ja(La la, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14669b = la;
        this.f14668a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14669b.f14687b.c(this.f14668a);
            this.f14669b.a("onRewardedVideoAdShowFailed() error=" + this.f14668a.b());
        }
    }
}
