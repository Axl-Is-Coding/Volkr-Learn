package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.CappingManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class ProgIsManager extends AbstractC2337o implements InterfaceC2321g, InterfaceC2336na, InterfaceC2370t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.l f14708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MEDIATION_STATE f14709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, ProgIsSmash> f14710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<ProgIsSmash> f14711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, C2325i> f14712f;
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> g;
    private C2325i h;
    private String i;
    private String j;
    private int k;
    private boolean l;
    private boolean m;
    private C2323h n;
    private AuctionHistory o;
    private long p;
    private long q;
    private long r;
    private int s;
    private String t;
    boolean u;

    enum MEDIATION_STATE {
        STATE_NOT_INITIALIZED,
        STATE_READY_TO_LOAD,
        STATE_AUCTION,
        STATE_LOADING_SMASHES,
        STATE_READY_TO_SHOW,
        STATE_SHOWING
    }

    public ProgIsManager(List<com.ironsource.mediationsdk.model.p> list, com.ironsource.mediationsdk.model.h hVar, String str, String str2, int i, com.ironsource.mediationsdk.c.c cVar) {
        super(cVar);
        this.t = "";
        this.u = false;
        long time = new Date().getTime();
        a(82312);
        a(MEDIATION_STATE.STATE_NOT_INITIALIZED);
        this.f14710d = new ConcurrentHashMap<>();
        this.f14711e = new CopyOnWriteArrayList<>();
        this.f14712f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
        this.i = "";
        this.j = "";
        this.k = hVar.d();
        this.l = hVar.f();
        CallbackThrottler.a().a(i);
        com.ironsource.mediationsdk.utils.a aVarG = hVar.g();
        this.q = aVarG.k();
        this.m = aVarG.h() > 0;
        if (this.m) {
            this.n = new C2323h("interstitial", aVarG, this);
        }
        ArrayList arrayList = new ArrayList();
        for (com.ironsource.mediationsdk.model.p pVar : list) {
            AbstractC2311b abstractC2311bA = C2313c.a().a(pVar, pVar.f());
            if (abstractC2311bA != null && C2317e.a().a(abstractC2311bA)) {
                ProgIsSmash progIsSmash = new ProgIsSmash(str, str2, pVar, this, hVar.e(), abstractC2311bA);
                String strR = progIsSmash.r();
                this.f14710d.put(strR, progIsSmash);
                arrayList.add(strR);
            }
        }
        this.o = new AuctionHistory(arrayList, aVarG.c());
        this.f14708b = new com.ironsource.mediationsdk.utils.l(new ArrayList(this.f14710d.values()));
        for (ProgIsSmash progIsSmash2 : this.f14710d.values()) {
            if (progIsSmash2.y()) {
                progIsSmash2.A();
            }
        }
        this.p = new Date().getTime();
        a(MEDIATION_STATE.STATE_READY_TO_LOAD);
        a(82313, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
    }

    private boolean c(int i) {
        return i == 2002 || i == 2003 || i == 2200 || i == 2005 || i == 2204 || i == 2201 || i == 2203 || i == 2006 || i == 2004 || i == 2110 || i == 2301 || i == 2300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a(MEDIATION_STATE.STATE_AUCTION);
        AsyncTask.execute(new RunnableC2334ma(this));
    }

    private void i() {
        a(f());
    }

    private void logSmashCallback(ProgIsSmash progIsSmash, String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsManager " + progIsSmash.r() + " : " + str, 0);
    }

    private List<C2325i> f() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ProgIsSmash progIsSmash : this.f14710d.values()) {
            if (!progIsSmash.y() && !this.f14708b.b(progIsSmash)) {
                copyOnWriteArrayList.add(new C2325i(progIsSmash.r()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void g(ProgIsSmash progIsSmash) {
        String strF = this.f14712f.get(progIsSmash.r()).f();
        progIsSmash.a(strF);
        a(2002, progIsSmash);
        progIsSmash.b(strF);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void c(ProgIsSmash progIsSmash) {
        synchronized (this) {
            logSmashCallback(progIsSmash, "onInterstitialAdOpened");
            K.a().d();
            b(2005, progIsSmash);
            if (this.m) {
                C2325i c2325i = this.f14712f.get(progIsSmash.r());
                if (c2325i != null) {
                    this.n.a(c2325i, progIsSmash.s(), this.h, this.i);
                    this.g.put(progIsSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
                    a(true, c2325i, this.i);
                } else {
                    String strR = progIsSmash != null ? progIsSmash.r() : "Smash is null";
                    c("onInterstitialAdOpened showing instance " + strR + " missing from waterfall");
                    a(82317, new Object[][]{new Object[]{"errorCode", Integer.valueOf(HybridPlusWebView.LOAD_BEGIN)}, new Object[]{"reason", "Showing missing " + this.f14709c}, new Object[]{"ext1", strR}});
                }
            }
        }
    }

    public synchronized boolean d() {
        if ((this.u && !com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().a())) || this.f14709c != MEDIATION_STATE.STATE_READY_TO_SHOW) {
            return false;
        }
        Iterator<ProgIsSmash> it = this.f14711e.iterator();
        while (it.hasNext()) {
            if (it.next().C()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void e() {
        if (this.f14709c == MEDIATION_STATE.STATE_SHOWING) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, "loadInterstitial: load cannot be invoked while showing an ad", 3);
            K.a().a(new com.ironsource.mediationsdk.logger.b(1037, "loadInterstitial: load cannot be invoked while showing an ad"));
            return;
        }
        if ((this.f14709c != MEDIATION_STATE.STATE_READY_TO_LOAD && this.f14709c != MEDIATION_STATE.STATE_READY_TO_SHOW) || CallbackThrottler.a().b()) {
            c("loadInterstitial: load is already in progress");
            return;
        }
        this.j = "";
        this.i = "";
        a(2001);
        this.r = new Date().getTime();
        if (this.m) {
            if (!this.g.isEmpty()) {
                this.o.a(this.g);
                this.g.clear();
            }
            h();
        } else {
            i();
            g();
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void b(ProgIsSmash progIsSmash) {
        logSmashCallback(progIsSmash, "onInterstitialAdVisible");
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void b(com.ironsource.mediationsdk.logger.b bVar, ProgIsSmash progIsSmash) {
        a(2206, progIsSmash, new Object[][]{new Object[]{"reason", bVar.b()}});
    }

    private void b(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(List<C2325i> list, String str, C2325i c2325i, int i, long j) {
        this.j = str;
        this.h = c2325i;
        this.s = i;
        this.t = "";
        a(2301, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        a(list);
        g();
    }

    private void b(int i, Object[][] objArr) {
        a(i, objArr, true);
    }

    private void g() {
        if (this.f14711e.isEmpty()) {
            a(MEDIATION_STATE.STATE_READY_TO_LOAD);
            a(2110, new Object[][]{new Object[]{"errorCode", 1035}, new Object[]{"reason", "Empty waterfall"}});
            CallbackThrottler.a().a(new com.ironsource.mediationsdk.logger.b(1035, "Empty waterfall"));
            return;
        }
        a(MEDIATION_STATE.STATE_LOADING_SMASHES);
        int i = 0;
        for (int i2 = 0; i2 < this.f14711e.size() && i < this.k; i2++) {
            ProgIsSmash progIsSmash = this.f14711e.get(i2);
            if (progIsSmash.t()) {
                if (this.l && progIsSmash.y()) {
                    if (i == 0) {
                        g(progIsSmash);
                        return;
                    }
                    c("Advanced Loading: Won't start loading bidder " + progIsSmash.r() + " as a non bidder is being loaded");
                    return;
                }
                g(progIsSmash);
                i++;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void f(ProgIsSmash progIsSmash) {
        logSmashCallback(progIsSmash, "onInterstitialAdShowSucceeded");
        K.a().f();
        b(2202, progIsSmash);
    }

    private void b(int i) {
        a(i, (Object[][]) null, true);
    }

    private void b(int i, ProgIsSmash progIsSmash, Object[][] objArr) {
        a(i, progIsSmash, objArr, true);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void d(ProgIsSmash progIsSmash) {
        synchronized (this) {
            logSmashCallback(progIsSmash, "onInterstitialAdClosed");
            b(2204, progIsSmash, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(com.ironsource.mediationsdk.utils.m.a().a(2))}});
            com.ironsource.mediationsdk.utils.m.a().b(2);
            K.a().c();
            a(MEDIATION_STATE.STATE_READY_TO_LOAD);
        }
    }

    private void b(int i, ProgIsSmash progIsSmash) {
        a(i, progIsSmash, null, true);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(int i, String str, int i2, String str2, long j) {
        c("Auction failed | moving to fallback waterfall");
        this.s = i2;
        this.t = str2;
        if (TextUtils.isEmpty(str)) {
            a(2300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"duration", Long.valueOf(j)}});
        } else {
            a(2300, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}});
        }
        i();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsManager " + str, 0);
    }

    private String a(C2325i c2325i) {
        String string;
        ProgIsSmash progIsSmash = this.f14710d.get(c2325i.b());
        if (progIsSmash != null) {
            string = Integer.toString(progIsSmash.s());
        } else {
            string = TextUtils.isEmpty(c2325i.f()) ? "1" : "2";
        }
        return string + c2325i.b();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void e(ProgIsSmash progIsSmash) {
        logSmashCallback(progIsSmash, "onInterstitialAdClicked");
        K.a().b();
        b(AdError.INTERNAL_ERROR_2006, progIsSmash);
    }

    private void a(List<C2325i> list) {
        this.f14711e.clear();
        this.f14712f.clear();
        this.g.clear();
        StringBuilder sb = new StringBuilder();
        for (C2325i c2325i : list) {
            sb.append(a(c2325i) + ",");
            ProgIsSmash progIsSmash = this.f14710d.get(c2325i.b());
            if (progIsSmash != null) {
                progIsSmash.b(true);
                this.f14711e.add(progIsSmash);
                this.f14712f.put(progIsSmash.r(), c2325i);
                this.g.put(c2325i.b(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                c("updateWaterfall() - could not find matching smash for auction response item " + c2325i.b());
            }
        }
        c("updateWaterfall() - response waterfall is " + sb.toString());
        if (sb.length() == 0) {
            c("Updated waterfall is empty");
        }
        a(2311, new Object[][]{new Object[]{"ext1", sb.toString()}});
    }

    public synchronized void a(String str) {
        if (this.f14709c == MEDIATION_STATE.STATE_SHOWING) {
            b("showInterstitial error: can't show ad while an ad is already showing");
            K.a().b(new com.ironsource.mediationsdk.logger.b(1036, "showInterstitial error: can't show ad while an ad is already showing"));
            a(2111, new Object[][]{new Object[]{"errorCode", 1036}, new Object[]{"reason", "showInterstitial error: can't show ad while an ad is already showing"}});
            return;
        }
        if (this.f14709c != MEDIATION_STATE.STATE_READY_TO_SHOW) {
            c("showInterstitial() error state=" + this.f14709c.toString());
            b("showInterstitial error: show called while no ads are available");
            K.a().b(new com.ironsource.mediationsdk.logger.b(509, "showInterstitial error: show called while no ads are available"));
            a(2111, new Object[][]{new Object[]{"errorCode", 509}, new Object[]{"reason", "showInterstitial error: show called while no ads are available"}});
            return;
        }
        if (str == null) {
            b("showInterstitial error: empty default placement");
            K.a().b(new com.ironsource.mediationsdk.logger.b(1020, "showInterstitial error: empty default placement"));
            a(2111, new Object[][]{new Object[]{"errorCode", 1020}, new Object[]{"reason", "showInterstitial error: empty default placement"}});
            return;
        }
        this.i = str;
        b(AdError.BROKEN_MEDIA_ERROR_CODE);
        if (CappingManager.e(com.ironsource.mediationsdk.utils.c.c().a(), this.i)) {
            String str2 = "placement " + this.i + " is capped";
            b(str2);
            K.a().b(new com.ironsource.mediationsdk.logger.b(524, str2));
            b(2111, new Object[][]{new Object[]{"errorCode", 524}, new Object[]{"reason", str2}});
            return;
        }
        for (ProgIsSmash progIsSmash : this.f14711e) {
            if (progIsSmash.C()) {
                a(progIsSmash, this.i);
                return;
            }
            c("showInterstitial " + progIsSmash.r() + " isReadyToShow() == false");
        }
        K.a().b(com.ironsource.mediationsdk.utils.g.d("Interstitial"));
        b(2111, new Object[][]{new Object[]{"errorCode", 509}, new Object[]{"reason", "Show Fail - No ads to show"}});
    }

    private void a(ProgIsSmash progIsSmash, String str) {
        a(MEDIATION_STATE.STATE_SHOWING);
        progIsSmash.E();
        b(2201, progIsSmash);
        this.f14708b.a(progIsSmash);
        if (this.f14708b.b(progIsSmash)) {
            progIsSmash.D();
            a(2401, progIsSmash);
            com.ironsource.mediationsdk.utils.j.c(progIsSmash.r() + " was session capped");
        }
        CappingManager.b(com.ironsource.mediationsdk.utils.c.c().a(), str);
        if (CappingManager.e(com.ironsource.mediationsdk.utils.c.c().a(), str)) {
            b(2400);
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void a(ProgIsSmash progIsSmash, long j) {
        synchronized (this) {
            logSmashCallback(progIsSmash, "onInterstitialAdReady");
            a(AdError.INTERNAL_ERROR_2003, progIsSmash, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            if (progIsSmash != null && this.g.containsKey(progIsSmash.r())) {
                this.g.put(progIsSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceLoadedSuccessfully);
            }
            if (this.f14709c == MEDIATION_STATE.STATE_LOADING_SMASHES) {
                a(MEDIATION_STATE.STATE_READY_TO_SHOW);
                K.a().e();
                a(AdError.INTERNAL_ERROR_2004, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.r)}});
                if (this.m) {
                    C2325i c2325i = this.f14712f.get(progIsSmash.r());
                    if (c2325i != null) {
                        this.n.a(c2325i, progIsSmash.s(), this.h);
                        this.n.a(this.f14711e, this.f14712f, progIsSmash.s(), this.h, c2325i);
                    } else {
                        String strR = progIsSmash != null ? progIsSmash.r() : "Smash is null";
                        c("onInterstitialAdReady winner instance " + strR + " missing from waterfall");
                        a(82317, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{"ext1", strR}});
                    }
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void a(com.ironsource.mediationsdk.logger.b bVar, ProgIsSmash progIsSmash, long j) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this) {
            logSmashCallback(progIsSmash, "onInterstitialAdLoadFailed error=" + bVar.b() + " state=" + this.f14709c.name());
            a(2200, progIsSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(j)}});
            if (progIsSmash != null && this.g.containsKey(progIsSmash.r())) {
                this.g.put(progIsSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
            }
            boolean z = false;
            boolean z2 = false;
            for (ProgIsSmash progIsSmash2 : this.f14711e) {
                if (progIsSmash2.t()) {
                    if (!this.l || !progIsSmash2.y() || (!z && !z2)) {
                        copyOnWriteArrayList.add(progIsSmash2);
                        if (!this.l || !progIsSmash.y() || progIsSmash2.y() || copyOnWriteArrayList.size() >= this.k) {
                            break;
                        }
                    } else {
                        c("Advanced Loading: Won't start loading bidder " + progIsSmash2.r() + " as " + (z ? "a non bidder is being loaded" : "a non bidder was already loaded successfully"));
                    }
                } else if (!progIsSmash2.B()) {
                    if (progIsSmash2.C()) {
                        z2 = true;
                    }
                }
                z = true;
            }
            if (copyOnWriteArrayList.size() == 0 && this.f14709c == MEDIATION_STATE.STATE_LOADING_SMASHES && !z) {
                CallbackThrottler.a().a(new com.ironsource.mediationsdk.logger.b(509, "No ads to show"));
                a(2110, new Object[][]{new Object[]{"errorCode", 509}});
                a(MEDIATION_STATE.STATE_READY_TO_LOAD);
            }
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            g((ProgIsSmash) it.next());
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void a(com.ironsource.mediationsdk.logger.b bVar, ProgIsSmash progIsSmash) {
        synchronized (this) {
            logSmashCallback(progIsSmash, "onInterstitialAdShowFailed error=" + bVar.b());
            K.a().b(bVar);
            b(2203, progIsSmash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}});
            this.g.put(progIsSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToShow);
            a(false, this.f14712f.get(progIsSmash.r()), this.i);
            a(MEDIATION_STATE.STATE_READY_TO_LOAD);
        }
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2336na
    public void a(ProgIsSmash progIsSmash) {
        a(2205, progIsSmash);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MEDIATION_STATE mediation_state) {
        this.f14709c = mediation_state;
        c("state=" + mediation_state);
    }

    private void a(int i) {
        a(i, (Object[][]) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object[][] objArr) {
        a(i, objArr, false);
    }

    private void a(int i, Object[][] objArr, boolean z) {
        HashMap map = new HashMap();
        map.put(com.umeng.analytics.pro.b.L, "Mediation");
        map.put("programmatic", 1);
        if (!TextUtils.isEmpty(this.j)) {
            map.put("auctionId", this.j);
        }
        if (z && !TextUtils.isEmpty(this.i)) {
            map.put("placement", this.i);
        }
        if (c(i)) {
            com.ironsource.mediationsdk.b.h.g().a(map, this.s, this.t);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    map.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                c("sendMediationEvent " + e2.getMessage());
            }
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, new JSONObject(map)));
    }

    private void a(int i, ProgIsSmash progIsSmash) {
        a(i, progIsSmash, null, false);
    }

    private void a(int i, ProgIsSmash progIsSmash, Object[][] objArr) {
        a(i, progIsSmash, objArr, false);
    }

    private void a(int i, ProgIsSmash progIsSmash, Object[][] objArr, boolean z) {
        Map<String, Object> mapX = progIsSmash.x();
        if (!TextUtils.isEmpty(this.j)) {
            mapX.put("auctionId", this.j);
        }
        if (z && !TextUtils.isEmpty(this.i)) {
            mapX.put("placement", this.i);
        }
        if (c(i)) {
            com.ironsource.mediationsdk.b.h.g().a(mapX, this.s, this.t);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapX.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, new JSONObject(mapX)));
    }

    void a(Context context, boolean z) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "Should Track Network State: " + z, 0);
        this.u = z;
    }
}
