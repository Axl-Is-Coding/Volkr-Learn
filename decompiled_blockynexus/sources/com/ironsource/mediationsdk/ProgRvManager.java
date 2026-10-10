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
class ProgRvManager extends AbstractC2337o implements NetworkStateReceiver.a, Ua, InterfaceC2321g, InterfaceC2345sa, InterfaceC2372u {
    private String A;
    private boolean B;
    private NetworkStateReceiver C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, ProgRvSmash> f14714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<ProgRvSmash> f14715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<C2325i> f14716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, C2325i> f14717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> f14718f;
    private C2325i g;
    private com.ironsource.mediationsdk.utils.l h;
    private Ta i;
    private boolean j;
    private boolean k;
    private boolean l;
    private C2323h m;
    private AuctionHistory n;
    private String o;
    private String p;
    private int q;
    private long r;
    private long s;
    private long t;
    private int u;
    private boolean v;
    private boolean w;
    private Boolean x;
    private RV_MEDIATION_STATE y;
    private int z;

    private enum RV_MEDIATION_STATE {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public ProgRvManager(List<com.ironsource.mediationsdk.model.p> list, com.ironsource.mediationsdk.model.r rVar, String str, String str2, com.ironsource.mediationsdk.c.c cVar) {
        super(cVar);
        this.q = 1;
        this.A = "";
        this.B = false;
        long time = new Date().getTime();
        b(81312);
        a(RV_MEDIATION_STATE.RV_STATE_INITIATING);
        this.x = null;
        this.u = rVar.e();
        this.v = rVar.g();
        this.o = "";
        com.ironsource.mediationsdk.utils.a aVarH = rVar.h();
        this.w = false;
        this.f14715c = new CopyOnWriteArrayList<>();
        this.f14716d = new ArrayList();
        this.f14717e = new ConcurrentHashMap<>();
        this.f14718f = new ConcurrentHashMap<>();
        this.t = new Date().getTime();
        this.j = aVarH.h() > 0;
        this.k = aVarH.d();
        this.l = !aVarH.e();
        this.s = aVarH.l();
        if (this.j) {
            this.m = new C2323h("rewardedVideo", aVarH, this);
        }
        this.i = new Ta(aVarH, this);
        this.f14714b = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        for (com.ironsource.mediationsdk.model.p pVar : list) {
            AbstractC2311b abstractC2311bA = C2313c.a().a(pVar, pVar.k());
            if (abstractC2311bA != null && C2317e.a().b(abstractC2311bA)) {
                ProgRvSmash progRvSmash = new ProgRvSmash(str, str2, pVar, this, rVar.f(), abstractC2311bA);
                String strR = progRvSmash.r();
                this.f14714b.put(strR, progRvSmash);
                arrayList.add(strR);
            }
        }
        this.n = new AuctionHistory(arrayList, aVarH.c());
        this.h = new com.ironsource.mediationsdk.utils.l(new ArrayList(this.f14714b.values()));
        for (ProgRvSmash progRvSmash2 : this.f14714b.values()) {
            if (progRvSmash2.y()) {
                progRvSmash2.A();
            }
        }
        c(81313, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
        a(aVarH.k());
    }

    private boolean c(int i) {
        return i == 1003 || i == 1302 || i == 1301;
    }

    private void i() {
        a(d());
        this.p = "fallback_" + System.currentTimeMillis();
    }

    private void logSmashCallback(ProgRvSmash progRvSmash, String str) {
        String str2 = progRvSmash.r() + " : " + str;
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "ProgRvManager: " + str2, 0);
    }

    private void c(ProgRvSmash progRvSmash, com.ironsource.mediationsdk.model.l lVar) {
        d("showVideo()");
        this.h.a(progRvSmash);
        if (this.h.b(progRvSmash)) {
            progRvSmash.E();
            com.ironsource.mediationsdk.utils.j.c(progRvSmash.r() + " rewarded video is now session capped");
        }
        CappingManager.c(com.ironsource.mediationsdk.utils.c.c().a(), lVar.c());
        if (CappingManager.f(com.ironsource.mediationsdk.utils.c.c().a(), lVar.c())) {
            a(1400);
        }
        progRvSmash.a(lVar, this.q);
    }

