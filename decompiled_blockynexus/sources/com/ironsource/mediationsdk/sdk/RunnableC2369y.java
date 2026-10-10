package com.ironsource.mediationsdk.sdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.sdk.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2369y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f15005a;

    RunnableC2369y(ListenersWrapper listenersWrapper) {
        this.f15005a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15005a.f14985b.d();
    }
}
