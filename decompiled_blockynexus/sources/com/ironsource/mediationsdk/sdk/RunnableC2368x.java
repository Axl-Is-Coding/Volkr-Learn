package com.ironsource.mediationsdk.sdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.sdk.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2368x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f15003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f15004b;

    RunnableC2368x(ListenersWrapper listenersWrapper, com.ironsource.mediationsdk.logger.b bVar) {
        this.f15004b = listenersWrapper;
        this.f15003a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15004b.f14985b.b(this.f15003a);
    }
}
