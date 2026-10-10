package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class F implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f14656a;

    F(K k) {
        this.f14656a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14656a.f14671b.e();
            this.f14656a.a("onInterstitialAdOpened()");
        }
    }
}
