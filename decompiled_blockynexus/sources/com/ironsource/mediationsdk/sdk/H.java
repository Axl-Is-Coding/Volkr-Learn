package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14977a;

    H(ListenersWrapper listenersWrapper) {
        this.f14977a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14977a.f14984a.onRewardedVideoAdClosed();
    }
}
