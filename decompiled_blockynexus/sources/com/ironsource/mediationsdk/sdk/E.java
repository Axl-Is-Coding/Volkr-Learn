package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class E implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14973a;

    E(ListenersWrapper listenersWrapper) {
        this.f14973a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14973a.f14986c.i();
    }
}
