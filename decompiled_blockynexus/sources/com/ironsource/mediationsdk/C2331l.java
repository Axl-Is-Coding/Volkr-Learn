package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BannerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class C2331l extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BannerManager f14859a;

    C2331l(BannerManager bannerManager) {
        this.f14859a = bannerManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14859a.e();
    }
}
