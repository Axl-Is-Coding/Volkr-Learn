package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f14978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14979b;

    I(ListenersWrapper listenersWrapper, boolean z) {
        this.f14979b = listenersWrapper;
        this.f14978a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14979b.f14984a.a(this.f14978a);
    }
}
