package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.model.l f14982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14983b;

    L(ListenersWrapper listenersWrapper, com.ironsource.mediationsdk.model.l lVar) {
        this.f14983b = listenersWrapper;
        this.f14982a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14983b.f14984a.a(this.f14982a);
    }
}
