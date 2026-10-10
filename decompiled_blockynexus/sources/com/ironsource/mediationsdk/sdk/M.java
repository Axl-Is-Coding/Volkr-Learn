package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.model.l f14992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14993b;

    M(ListenersWrapper listenersWrapper, com.ironsource.mediationsdk.model.l lVar) {
        this.f14993b = listenersWrapper;
        this.f14992a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14993b.f14984a.b(this.f14992a);
    }
}
