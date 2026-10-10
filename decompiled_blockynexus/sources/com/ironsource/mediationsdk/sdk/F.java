package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class F implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f14974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14975b;

    F(ListenersWrapper listenersWrapper, boolean z) {
        this.f14975b = listenersWrapper;
        this.f14974a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14975b.f14986c.b(this.f14974a);
    }
}
