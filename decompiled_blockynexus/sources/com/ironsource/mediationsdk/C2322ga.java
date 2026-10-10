package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.C2335n;
import com.ironsource.mediationsdk.ProgBannerManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.CappingManager;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ga, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgBannerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class C2322ga implements C2335n.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.model.f f14829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IronSourceBannerLayout f14830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProgBannerManager f14831c;

    C2322ga(ProgBannerManager progBannerManager, com.ironsource.mediationsdk.model.f fVar, IronSourceBannerLayout ironSourceBannerLayout) {
        this.f14831c = progBannerManager;
        this.f14829a = fVar;
        this.f14830b = ironSourceBannerLayout;
    }

    @Override // com.ironsource.mediationsdk.C2335n.b
    public void a(String str) {
        IronLog.API.error("can't load banner - errorMessage = " + str);
    }

    @Override // com.ironsource.mediationsdk.C2335n.b
    public void success() {
        IronLog.INTERNAL.verbose("placement = " + this.f14829a.c());
        this.f14831c.f14705e = this.f14830b;
        this.f14831c.f14706f = this.f14829a;
        if (!CappingManager.d(com.ironsource.mediationsdk.utils.c.c().b(), this.f14829a.c())) {
            this.f14831c.a(3001);
            this.f14831c.b(false);
            return;
        }
        IronLog.INTERNAL.verbose("placement is capped");
        BannerCallbackThrottler.a().a(this.f14830b, new com.ironsource.mediationsdk.logger.b(604, "placement '" + this.f14829a.c() + "' is capped"));
        this.f14831c.a(3111, new Object[][]{new Object[]{"errorCode", 604}});
        this.f14831c.a(ProgBannerManager.BannerManagerState.READY_TO_LOAD);
    }
}
