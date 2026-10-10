package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f14640a;

    D(K k) {
        this.f14640a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14640a.f14671b.a();
            this.f14640a.a("onInterstitialAdReady()");
        }
    }
}
