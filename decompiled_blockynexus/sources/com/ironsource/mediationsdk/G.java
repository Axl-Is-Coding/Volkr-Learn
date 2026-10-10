package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class G implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f14659a;

    G(K k) {
        this.f14659a = k;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14659a.f14671b.c();
            this.f14659a.a("onInterstitialAdClosed()");
        }
    }
}
