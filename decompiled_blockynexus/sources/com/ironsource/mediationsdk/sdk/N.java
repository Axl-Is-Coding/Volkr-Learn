package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14995b;

    N(ListenersWrapper listenersWrapper, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14995b = listenersWrapper;
        this.f14994a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14995b.f14984a.c(this.f14994a);
    }
}
