package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f14667a;

    J(K k) {
        this.f14667a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14667a.f14671b.d();
            this.f14667a.a("onInterstitialAdClicked()");
        }
    }
}
