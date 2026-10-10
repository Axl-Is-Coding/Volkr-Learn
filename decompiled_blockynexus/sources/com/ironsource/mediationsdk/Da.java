package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Da implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ La f14641a;

    Da(La la) {
        this.f14641a = la;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f14641a.f14687b.onRewardedVideoAdOpened();
            this.f14641a.a("onRewardedVideoAdOpened()");
        }
    }
}
