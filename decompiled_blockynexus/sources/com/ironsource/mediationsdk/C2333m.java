package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.BannerSmash;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BannerSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class C2333m extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BannerSmash f14868a;

    C2333m(BannerSmash bannerSmash) {
        this.f14868a = bannerSmash;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        cancel();
        if (this.f14868a.f14629e == BannerSmash.BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
            this.f14868a.a(BannerSmash.BANNER_SMASH_STATE.NO_INIT);
            this.f14868a.a("init timed out");
            this.f14868a.f14630f.a(new com.ironsource.mediationsdk.logger.b(607, "Timed out"), this.f14868a, false);
        } else if (this.f14868a.f14629e == BannerSmash.BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
            this.f14868a.a(BannerSmash.BANNER_SMASH_STATE.LOAD_FAILED);
            this.f14868a.a("load timed out");
            this.f14868a.f14630f.a(new com.ironsource.mediationsdk.logger.b(608, "Timed out"), this.f14868a, false);
        } else if (this.f14868a.f14629e == BannerSmash.BANNER_SMASH_STATE.LOADED) {
            this.f14868a.a(BannerSmash.BANNER_SMASH_STATE.LOAD_FAILED);
            this.f14868a.a("reload timed out");
            this.f14868a.f14630f.b(new com.ironsource.mediationsdk.logger.b(609, "Timed out"), this.f14868a, false);
        }
    }
}
