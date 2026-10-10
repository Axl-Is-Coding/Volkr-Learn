package com.ironsource.mediationsdk.sdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.sdk.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2367w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f15002a;

    RunnableC2367w(ListenersWrapper listenersWrapper) {
        this.f15002a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15002a.f14985b.f();
    }
}
