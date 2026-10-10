package com.ironsource.mediationsdk.sdk;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14980a;

    J(ListenersWrapper listenersWrapper) {
        this.f14980a = listenersWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14980a.f14984a.g();
    }
}
