package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14966a;

    A(ListenersWrapper listenersWrapper) {
        this.f14966a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14966a.f14986c.h();
    }
}
