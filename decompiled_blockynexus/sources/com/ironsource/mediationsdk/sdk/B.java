package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14968b;

    B(ListenersWrapper listenersWrapper, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14968b = listenersWrapper;
        this.f14967a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14968b.f14986c.e(this.f14967a);
    }
}
