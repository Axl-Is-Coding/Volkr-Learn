package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f15006a;

    z(ListenersWrapper listenersWrapper) {
        this.f15006a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15006a.f14985b.c();
    }
}
