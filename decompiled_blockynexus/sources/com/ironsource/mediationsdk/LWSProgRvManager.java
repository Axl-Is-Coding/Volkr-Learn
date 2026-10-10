package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.sandboxol.center.config.IntConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class LWSProgRvManager extends AbstractC2337o implements NetworkStateReceiver.a, Ua, InterfaceC2310aa, InterfaceC2321g, InterfaceC2372u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Ya f14680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, C2325i> f14681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> f14682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C2325i f14683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AuctionHistory f14684f;
    private C2323h g;
    private Ta h;
    private boolean i;
    private long j;
    private String k;
    private int l;
    private NetworkStateReceiver m;
    private boolean n;
    private final ConcurrentHashMap<String, LWSProgRvSmash> o;
    private com.ironsource.mediationsdk.utils.l p;
    private int q;
    private String r;
    private int s;
    private boolean t;
    private boolean u;
    private RV_MEDIATION_STATE v;
    private long w;
    private Boolean x;
    private final Object y;

    private enum RV_MEDIATION_STATE {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public LWSProgRvManager(List<com.ironsource.mediationsdk.model.p> list, com.ironsource.mediationsdk.model.r rVar, String str, String str2, com.ironsource.mediationsdk.c.c cVar) {
        super(cVar);
        this.k = "";
        this.n = false;
        this.q = 1;
        this.y = new Object();
        long time = new Date().getTime();
        b(81312);
        a(RV_MEDIATION_STATE.RV_STATE_INITIATING);
        this.x = null;
        this.s = rVar.e();
        this.t = rVar.g();
        this.r = "";
        com.ironsource.mediationsdk.utils.a aVarH = rVar.h();
        this.u = false;
        this.f14680b = new Ya(rVar.h().g(), rVar.h().i());
        this.f14681c = new ConcurrentHashMap<>();
        this.f14682d = new ConcurrentHashMap<>();
        this.w = new Date().getTime();
        this.i = aVarH.h() > 0;
        if (this.i) {
            this.g = new C2323h("rewardedVideo", aVarH, this);
        }
        this.h = new Ta(aVarH, this);
        this.o = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        for (com.ironsource.mediationsdk.model.p pVar : list) {
            AbstractC2311b abstractC2311bA = C2313c.a().a(pVar, pVar.k());
            if (abstractC2311bA != null) {
                LWSProgRvSmash lWSProgRvSmash = new LWSProgRvSmash(str, str2, pVar, this, rVar.f(), abstractC2311bA, this.q);
                String strR = lWSProgRvSmash.r();
                this.o.put(strR, lWSProgRvSmash);
                arrayList.add(strR);
            }
        }
        this.f14684f = new AuctionHistory(arrayList, aVarH.c());
        this.p = new com.ironsource.mediationsdk.utils.l(new ArrayList(this.o.values()));
        c(81313, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
        a(aVarH.k());
    }

    private boolean c(int i) {
        return i == 1003 || i == 1302 || i == 1301;
    }

    private void logSmashCallback(LWSProgRvSmash lWSProgRvSmash, String str) {
        String str2 = lWSProgRvSmash.r() + " : " + str;
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this.y) {
            if (this.v != RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS) {
                a(RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS);
                AsyncTask.execute(new Y(this));
            }
        }
    }

    private void h() {
        a(d(), "fallback_" + System.currentTimeMillis());
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void c(LWSProgRvSmash lWSProgRvSmash) {
        logSmashCallback(lWSProgRvSmash, "onRewardedVideoAdClosed, mediation state: " + this.v.name());
        La.a().b();
        this.u = false;
        boolean z = this.v == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z) {
            for (LWSProgRvSmash lWSProgRvSmash2 : this.f14680b.c()) {
                if (lWSProgRvSmash2.C()) {
                    sb.append(lWSProgRvSmash2.r() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "ext1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otherRVAvailable = ");
        sb2.append(sb.length() > 0 ? "true|" + ((Object) sb) : "false");
        objArr2[1] = sb2.toString();
        objArr[0] = objArr2;
        lWSProgRvSmash.b(1203, objArr);
        if (lWSProgRvSmash.equals(this.f14680b.f())) {
            this.f14680b.a(null);
            if (this.v != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void d(LWSProgRvSmash lWSProgRvSmash) {
        this.f14680b.a(lWSProgRvSmash);
        this.q++;
        logSmashCallback(lWSProgRvSmash, "onRewardedVideoAdOpened");
        La.a().d();
        if (this.i) {
            C2325i c2325i = this.f14681c.get(lWSProgRvSmash.r());
            if (c2325i != null) {
                this.g.a(c2325i, lWSProgRvSmash.s(), this.f14683e, this.r);
                this.f14682d.put(lWSProgRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                a(true, c2325i, this.r);
            } else {
                String strR = lWSProgRvSmash != null ? lWSProgRvSmash.r() : "Smash is null";
                c("onRewardedVideoAdOpened showing instance " + strR + " missing from waterfall");
                a(81317, new Object[][]{new Object[]{"errorCode", Integer.valueOf(HybridPlusWebView.LOAD_BEGIN)}, new Object[]{"reason", "Showing missing " + this.v}, new Object[]{"ext1", strR}});
            }
        }
        this.h.d();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void e(LWSProgRvSmash lWSProgRvSmash) {
        synchronized (this.y) {
            logSmashCallback(lWSProgRvSmash, "onLoadSuccess mState=" + this.v);
            if (lWSProgRvSmash.z() == this.f14680b.d() && this.v != RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS) {
                this.f14682d.put(lWSProgRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
                if (this.v == RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES) {
                    b(true);
                    a(RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW);
                    a(IntConstant.PERMISSION_STORAGE_DOWNLOAD, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.j)}});
                    if (this.i) {
                        C2325i c2325i = this.f14681c.get(lWSProgRvSmash.r());
                        if (c2325i != null) {
                            this.g.a(c2325i, lWSProgRvSmash.s(), this.f14683e);
                            this.g.a(this.f14680b.c(), this.f14681c, lWSProgRvSmash.s(), this.f14683e, c2325i);
                        } else {
                            String strR = lWSProgRvSmash != null ? lWSProgRvSmash.r() : "Smash is null";
                            c("onLoadSuccess winner instance " + strR + " missing from waterfall. auctionId: " + lWSProgRvSmash.z() + " and the current id is " + this.f14680b.d());
                            StringBuilder sb = new StringBuilder();
                            sb.append("Loaded missing ");
                            sb.append(RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES);
                            a(81317, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", sb.toString()}, new Object[]{"ext1", strR}});
                        }
                    }
                }
                return;
            }
            d("onLoadSuccess was invoked with auctionId: " + lWSProgRvSmash.z() + " and the current id is " + this.f14680b.d());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadSuccess wrong auction ID ");
            sb2.append(this.v);
            lWSProgRvSmash.a(81315, new Object[][]{new Object[]{"errorCode", 2}, new Object[]{"reason", sb2.toString()}});
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void f(LWSProgRvSmash lWSProgRvSmash) {
        logSmashCallback(lWSProgRvSmash, "onRewardedVideoAdEnded");
        La.a().c();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void b(LWSProgRvSmash lWSProgRvSmash) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this.y) {
            logSmashCallback(lWSProgRvSmash, "onLoadError mState=" + this.v);
            if (lWSProgRvSmash.z() == this.f14680b.d() && this.v != RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS) {
                this.f14682d.put(lWSProgRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
                if (this.v == RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES || this.v == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                    boolean z = false;
                    boolean z2 = false;
                    for (LWSProgRvSmash lWSProgRvSmash2 : this.f14680b.c()) {
                        if (lWSProgRvSmash2.t()) {
                            if (this.t && lWSProgRvSmash2.y() && (z || z2)) {
                                d("Advanced Loading: Won't start loading bidder " + lWSProgRvSmash2.r() + " as " + (z ? "a non bidder is being loaded" : "a non bidder was already loaded successfully"));
                            } else if (this.f14681c.get(lWSProgRvSmash2.r()) != null) {
                                copyOnWriteArrayList.add(lWSProgRvSmash2);
                                if (!this.t || !lWSProgRvSmash.y() || lWSProgRvSmash2.y() || copyOnWriteArrayList.size() >= this.s) {
                                    break;
                                }
                                z = true;
                            } else {
                                continue;
                            }
                        } else if (lWSProgRvSmash2.D()) {
                            z = true;
                        } else if (lWSProgRvSmash2.E()) {
                            z2 = true;
                        }
                    }
                    if (copyOnWriteArrayList.size() == 0 && !z2 && !z) {
                        d("onLoadError(): No other available smashes");
                        if (!this.u) {
                            b(false);
                        }
                        a(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
                        this.h.a();
                    }
                }
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    g((LWSProgRvSmash) it.next());
                }
                return;
            }
            d("onLoadError was invoked with auctionId:" + lWSProgRvSmash.z() + " and the current id is " + this.f14680b.d());
            StringBuilder sb = new StringBuilder();
            sb.append("loadError wrong auction ID ");
            sb.append(this.v);
            lWSProgRvSmash.a(81315, new Object[][]{new Object[]{"errorCode", 4}, new Object[]{"reason", sb.toString()}});
        }
    }

    private void f() {
        if (this.f14680b.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(81001, new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}});
            e();
            return;
        }
        a(RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES);
        int i = 0;
        for (int i2 = 0; i2 < this.f14680b.c().size() && i < this.s; i2++) {
            LWSProgRvSmash lWSProgRvSmash = this.f14680b.c().get(i2);
            if (lWSProgRvSmash.t()) {
                if (this.t && lWSProgRvSmash.y()) {
                    if (i == 0) {
                        g(lWSProgRvSmash);
                        return;
                    }
                    d("Advanced Loading: Won't start loading bidder " + lWSProgRvSmash.r() + " as a non bidder is being loaded");
                    return;
                }
                g(lWSProgRvSmash);
                i++;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2372u
    public void a(com.ironsource.mediationsdk.model.l lVar) {
        LWSProgRvSmash next;
        synchronized (this.y) {
            if (lVar == null) {
                a("showRewardedVideo error: empty default placement");
                La.a().a(new com.ironsource.mediationsdk.logger.b(1021, "showRewardedVideo error: empty default placement"));
                a(1113, new Object[][]{new Object[]{"errorCode", 1021}, new Object[]{"reason", "showRewardedVideo error: empty default placement"}}, false, true);
                return;
            }
            this.r = lVar.c();
            b("showRewardedVideo(" + lVar + ")");
            a(1100);
            if (this.u) {
                a("showRewardedVideo error: can't show ad while an ad is already showing");
                La.a().a(new com.ironsource.mediationsdk.logger.b(1022, "showRewardedVideo error: can't show ad while an ad is already showing"));
                b(1113, new Object[][]{new Object[]{"errorCode", 1022}, new Object[]{"reason", "showRewardedVideo error: can't show ad while an ad is already showing"}});
                return;
            }
            if (this.v != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                a("showRewardedVideo error: show called while no ads are available");
                La.a().a(new com.ironsource.mediationsdk.logger.b(1023, "showRewardedVideo error: show called while no ads are available"));
                b(1113, new Object[][]{new Object[]{"errorCode", 1023}, new Object[]{"reason", "showRewardedVideo error: show called while no ads are available"}});
                return;
            }
            if (CappingManager.f(com.ironsource.mediationsdk.utils.c.c().a(), this.r)) {
                String str = "showRewardedVideo error: placement " + this.r + " is capped";
                a(str);
                La.a().a(new com.ironsource.mediationsdk.logger.b(524, str));
                b(1113, new Object[][]{new Object[]{"errorCode", 524}, new Object[]{"reason", str}});
                return;
            }
            Iterator<LWSProgRvSmash> it = this.f14680b.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.E()) {
                    this.u = true;
                    next.c(true);
                    a(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
                    break;
                }
                next.c(false);
            }
            if (next != null) {
                if (next != null) {
                    c(next, lVar);
                }
            } else {
                b("showRewardedVideo(): No ads to show");
                La.a().a(com.ironsource.mediationsdk.utils.g.d("Rewarded Video"));
                b(1113, new Object[][]{new Object[]{"errorCode", 509}, new Object[]{"reason", "showRewardedVideo(): No ads to show"}});
                this.h.c();
            }
        }
    }

    private void g(LWSProgRvSmash lWSProgRvSmash) {
        String strF = this.f14681c.get(lWSProgRvSmash.r()).f();
        lWSProgRvSmash.a(strF);
        lWSProgRvSmash.b(strF);
    }

    private List<C2325i> d() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (LWSProgRvSmash lWSProgRvSmash : this.o.values()) {
            if (!lWSProgRvSmash.y() && !this.p.b(lWSProgRvSmash) && this.f14680b.b(lWSProgRvSmash)) {
                copyOnWriteArrayList.add(new C2325i(lWSProgRvSmash.r()));
            }
        }
        return copyOnWriteArrayList;
    }

    @Override // com.ironsource.mediationsdk.Ua
    public void c() {
        d("onLoadTriggered: RV load was triggered in " + this.v + " state");
        a(0L);
    }

    private void c(LWSProgRvSmash lWSProgRvSmash, com.ironsource.mediationsdk.model.l lVar) {
        d("showVideo()");
        this.p.a(lWSProgRvSmash);
        if (this.p.b(lWSProgRvSmash)) {
            lWSProgRvSmash.G();
            com.ironsource.mediationsdk.utils.j.c(lWSProgRvSmash.r() + " rewarded video is now session capped");
        }
        CappingManager.c(com.ironsource.mediationsdk.utils.c.c().a(), lVar.c());
        if (CappingManager.f(com.ironsource.mediationsdk.utils.c.c().a(), lVar.c())) {
            a(1400);
        }
        lWSProgRvSmash.a(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        if (!this.u) {
            b(false);
        }
        this.h.a();
    }

    private void c(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, Object[][] objArr) {
        a(i, objArr, false, false);
    }

    private boolean c(boolean z) {
        Boolean bool = this.x;
        if (bool == null) {
            return false;
        }
        if (z && !bool.booleanValue() && a()) {
            return true;
        }
        return !z && this.x.booleanValue();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void b(LWSProgRvSmash lWSProgRvSmash, com.ironsource.mediationsdk.model.l lVar) {
        logSmashCallback(lWSProgRvSmash, "onRewardedVideoAdRewarded");
        La.a().b(lVar);
    }

    private void b(boolean z) {
        synchronized (this.y) {
            if (this.x == null || this.x.booleanValue() != z) {
                this.x = Boolean.valueOf(z);
                long time = new Date().getTime() - this.w;
                this.w = new Date().getTime();
                if (z) {
                    a(1111, new Object[][]{new Object[]{"duration", Long.valueOf(time)}});
                } else {
                    a(1112, new Object[][]{new Object[]{"duration", Long.valueOf(time)}});
                }
                La.a().a(z);
            }
        }
    }

    private void b(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        a(i, null, false, false);
    }

    private void b(int i, Object[][] objArr) {
        a(i, objArr, true, true);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2372u
    public boolean a() {
        if ((!this.n || com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().a())) && this.v == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW && !this.u) {
            Iterator<LWSProgRvSmash> it = this.f14680b.c().iterator();
            while (it.hasNext()) {
                if (it.next().E()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void a(com.ironsource.mediationsdk.logger.b bVar, LWSProgRvSmash lWSProgRvSmash) {
        logSmashCallback(lWSProgRvSmash, "onRewardedVideoAdShowFailed error=" + bVar.b());
        this.u = false;
        b(1113, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
        La.a().a(bVar);
        this.f14682d.put(lWSProgRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
        a(false, this.f14681c.get(lWSProgRvSmash.r()), this.r);
        if (this.v != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
            b(false);
        }
        this.h.c();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void a(LWSProgRvSmash lWSProgRvSmash) {
        logSmashCallback(lWSProgRvSmash, "onRewardedVideoAdStarted");
        La.a().e();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2310aa
    public void a(LWSProgRvSmash lWSProgRvSmash, com.ironsource.mediationsdk.model.l lVar) {
        logSmashCallback(lWSProgRvSmash, "onRewardedVideoAdClicked");
        La.a().a(lVar);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(List<C2325i> list, String str, C2325i c2325i, int i, long j) {
        d("makeAuction(): success");
        this.f14683e = c2325i;
        this.l = i;
        this.k = "";
        a(list, str);
        a(1302, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        f();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(int i, String str, int i2, String str2, long j) {
        d("Auction failed | moving to fallback waterfall");
        this.l = i2;
        this.k = str2;
        h();
        if (TextUtils.isEmpty(str)) {
            c(1301, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"duration", Long.valueOf(j)}});
        } else {
            c(1301, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}});
        }
        f();
    }

    private void a(long j) {
        if (this.p.a()) {
            d("all smashes are capped");
            a(81001, new Object[][]{new Object[]{"errorCode", 80001}, new Object[]{"reason", "all smashes are capped"}});
            e();
            return;
        }
        if (this.i) {
            if (!this.f14682d.isEmpty()) {
                this.f14684f.a(this.f14682d);
                this.f14682d.clear();
            }
            new Timer().schedule(new X(this), j);
            return;
        }
        d("auction fallback flow starting");
        h();
        if (this.f14680b.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(81001, new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}});
            e();
        } else {
            b(1000);
            f();
        }
    }

    private void a(List<C2325i> list, String str) {
        this.f14681c.clear();
        this.f14682d.clear();
        CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (C2325i c2325i : list) {
            sb.append(a(c2325i) + ",");
            LWSProgRvSmash lWSProgRvSmash = this.o.get(c2325i.b());
            if (lWSProgRvSmash != null) {
                AbstractC2311b abstractC2311bA = C2313c.a().a(lWSProgRvSmash.f15009b.g());
                if (abstractC2311bA != null) {
                    LWSProgRvSmash lWSProgRvSmash2 = new LWSProgRvSmash(lWSProgRvSmash, this, abstractC2311bA, this.q, str, this.l, this.k);
                    lWSProgRvSmash2.b(true);
                    copyOnWriteArrayList.add(lWSProgRvSmash2);
                    this.f14681c.put(lWSProgRvSmash2.r(), c2325i);
                    this.f14682d.put(c2325i.b(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                d("updateWaterfall() - could not find matching smash for auction response item " + c2325i.b());
            }
        }
        this.f14680b.a(copyOnWriteArrayList, str);
        if (this.f14680b.b()) {
            a(81318, new Object[][]{new Object[]{"reason", "waterfalls hold too many with size=" + this.f14680b.e()}});
        }
        d("updateWaterfall() - response waterfall is " + sb.toString());
        if (sb.length() == 0) {
            d("Updated waterfall is empty");
        }
        a(1311, new Object[][]{new Object[]{"ext1", sb.toString()}});
    }

    private String a(C2325i c2325i) {
        String string;
        LWSProgRvSmash lWSProgRvSmash = this.o.get(c2325i.b());
        if (lWSProgRvSmash != null) {
            string = Integer.toString(lWSProgRvSmash.s());
        } else {
            string = TextUtils.isEmpty(c2325i.f()) ? "1" : "2";
        }
        return string + c2325i.b();
    }

    private void a(RV_MEDIATION_STATE rv_mediation_state) {
        d("current state=" + this.v + ", new state=" + rv_mediation_state);
        this.v = rv_mediation_state;
    }

    private void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object[][] objArr) {
        a(i, objArr, false, true);
    }

    private void a(int i) {
        a(i, null, true, true);
    }

    private void a(int i, Object[][] objArr, boolean z, boolean z2) {
        HashMap map = new HashMap();
        map.put(com.umeng.analytics.pro.b.L, "Mediation");
        map.put("programmatic", 2);
        if (z2 && !TextUtils.isEmpty(this.f14680b.d())) {
            map.put("auctionId", this.f14680b.d());
        }
        if (z && !TextUtils.isEmpty(this.r)) {
            map.put("placement", this.r);
        }
        if (c(i)) {
            com.ironsource.mediationsdk.b.k.g().a(map, this.l, this.k);
        }
        map.put("sessionDepth", Integer.valueOf(this.q));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    map.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, new JSONObject(map)));
    }

    @Override // com.ironsource.environment.NetworkStateReceiver.a
    public void a(boolean z) {
        if (this.n) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z, 1);
            if (c(z)) {
                b(z);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2372u
    public void a(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager Should Track Network State: " + z, 0);
        this.n = z;
        if (this.n) {
            if (this.m == null) {
                this.m = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.m, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.m != null) {
            context.getApplicationContext().unregisterReceiver(this.m);
        }
    }
}