    private List<C2325i> d() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ProgRvSmash progRvSmash : this.f14714b.values()) {
            if (!progRvSmash.y() && !this.h.b(progRvSmash)) {
                copyOnWriteArrayList.add(new C2325i(progRvSmash.r()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void e(ProgRvSmash progRvSmash) {
        String strF = this.f14717e.get(progRvSmash.r()).f();
        progRvSmash.a(strF, this.p, this.z, this.A, this.q, AuctionDataUtils.b().d(strF));
    }

    private void f() {
        if (this.f14715c.isEmpty()) {
            a(81001, new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}});
            e();
            return;
        }
        a(RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES);
        int i = 0;
        for (int i2 = 0; i2 < this.f14715c.size() && i < this.u; i2++) {
            ProgRvSmash progRvSmash = this.f14715c.get(i2);
            if (progRvSmash.t()) {
                if (this.v && progRvSmash.y()) {
                    if (i == 0) {
                        e(progRvSmash);
                        return;
                    }
                    d("Advanced Loading: Won't start loading bidder " + progRvSmash.r() + " as a non bidder is being loaded");
                    return;
                }
                e(progRvSmash);
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        b(this.f14716d);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a(RV_MEDIATION_STATE.RV_STATE_AUCTION_IN_PROGRESS);
        AsyncTask.execute(new RunnableC2342qa(this));
    }

    private void b(List<C2325i> list) {
        this.f14715c.clear();
        this.f14717e.clear();
        this.f14718f.clear();
        for (C2325i c2325i : list) {
            ProgRvSmash progRvSmash = this.f14714b.get(c2325i.b());
            if (progRvSmash != null) {
                progRvSmash.b(true);
                this.f14715c.add(progRvSmash);
                this.f14717e.put(progRvSmash.r(), c2325i);
                this.f14718f.put(c2325i.b(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                d("updateWaterfall() - could not find matching smash for auction response item " + c2325i.b());
            }
        }
        this.f14716d.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
        b(false);
        this.i.a();
    }

    private void a(long j) {
        if (this.h.a()) {
            a(81001, new Object[][]{new Object[]{"errorCode", 80001}, new Object[]{"reason", "all smashes are capped"}});
            e();
            return;
        }
        if (this.j) {
            if (!this.f14718f.isEmpty()) {
                this.n.a(this.f14718f);
                this.f14718f.clear();
            }
            new Timer().schedule(new C2340pa(this), j);
            return;
        }
        i();
        if (this.f14716d.isEmpty()) {
            a(81001, new Object[][]{new Object[]{"errorCode", 80002}, new Object[]{"reason", "waterfall is empty"}});
            e();
            return;
        }
        b(1000);
        if (this.l && this.w) {
            return;
        }
        g();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void d(ProgRvSmash progRvSmash) {
        logSmashCallback(progRvSmash, "onRewardedVideoAdStarted");
        La.a().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvManager: " + str, 0);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void c(ProgRvSmash progRvSmash) {
        logSmashCallback(progRvSmash, "onRewardedVideoAdEnded");
        La.a().c();
    }

    private void c(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvManager: " + str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, Object[][] objArr) {
        a(i, objArr, false, false);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void b(ProgRvSmash progRvSmash, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this) {
            logSmashCallback(progRvSmash, "onLoadError ");
            if (!str.equalsIgnoreCase(this.p)) {
                d("onLoadError was invoked with auctionId:" + str + " and the current id is " + this.p);
                StringBuilder sb = new StringBuilder();
                sb.append("loadError wrong auction ID ");
                sb.append(this.y);
                progRvSmash.a(81315, new Object[][]{new Object[]{"errorCode", 4}, new Object[]{"reason", sb.toString()}});
                return;
            }
            this.f14718f.put(progRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
            boolean z = false;
            boolean z2 = false;
            for (ProgRvSmash progRvSmash2 : this.f14715c) {
                if (progRvSmash2.t()) {
                    if (this.v && progRvSmash2.y() && (z || z2)) {
                        d("Advanced Loading: Won't start loading bidder " + progRvSmash2.r() + " as " + (z ? "a non bidder is being loaded" : "a non bidder was already loaded successfully"));
                    } else if (this.f14717e.get(progRvSmash2.r()) != null) {
                        copyOnWriteArrayList.add(progRvSmash2);
                        if (!this.v || !progRvSmash.y() || progRvSmash2.y() || copyOnWriteArrayList.size() >= this.u) {
                            break;
                        }
                        z = true;
                    } else {
                        continue;
                    }
                } else if (progRvSmash2.B()) {
                    z = true;
                } else if (progRvSmash2.C()) {
                    z2 = true;
                }
            }
            if (copyOnWriteArrayList.size() == 0 && !z2 && !z) {
                d("onLoadError(): No other available smashes");
                b(false);
                a(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
                this.i.a();
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                e((ProgRvSmash) it.next());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.Ua
    public synchronized void c() {
        d("onLoadTriggered: RV load was triggered in " + this.y + " state");
        a(0L);
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

    @Override // com.ironsource.mediationsdk.InterfaceC2372u
    public synchronized void a(com.ironsource.mediationsdk.model.l lVar) {
        if (lVar == null) {
            a("showRewardedVideo error: empty default placement");
            La.a().a(new com.ironsource.mediationsdk.logger.b(1021, "showRewardedVideo error: empty default placement"));
            a(1113, new Object[][]{new Object[]{"errorCode", 1021}, new Object[]{"reason", "showRewardedVideo error: empty default placement"}}, false, true);
            return;
        }
        this.o = lVar.c();
        b("showRewardedVideo(" + lVar + ")");
        a(1100);
        if (this.w) {
            a("showRewardedVideo error: can't show ad while an ad is already showing");
            La.a().a(new com.ironsource.mediationsdk.logger.b(1022, "showRewardedVideo error: can't show ad while an ad is already showing"));
            b(1113, new Object[][]{new Object[]{"errorCode", 1022}, new Object[]{"reason", "showRewardedVideo error: can't show ad while an ad is already showing"}});
            return;
        }
        if (this.y != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
            a("showRewardedVideo error: show called while no ads are available");
            La.a().a(new com.ironsource.mediationsdk.logger.b(1023, "showRewardedVideo error: show called while no ads are available"));
            b(1113, new Object[][]{new Object[]{"errorCode", 1023}, new Object[]{"reason", "showRewardedVideo error: show called while no ads are available"}});
            return;
        }
        if (CappingManager.f(com.ironsource.mediationsdk.utils.c.c().a(), this.o)) {
            String str = "showRewardedVideo error: placement " + this.o + " is capped";
            a(str);
            La.a().a(new com.ironsource.mediationsdk.logger.b(524, str));
            b(1113, new Object[][]{new Object[]{"errorCode", 524}, new Object[]{"reason", str}});
            return;
        }
        for (ProgRvSmash progRvSmash : this.f14715c) {
            if (progRvSmash.C()) {
                this.w = true;
                progRvSmash.a(true, this.q);
                c(progRvSmash, lVar);
                a(RV_MEDIATION_STATE.RV_STATE_NOT_LOADED);
                return;
            }
            progRvSmash.a(false, this.q);
        }
        b("showRewardedVideo(): No ads to show");
        La.a().a(com.ironsource.mediationsdk.utils.g.d("Rewarded Video"));
        b(1113, new Object[][]{new Object[]{"errorCode", 509}, new Object[]{"reason", "showRewardedVideo(): No ads to show"}});
        this.i.c();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void b(ProgRvSmash progRvSmash) {
        synchronized (this) {
            progRvSmash.b(1203, new Object[][]{new Object[]{"ext1", "otherRVAvailable = false"}});
            logSmashCallback(progRvSmash, "onRewardedVideoAdClosed, mediation state: " + this.y.name());
            La.a().b();
            this.w = false;
            if (this.y != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
            if (this.k) {
                if (this.f14716d != null && this.f14716d.size() > 0) {
                    new Timer().schedule(new C2343ra(this), this.s);
                }
            } else {
                this.i.b();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void b(ProgRvSmash progRvSmash, com.ironsource.mediationsdk.model.l lVar) {
        logSmashCallback(progRvSmash, "onRewardedVideoAdClicked");
        La.a().a(lVar);
    }

    private void b(boolean z) {
        Boolean bool = this.x;
        if (bool == null || bool.booleanValue() != z) {
            this.x = Boolean.valueOf(z);
            long time = new Date().getTime() - this.t;
            this.t = new Date().getTime();
            if (z) {
                a(1111, new Object[][]{new Object[]{"duration", Long.valueOf(time)}});
            } else {
                a(1112, new Object[][]{new Object[]{"duration", Long.valueOf(time)}});
            }
            La.a().a(z);
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2372u
    public synchronized boolean a() {
        if (this.B && !com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().a())) {
            return false;
        }
        if (this.y == RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW && !this.w) {
            Iterator<ProgRvSmash> it = this.f14715c.iterator();
            while (it.hasNext()) {
                if (it.next().C()) {
                    return true;
                }
            }
            return false;
        }
        return false;
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

    private void a(List<C2325i> list) {
        this.f14716d = list;
        StringBuilder sb = new StringBuilder();
        Iterator<C2325i> it = list.iterator();
        while (it.hasNext()) {
            sb.append(a(it.next()) + ",");
        }
        d("updateNextWaterfallToLoad() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            d("Updated waterfall is empty");
        }
        a(1311, new Object[][]{new Object[]{"ext1", sb.toString()}});
    }

    private String a(C2325i c2325i) {
        String string;
        ProgRvSmash progRvSmash = this.f14714b.get(c2325i.b());
        if (progRvSmash != null) {
            string = Integer.toString(progRvSmash.s());
        } else {
            string = TextUtils.isEmpty(c2325i.f()) ? "1" : "2";
        }
        return string + c2325i.b();
    }

    private void a(RV_MEDIATION_STATE rv_mediation_state) {
        d("current state=" + this.y + ", new state=" + rv_mediation_state);
        this.y = rv_mediation_state;
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public synchronized void a(ProgRvSmash progRvSmash, String str) {
        logSmashCallback(progRvSmash, "onLoadSuccess ");
        if (this.p != null && !str.equalsIgnoreCase(this.p)) {
            d("onLoadSuccess was invoked with auctionId: " + str + " and the current id is " + this.p);
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadSuccess wrong auction ID ");
            sb.append(this.y);
            progRvSmash.a(81315, new Object[][]{new Object[]{"errorCode", 2}, new Object[]{"reason", sb.toString()}});
            return;
        }
        RV_MEDIATION_STATE rv_mediation_state = this.y;
        this.f14718f.put(progRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
        b(true);
        if (this.y == RV_MEDIATION_STATE.RV_STATE_LOADING_SMASHES) {
            a(RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW);
            a(IntConstant.PERMISSION_STORAGE_DOWNLOAD, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.r)}});
            if (this.j) {
                C2325i c2325i = this.f14717e.get(progRvSmash.r());
                if (c2325i != null) {
                    this.m.a(c2325i, progRvSmash.s(), this.g);
                    this.m.a(this.f14715c, this.f14717e, progRvSmash.s(), this.g, c2325i);
                } else {
                    String strR = progRvSmash != null ? progRvSmash.r() : "Smash is null";
                    c("onLoadSuccess winner instance " + strR + " missing from waterfall. auctionId: " + str + " and the current id is " + this.p);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Loaded missing ");
                    sb2.append(rv_mediation_state);
                    a(81317, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", sb2.toString()}, new Object[]{"ext1", strR}});
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void a(ProgRvSmash progRvSmash) {
        synchronized (this) {
            this.q++;
            logSmashCallback(progRvSmash, "onRewardedVideoAdOpened");
            La.a().d();
            if (this.j) {
                C2325i c2325i = this.f14717e.get(progRvSmash.r());
                if (c2325i != null) {
                    this.m.a(c2325i, progRvSmash.s(), this.g, this.o);
                    this.f14718f.put(progRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                    a(true, c2325i, this.o);
                } else {
                    String strR = progRvSmash != null ? progRvSmash.r() : "Smash is null";
                    c("onRewardedVideoAdOpened showing instance " + strR + " missing from waterfall");
                    a(81317, new Object[][]{new Object[]{"errorCode", Integer.valueOf(HybridPlusWebView.LOAD_BEGIN)}, new Object[]{"reason", "Showing missing " + this.y}, new Object[]{"ext1", strR}});
                }
            }
            this.i.d();
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void a(com.ironsource.mediationsdk.logger.b bVar, ProgRvSmash progRvSmash) {
        synchronized (this) {
            logSmashCallback(progRvSmash, "onRewardedVideoAdShowFailed error=" + bVar.b());
            b(1113, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
            La.a().a(bVar);
            this.w = false;
            this.f14718f.put(progRvSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
            a(false, this.f14717e.get(progRvSmash.r()), this.o);
            if (this.y != RV_MEDIATION_STATE.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
            this.i.c();
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2345sa
    public void a(ProgRvSmash progRvSmash, com.ironsource.mediationsdk.model.l lVar) {
        logSmashCallback(progRvSmash, "onRewardedVideoAdRewarded");
        La.a().b(lVar);
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
        map.put("programmatic", 1);
        if (z2 && !TextUtils.isEmpty(this.p)) {
            map.put("auctionId", this.p);
        }
        if (z && !TextUtils.isEmpty(this.o)) {
            map.put("placement", this.o);
        }
        if (c(i)) {
            com.ironsource.mediationsdk.b.k.g().a(map, this.z, this.A);
        }
        map.put("sessionDepth", Integer.valueOf(this.q));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    map.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, new JSONObject(map)));
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(List<C2325i> list, String str, C2325i c2325i, int i, long j) {
        d("makeAuction(): success");
        this.p = str;
        this.g = c2325i;
        this.z = i;
        this.A = "";
        a(1302, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        a(list);
        if (this.l && this.w) {
            return;
        }
        g();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(int i, String str, int i2, String str2, long j) {
        d("Auction failed | moving to fallback waterfall");
        this.z = i2;
        this.A = str2;
        if (TextUtils.isEmpty(str)) {
            c(1301, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"duration", Long.valueOf(j)}});
        } else {
            c(1301, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}});
        }
        i();
        if (this.l && this.w) {
            return;
        }
        g();
    }

    @Override // com.ironsource.environment.NetworkStateReceiver.a
    public void a(boolean z) {
        if (this.B) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z, 1);
            if (c(z)) {
                b(z);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2372u
    public void a(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgRvManager Should Track Network State: " + z, 0);
        this.B = z;
        if (this.B) {
            if (this.C == null) {
                this.C = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.C, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.C != null) {
            context.getApplicationContext().unregisterReceiver(this.C);
        }
    }
}
