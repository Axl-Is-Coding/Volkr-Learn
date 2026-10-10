package com.ironsource.mediationsdk;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ia, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgBannerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2326ia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgBannerManager f14851a;

    RunnableC2326ia(ProgBannerManager progBannerManager) {
        this.f14851a = progBannerManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14851a.o();
        if (this.f14851a.q()) {
            return;
        }
        this.f14851a.a(3500);
        C2335n.a(this.f14851a.h(), (ConcurrentHashMap<String, ProgBannerSmash>) this.f14851a.j, new C2324ha(this));
    }
}
