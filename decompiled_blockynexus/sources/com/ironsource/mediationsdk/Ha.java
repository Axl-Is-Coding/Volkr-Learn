package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Ha implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ La f14662a;

    Ha(La la) {
        this.f14662a = la;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14662a.f14687b.b();
            this.f14662a.a("onRewardedVideoAdEnded()");
        }
    }
}
