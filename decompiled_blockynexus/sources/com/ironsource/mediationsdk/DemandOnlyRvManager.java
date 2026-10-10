package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2352g;
import com.sandboxol.center.web.http.HttpCode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class DemandOnlyRvManager implements InterfaceC2352g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, DemandOnlyRvSmash> f14644a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.a f14646c;

    DemandOnlyRvManager(List<com.ironsource.mediationsdk.model.p> list, com.ironsource.mediationsdk.model.r rVar, String str, String str2) {
        this.f14645b = str;
        this.f14646c = rVar.h();
        for (com.ironsource.mediationsdk.model.p pVar : list) {
            if (pVar.i().equalsIgnoreCase("SupersonicAds") || pVar.i().equalsIgnoreCase("IronSource")) {
                AbstractC2311b abstractC2311bA = C2313c.a().a(pVar, pVar.k(), true);
                if (abstractC2311bA != null) {
                    this.f14644a.put(pVar.l(), new DemandOnlyRvSmash(str, str2, pVar, this, rVar.f(), abstractC2311bA));
                }
            } else {
                a("cannot load " + pVar.i());
            }
        }
    }

    private void logSmashCallback(DemandOnlyRvSmash demandOnlyRvSmash, String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRvManager " + demandOnlyRvSmash.j() + " : " + str, 0);
    }

    public void a(String str, String str2, boolean z) {
        try {
            if (!this.f14644a.containsKey(str)) {
                a(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, str);
                Ca.a().a(str, com.ironsource.mediationsdk.utils.g.g("Rewarded Video"));
                return;
            }
            DemandOnlyRvSmash demandOnlyRvSmash = this.f14644a.get(str);
            if (!z) {
                if (!demandOnlyRvSmash.s()) {
                    a(1001, demandOnlyRvSmash);
                    demandOnlyRvSmash.a("", "", null);
                    return;
                } else {
                    com.ironsource.mediationsdk.logger.b bVarC = com.ironsource.mediationsdk.utils.g.c("loadRewardedVideoWithAdm in non IAB flow must be called by non bidder instances");
                    a(bVarC.b());
                    a(1200, demandOnlyRvSmash);
                    Ca.a().a(str, bVarC);
                    return;
                }
            }
            if (!demandOnlyRvSmash.s()) {
                com.ironsource.mediationsdk.logger.b bVarC2 = com.ironsource.mediationsdk.utils.g.c("loadRewardedVideoWithAdm in IAB flow must be called by bidder instances");
                a(bVarC2.b());
                a(1200, demandOnlyRvSmash);
                Ca.a().a(str, bVarC2);
                return;
            }
            AuctionDataUtils.a aVarA = AuctionDataUtils.b().a(AuctionDataUtils.b().a(str2));
            C2325i c2325iA = AuctionDataUtils.b().a(demandOnlyRvSmash.j(), aVarA.e());
            if (c2325iA != null) {
                demandOnlyRvSmash.a(c2325iA.f());
                a(1001, demandOnlyRvSmash);
                demandOnlyRvSmash.a(c2325iA.f(), aVarA.a(), c2325iA.a());
            } else {
                com.ironsource.mediationsdk.logger.b bVarC3 = com.ironsource.mediationsdk.utils.g.c("loadRewardedVideoWithAdm invalid enriched adm");
                a(bVarC3.b());
                a(1200, demandOnlyRvSmash);
                Ca.a().a(str, bVarC3);
            }
        } catch (Exception e2) {
            a("loadRewardedVideoWithAdm exception " + e2.getMessage());
            Ca.a().a(str, com.ironsource.mediationsdk.utils.g.c("loadRewardedVideoWithAdm exception"));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void b(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdClicked");
        a(HttpCode.PASSWORD_NOT_SET, demandOnlyRvSmash);
        Ca.a().a(demandOnlyRvSmash.r());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void c(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdRewarded");
        Map<String, Object> mapP = demandOnlyRvSmash.p();
        if (!TextUtils.isEmpty(U.e().d())) {
            mapP.put("dynamicUserId", U.e().d());
        }
        if (U.e().j() != null) {
            for (String str : U.e().j().keySet()) {
                mapP.put("custom_" + str, U.e().j().get(str));
            }
        }
        com.ironsource.mediationsdk.model.l lVarB = U.e().c().a().e().b();
        if (lVarB != null) {
            mapP.put("placement", lVarB.c());
            mapP.put("rewardName", lVarB.e());
            mapP.put("rewardAmount", Integer.valueOf(lVarB.d()));
        } else {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "defaultPlacement is null", 3);
        }
        b.f.b.b bVar = new b.f.b.b(1010, new JSONObject(mapP));
        bVar.a("transId", com.ironsource.mediationsdk.utils.j.b("" + Long.toString(bVar.d()) + this.f14645b + demandOnlyRvSmash.j()));
        com.ironsource.mediationsdk.b.k.g().c(bVar);
        Ca.a().d(demandOnlyRvSmash.r());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void d(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdVisible");
        a(1206, demandOnlyRvSmash);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void e(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdOpened");
        a(1005, demandOnlyRvSmash);
        Ca.a().c(demandOnlyRvSmash.r());
        if (demandOnlyRvSmash.s()) {
            Iterator<String> it = demandOnlyRvSmash.h.iterator();
            while (it.hasNext()) {
                AuctionDataUtils.b().e(AuctionDataUtils.b().a(it.next(), demandOnlyRvSmash.j(), demandOnlyRvSmash.o(), demandOnlyRvSmash.i, "", "", "", ""));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void a(DemandOnlyRvSmash demandOnlyRvSmash, long j) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoLoadSuccess");
        a(1002, demandOnlyRvSmash, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        Ca.a().e(demandOnlyRvSmash.r());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void a(com.ironsource.mediationsdk.logger.b bVar, DemandOnlyRvSmash demandOnlyRvSmash, long j) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdLoadFailed error=" + bVar);
        a(1200, demandOnlyRvSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(j)}});
        a(1212, demandOnlyRvSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(j)}});
        Ca.a().a(demandOnlyRvSmash.r(), bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void a(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdClosed");
        a(1203, demandOnlyRvSmash, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(com.ironsource.mediationsdk.utils.m.a().a(1))}});
        com.ironsource.mediationsdk.utils.m.a().b(1);
        Ca.a().b(demandOnlyRvSmash.r());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2352g
    public void a(com.ironsource.mediationsdk.logger.b bVar, DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdShowFailed error=" + bVar);
        a(1202, demandOnlyRvSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}});
        Ca.a().b(demandOnlyRvSmash.r(), bVar);
    }

    private void a(int i, DemandOnlyRvSmash demandOnlyRvSmash) {
        a(i, demandOnlyRvSmash, (Object[][]) null);
    }

    private void a(int i, DemandOnlyRvSmash demandOnlyRvSmash, Object[][] objArr) {
        Map<String, Object> mapP = demandOnlyRvSmash.p();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapP.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "RV sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, new JSONObject(mapP)));
    }

    private void a(int i, String str) {
        HashMap map = new HashMap();
        map.put(com.umeng.analytics.pro.b.L, "Mediation");
        map.put("isDemandOnly", 1);
        if (str == null) {
            str = "";
        }
        map.put("spId", str);
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, new JSONObject(map)));
    }

    private void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRvManager " + str, 0);
    }
}
