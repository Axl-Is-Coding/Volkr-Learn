package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Ia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.model.l f14665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ La f14666b;

    Ia(La la, com.ironsource.mediationsdk.model.l lVar) {
        this.f14666b = la;
        this.f14665a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14666b.f14687b.a(this.f14665a);
            this.f14666b.a("onRewardedVideoAdRewarded(" + this.f14665a + ")");
        }
    }
}
