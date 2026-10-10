package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Fa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f14657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ La f14658b;

    Fa(La la, boolean z) {
        this.f14658b = la;
        this.f14657a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14658b.f14687b.a(this.f14657a);
            this.f14658b.a("onRewardedVideoAvailabilityChanged() available=" + this.f14657a);
        }
    }
}
