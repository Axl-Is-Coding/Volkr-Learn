package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Ka implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.model.l f14672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ La f14673b;

    Ka(La la, com.ironsource.mediationsdk.model.l lVar) {
        this.f14673b = la;
        this.f14672a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14673b.f14687b.b(this.f14672a);
            this.f14673b.a("onRewardedVideoAdClicked(" + this.f14672a + ")");
        }
    }
}
