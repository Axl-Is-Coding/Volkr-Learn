package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f14661a;

    H(K k) {
        this.f14661a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14661a.f14671b.f();
            this.f14661a.a("onInterstitialAdShowSucceeded()");
        }
    }
}
