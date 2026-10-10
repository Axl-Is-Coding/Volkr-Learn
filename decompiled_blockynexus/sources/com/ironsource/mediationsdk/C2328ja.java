package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ja, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgBannerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class C2328ja extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgBannerManager f14855a;

    C2328ja(ProgBannerManager progBannerManager) {
        this.f14855a = progBannerManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14855a.n();
    }
}
