package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14970b;

    C(ListenersWrapper listenersWrapper, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14970b = listenersWrapper;
        this.f14969a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14970b.f14986c.d(this.f14969a);
    }
}
