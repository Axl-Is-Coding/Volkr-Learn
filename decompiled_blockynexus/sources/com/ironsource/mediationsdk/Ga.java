package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Ga implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ La f14660a;

    Ga(La la) {
        this.f14660a = la;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14660a.f14687b.g();
            this.f14660a.a("onRewardedVideoAdStarted()");
        }
    }
}
