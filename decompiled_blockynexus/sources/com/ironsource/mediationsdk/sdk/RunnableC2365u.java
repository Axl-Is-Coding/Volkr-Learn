package com.ironsource.mediationsdk.sdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.sdk.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2365u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f15000b;

    RunnableC2365u(ListenersWrapper listenersWrapper, com.ironsource.mediationsdk.logger.b bVar) {
        this.f15000b = listenersWrapper;
        this.f14999a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15000b.f14985b.a(this.f14999a);
    }
}
