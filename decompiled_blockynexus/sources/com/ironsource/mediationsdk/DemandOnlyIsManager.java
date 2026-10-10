package com.ironsource.mediationsdk;

import android.util.Log;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2351f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class DemandOnlyIsManager implements InterfaceC2351f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, DemandOnlyIsSmash> f14642a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.a f14643b;

    DemandOnlyIsManager(List<com.ironsource.mediationsdk.model.p> list, com.ironsource.mediationsdk.model.h hVar, String str, String str2) {
        this.f14643b = hVar.g();
        for (com.ironsource.mediationsdk.model.p pVar : list) {
            if (pVar.i().equalsIgnoreCase("SupersonicAds") || pVar.i().equalsIgnoreCase("IronSource")) {
                AbstractC2311b abstractC2311bA = C2313c.a().a(pVar, pVar.k(), true);
                if (abstractC2311bA != null) {
                    this.f14642a.put(pVar.l(), new DemandOnlyIsSmash(str, str2, pVar, this, hVar.e(), abstractC2311bA));
                }
            } else {
                a("cannot load " + pVar.i());
            }
        }
    }

    private void logSmashCallback(DemandOnlyIsSmash demandOnlyIsSmash, String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyIsManager " + demandOnlyIsSmash.j() + " : " + str, 0);
    }

    public void a(String str, String str2, boolean z) {
        try {
            if (!this.f14642a.containsKey(str)) {
                a(2500, str);
                C.a().a(str, com.ironsource.mediationsdk.utils.g.g("Interstitial"));
                return;
            }
            DemandOnlyIsSmash demandOnlyIsSmash = this.f14642a.get(str);
            if (!z) {
                if (!demandOnlyIsSmash.s()) {
                    a(2002, demandOnlyIsSmash);
                    demandOnlyIsSmash.a("", "", null);
                    return;
                } else {
                    com.ironsource.mediationsdk.logger.b bVarC = com.ironsource.mediationsdk.utils.g.c("loadInterstitialWithAdm in non IAB flow must be called by non bidder instances");
                    a(bVarC.b());
                    a(2200, demandOnlyIsSmash);
                    C.a().a(str, bVarC);
                    return;
                }
            }
            if (!demandOnlyIsSmash.s()) {
                com.ironsource.mediationsdk.logger.b bVarC2 = com.ironsource.mediationsdk.utils.g.c("loadInterstitialWithAdm in IAB flow must be called by bidder instances");
                a(bVarC2.b());
                a(2200, demandOnlyIsSmash);
                C.a().a(str, bVarC2);
                return;
            }
            AuctionDataUtils.a aVarA = AuctionDataUtils.b().a(AuctionDataUtils.b().a(str2));
            C2325i c2325iA = AuctionDataUtils.b().a(demandOnlyIsSmash.j(), aVarA.e());
            if (c2325iA != null) {
                demandOnlyIsSmash.a(c2325iA.f());
                a(2002, demandOnlyIsSmash);
                demandOnlyIsSmash.a(c2325iA.f(), aVarA.a(), c2325iA.a());
            } else {
                com.ironsource.mediationsdk.logger.b bVarC3 = com.ironsource.mediationsdk.utils.g.c("loadInterstitialWithAdm invalid enriched adm");
                a(bVarC3.b());
                a(2200, demandOnlyIsSmash);
                C.a().a(str, bVarC3);
            }
        } catch (Exception unused) {
            com.ironsource.mediationsdk.logger.b bVarC4 = com.ironsource.mediationsdk.utils.g.c("loadInterstitialWithAdm exception");
            a(bVarC4.b());
            C.a().a(str, bVarC4);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2351f
    public void b(DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdClosed");
        a(2204, demandOnlyIsSmash, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(com.ironsource.mediationsdk.utils.m.a().a(2))}});
        com.ironsource.mediationsdk.utils.m.a().b(2);
        C.a().b(demandOnlyIsSmash.r());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2351f
    public void c(DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdClicked");
        a(AdError.INTERNAL_ERROR_2006, demandOnlyIsSmash);
        C.a().a(demandOnlyIsSmash.r());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2351f
    public void d(DemandOnlyIsSmash demandOnlyIsSmash) {
        a(2210, demandOnlyIsSmash);
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdVisible");
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2351f
    public void a(DemandOnlyIsSmash demandOnlyIsSmash, long j) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdReady");
        a(AdError.INTERNAL_ERROR_2003, demandOnlyIsSmash, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        C.a().d(demandOnlyIsSmash.r());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2351f
    public void a(com.ironsource.mediationsdk.logger.b bVar, DemandOnlyIsSmash demandOnlyIsSmash, long j) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdLoadFailed error=" + bVar.toString());
        a(2200, demandOnlyIsSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(j)}});
        C.a().a(demandOnlyIsSmash.r(), bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2351f
    public void a(DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdOpened");
        a(2005, demandOnlyIsSmash);
        C.a().c(demandOnlyIsSmash.r());
        if (demandOnlyIsSmash.s()) {
            Iterator<String> it = demandOnlyIsSmash.h.iterator();
            while (it.hasNext()) {
                AuctionDataUtils.b().e(AuctionDataUtils.b().a(it.next(), demandOnlyIsSmash.j(), demandOnlyIsSmash.o(), demandOnlyIsSmash.i, "", "", "", ""));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2351f
    public void a(com.ironsource.mediationsdk.logger.b bVar, DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdShowFailed error=" + bVar.toString());
        a(2203, demandOnlyIsSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
        C.a().b(demandOnlyIsSmash.r(), bVar);
    }

    private void a(int i, DemandOnlyIsSmash demandOnlyIsSmash) {
        a(i, demandOnlyIsSmash, (Object[][]) null);
    }

    private void a(int i, DemandOnlyIsSmash demandOnlyIsSmash, Object[][] objArr) {
        Map<String, Object> mapP = demandOnlyIsSmash.p();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapP.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, new JSONObject(mapP)));
    }

    private void a(int i, String str) {
        HashMap map = new HashMap();
        map.put(com.umeng.analytics.pro.b.L, "Mediation");
        map.put("isDemandOnly", 1);
        if (str == null) {
            str = "";
        }
        map.put("spId", str);
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, new JSONObject(map)));
    }

    private void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyIsManager " + str, 0);
    }
}
