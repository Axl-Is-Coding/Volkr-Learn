package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.C2335n;
import com.ironsource.mediationsdk.ProgBannerManager;
import com.ironsource.mediationsdk.g.c;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ha, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgBannerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class C2324ha implements C2335n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC2326ia f14844a;

    C2324ha(RunnableC2326ia runnableC2326ia) {
        this.f14844a = runnableC2326ia;
    }

    @Override // com.ironsource.mediationsdk.C2335n.a
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
        IronLog.INTERNAL.verbose("auction waterfallString = " + ((Object) sb));
        if (map.size() != 0 || list.size() != 0) {
            this.f14844a.f14851a.a(3510, new Object[][]{new Object[]{"ext1", sb.toString()}});
            if (this.f14844a.f14851a.o != null) {
                this.f14844a.f14851a.o.a(com.ironsource.mediationsdk.utils.c.c().a(), map, list, this.f14844a.f14851a.q, this.f14844a.f14851a.i, this.f14844a.f14851a.f());
                return;
            } else {
                IronLog.INTERNAL.error("mAuctionHandler is null");
                return;
            }
        }
        this.f14844a.f14851a.a(3501, new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{"duration", 0}});
        if (this.f14844a.f14851a.a(ProgBannerManager.BannerManagerState.AUCTION, ProgBannerManager.BannerManagerState.LOADED)) {
            this.f14844a.f14851a.f14704d.a((c.a) this.f14844a.f14851a);
            return;
        }
        BannerCallbackThrottler.a().a(this.f14844a.f14851a.f14705e, new com.ironsource.mediationsdk.logger.b(1005, "No candidates available for auctioning"));
        this.f14844a.f14851a.a(3111, new Object[][]{new Object[]{"errorCode", 1005}});
        this.f14844a.f14851a.a(ProgBannerManager.BannerManagerState.READY_TO_LOAD);
    }
}
