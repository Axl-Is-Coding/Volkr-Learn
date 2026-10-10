package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class K implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14981a;

    K(ListenersWrapper listenersWrapper) {
        this.f14981a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14981a.f14984a.b();
    }
}
