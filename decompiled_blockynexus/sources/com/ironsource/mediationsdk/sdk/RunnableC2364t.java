package com.ironsource.mediationsdk.sdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.sdk.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2364t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14998a;

    RunnableC2364t(ListenersWrapper listenersWrapper) {
        this.f14998a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14998a.f14985b.a();
    }
}
