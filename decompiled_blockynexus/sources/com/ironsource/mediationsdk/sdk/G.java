package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class G implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14976a;

    G(ListenersWrapper listenersWrapper) {
        this.f14976a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14976a.f14984a.onRewardedVideoAdOpened();
    }
}
