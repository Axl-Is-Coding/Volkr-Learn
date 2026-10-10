package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Ea implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ La f14655a;

    Ea(La la) {
        this.f14655a = la;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14655a.f14687b.onRewardedVideoAdClosed();
            this.f14655a.a("onRewardedVideoAdClosed()");
        }
    }
}
