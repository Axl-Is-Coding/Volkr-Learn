package com.ironsource.mediationsdk;

import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.AuctionHistory;
import com.ironsource.mediationsdk.g.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ProgBannerManager extends AbstractC2337o implements c.a, InterfaceC2321g, InterfaceC2330ka, c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C2329k f14702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BannerManagerState f14703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ironsource.mediationsdk.g.c f14704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IronSourceBannerLayout f14705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ironsource.mediationsdk.model.f f14706f;
    private int g;
    private ProgBannerSmash h;
    private int i;
    private final ConcurrentHashMap<String, ProgBannerSmash> j;
    private CopyOnWriteArrayList<ProgBannerSmash> k;
    private String l;
    private String m;
    private int n;
    private C2323h o;
    private C2325i p;
    private AuctionHistory q;
    private ConcurrentHashMap<String, C2325i> r;
    private ConcurrentHashMap<String, AuctionHistory.ISAuctionPerformance> s;
    private long t;
    private final Object u;
    private AtomicBoolean v;

    enum BannerManagerState {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    public ProgBannerManager(List<com.ironsource.mediationsdk.model.p> list, C2329k c2329k, com.ironsource.mediationsdk.c.c cVar) {
        super(cVar);
        this.f14703c = BannerManagerState.NONE;
        this.m = "";
        this.u = new Object();
        IronLog.INTERNAL.verbose("isAuctionEnabled = " + c2329k.h());
        this.f14702b = c2329k;
        this.f14704d = new com.ironsource.mediationsdk.g.c(this.f14702b.e());
        this.j = new ConcurrentHashMap<>();
        this.k = new CopyOnWriteArrayList<>();
        this.r = new ConcurrentHashMap<>();
        this.s = new ConcurrentHashMap<>();
        this.i = com.ironsource.mediationsdk.utils.m.a().a(3);
        BannerCallbackThrottler.a().a(this.f14702b.c());
        if (this.f14702b.h()) {
            this.o = new C2323h("banner", this.f14702b.b(), this);
        }
        a(list);
        b(list);
        this.v = new AtomicBoolean(true);
        com.ironsource.mediationsdk.utils.c.c().a(this);
        this.t = new Date().getTime();
        a(BannerManagerState.READY_TO_LOAD);
    }

    private boolean b(int i) {
        return i == 3011 || i == 3110 || i == 3111 || i == 3112 || i == 3115 || i == 3501 || i == 3502;
    }

    private boolean l() {
        boolean z;
        synchronized (this.u) {
            z = this.f14703c == BannerManagerState.LOADING || this.f14703c == BannerManagerState.RELOADING;
        }
        return z;
    }

    private void m() {
        for (int i = this.g; i < this.k.size(); i++) {
            ProgBannerSmash progBannerSmash = this.k.get(i);
            if (progBannerSmash.t()) {
                IronLog.INTERNAL.verbose("loading smash - " + progBannerSmash.A());
                this.g = i + 1;
                e(progBannerSmash);
                return;
            }
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        IronLog.INTERNAL.verbose("");
        AsyncTask.execute(new RunnableC2326ia(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.s.isEmpty()) {
            return;
        }
        this.q.a(this.s);
        this.s.clear();
    }

    private void p() {
        c(e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        long jA = C2335n.a(this.t, this.f14702b.f());
        if (jA <= 0) {
            return false;
        }
        IronLog.INTERNAL.verbose("waiting before auction - timeToWaitBeforeAuction = " + jA);
        new Timer().schedule(new C2328ja(this), jA);
        return true;
    }

    @Override // com.ironsource.mediationsdk.utils.c.a
    public void onPause(Activity activity) {
        this.v.set(false);
    }

    @Override // com.ironsource.mediationsdk.utils.c.a
    public void onResume(Activity activity) {
        this.v.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        IronLog.INTERNAL.verbose("current state = " + this.f14703c);
        if (!a(BannerManagerState.STARTED_LOADING, this.f14702b.h() ? z ? BannerManagerState.AUCTION : BannerManagerState.FIRST_AUCTION : z ? BannerManagerState.RELOADING : BannerManagerState.LOADING)) {
            IronLog.INTERNAL.error("wrong state - " + this.f14703c);
            return;
        }
        this.l = "";
        this.g = 0;
        this.i = com.ironsource.mediationsdk.utils.m.a().a(3);
        if (z) {
            a(3011);
        }
        if (this.f14702b.h()) {
            n();
        } else {
            p();
            m();
        }
    }

    private void e(ProgBannerSmash progBannerSmash) {
        String strF;
        this.h = progBannerSmash;
        if (progBannerSmash.y()) {
            strF = this.r.get(progBannerSmash.r()).f();
            progBannerSmash.a(strF);
        } else {
            strF = null;
        }
        progBannerSmash.a(this.f14705e, this.f14706f, strF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2374v f() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f14705e;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return this.f14705e.getSize().d() ? C2315d.a(com.ironsource.mediationsdk.utils.c.c().b()) ? C2374v.f15058d : C2374v.f15055a : this.f14705e.getSize();
    }

    private C2374v g() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f14705e;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.getSize();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        com.ironsource.mediationsdk.model.f fVar = this.f14706f;
        return fVar != null ? fVar.c() : "";
    }

    private void i() {
        String str = this.k.isEmpty() ? "Empty waterfall" : "No candidates left to load";
        IronLog.INTERNAL.verbose("errorReason = " + str);
        if (a(BannerManagerState.LOADING, BannerManagerState.READY_TO_LOAD)) {
            a(3111, new Object[][]{new Object[]{"errorCode", 606}, new Object[]{"reason", str}});
            BannerCallbackThrottler.a().a(this.f14705e, new com.ironsource.mediationsdk.logger.b(606, str));
        } else {
            if (a(BannerManagerState.RELOADING, BannerManagerState.LOADED)) {
                a(3201);
                this.f14704d.a((c.a) this);
                return;
            }
            a(BannerManagerState.READY_TO_LOAD);
            IronLog.INTERNAL.error("wrong state = " + this.f14703c);
        }
    }

    private void j() {
        String strH = h();
        CappingManager.a(com.ironsource.mediationsdk.utils.c.c().b(), strH);
        if (CappingManager.d(com.ironsource.mediationsdk.utils.c.c().b(), strH)) {
            a(3400);
        }
    }

    private boolean k() {
        boolean z;
        synchronized (this.u) {
            z = this.f14703c == BannerManagerState.FIRST_AUCTION || this.f14703c == BannerManagerState.AUCTION;
        }
        return z;
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2330ka
    public void c(ProgBannerSmash progBannerSmash) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(progBannerSmash.A());
        if (d()) {
            this.f14705e.sendBannerAdScreenPresented();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3113, objArr);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2330ka
    public void d(ProgBannerSmash progBannerSmash) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(progBannerSmash.A());
        if (d()) {
            this.f14705e.sendBannerAdLeftApplication();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3115, objArr);
    }

    private String c(List<C2325i> list) {
        IronLog.INTERNAL.verbose("waterfall.size() = " + list.size());
        this.k.clear();
        this.r.clear();
        this.s.clear();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            C2325i c2325i = list.get(i);
            a(c2325i);
            sb.append(b(c2325i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        IronLog.INTERNAL.verbose("response waterfall = " + sb.toString());
        return sb.toString();
    }

    private boolean d() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f14705e;
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    private List<C2325i> e() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (ProgBannerSmash progBannerSmash : this.j.values()) {
            if (!progBannerSmash.y() && !CappingManager.d(com.ironsource.mediationsdk.utils.c.c().b(), h())) {
                copyOnWriteArrayList.add(new C2325i(progBannerSmash.r()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(List<com.ironsource.mediationsdk.model.p> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.ironsource.mediationsdk.model.p> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().h());
        }
        this.q = new AuctionHistory(arrayList, this.f14702b.b().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(BannerManagerState bannerManagerState, BannerManagerState bannerManagerState2) {
        boolean z;
        synchronized (this.u) {
            if (this.f14703c == bannerManagerState) {
                IronLog.INTERNAL.verbose("set state from '" + this.f14703c + "' to '" + bannerManagerState2 + "'");
                z = true;
                this.f14703c = bannerManagerState2;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2330ka
    public void b(ProgBannerSmash progBannerSmash) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(progBannerSmash.A());
        if (d()) {
            this.f14705e.sendBannerAdClicked();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3112, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BannerManagerState bannerManagerState) {
        IronLog.INTERNAL.verbose("from '" + this.f14703c + "' to '" + bannerManagerState + "'");
        synchronized (this.u) {
            this.f14703c = bannerManagerState;
        }
    }

    @Override // com.ironsource.mediationsdk.g.c.a
    public void b() {
        if (this.v.get()) {
            if (a(BannerManagerState.LOADED, BannerManagerState.STARTED_LOADING)) {
                IronLog.INTERNAL.verbose("start loading");
                b(true);
                return;
            }
            IronLog.INTERNAL.error("wrong state = " + this.f14703c);
            return;
        }
        IronLog.INTERNAL.verbose("app in background - start reload timer");
        a(3200, new Object[][]{new Object[]{"errorCode", 614}});
        this.f14704d.a((c.a) this);
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.f fVar) {
        IronLog.INTERNAL.verbose("");
        if (a(BannerManagerState.READY_TO_LOAD, BannerManagerState.STARTED_LOADING)) {
            if (!BannerCallbackThrottler.a().b()) {
                C2335n.a(ironSourceBannerLayout, fVar, new C2322ga(this, fVar, ironSourceBannerLayout));
                return;
            } else {
                IronLog.INTERNAL.verbose("can't load banner - already has pending invocation");
                return;
            }
        }
        IronLog.API.error("can't load banner - loadBanner already called and still in progress");
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(List<C2325i> list, String str, C2325i c2325i, int i, long j) {
        IronLog.INTERNAL.verbose("auctionId = " + str);
        if (k()) {
            this.m = "";
            this.l = str;
            this.n = i;
            this.p = c2325i;
            a(3502, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            a(this.f14703c == BannerManagerState.FIRST_AUCTION ? BannerManagerState.LOADING : BannerManagerState.RELOADING);
            a(3511, new Object[][]{new Object[]{"ext1", c(list)}});
            m();
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mCurrentState = " + this.f14703c);
    }

    private void b(List<com.ironsource.mediationsdk.model.p> list) {
        for (int i = 0; i < list.size(); i++) {
            com.ironsource.mediationsdk.model.p pVar = list.get(i);
            AbstractC2311b abstractC2311bA = C2313c.a().a(pVar, pVar.d());
            if (abstractC2311bA != null) {
                ProgBannerSmash progBannerSmash = new ProgBannerSmash(this.f14702b, this, pVar, abstractC2311bA, this.i);
                this.j.put(progBannerSmash.r(), progBannerSmash);
            } else {
                IronLog.INTERNAL.verbose(pVar.g() + " can't load adapter");
            }
        }
    }

    private String b(C2325i c2325i) {
        ProgBannerSmash progBannerSmash = this.j.get(c2325i.b());
        String str = "1";
        if (progBannerSmash == null ? !TextUtils.isEmpty(c2325i.f()) : progBannerSmash.y()) {
            str = "2";
        }
        return str + c2325i.b();
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2321g
    public void a(int i, String str, int i2, String str2, long j) {
        IronLog.INTERNAL.verbose("error = " + i + ", " + str);
        if (k()) {
            this.m = str2;
            this.n = i2;
            a(3501, new Object[][]{new Object[]{"duration", Long.valueOf(j)}, new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}});
            a(this.f14703c == BannerManagerState.FIRST_AUCTION ? BannerManagerState.LOADING : BannerManagerState.RELOADING);
            p();
            m();
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mCurrentState = " + this.f14703c);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2330ka
    public void a(ProgBannerSmash progBannerSmash, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose("smash = " + progBannerSmash.A());
        if (l()) {
            ProgBannerSmash progBannerSmash2 = this.h;
            if (progBannerSmash2 != null && !progBannerSmash2.A().equals(progBannerSmash.A())) {
                IronLog.INTERNAL.error("smash is not mActiveSmash it is a different instance");
            }
            a(view, layoutParams);
            this.s.put(progBannerSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceShowedSuccessfully);
            if (this.f14702b.h()) {
                C2325i c2325i = this.r.get(progBannerSmash.r());
                if (c2325i != null) {
                    this.o.a(c2325i, progBannerSmash.s(), this.p);
                    this.o.a(this.k, this.r, progBannerSmash.s(), this.p, c2325i);
                    this.o.a(c2325i, progBannerSmash.s(), this.p, h());
                    a(true, this.r.get(progBannerSmash.r()), h());
                } else {
                    String strR = progBannerSmash.r();
                    IronLog.INTERNAL.error("onLoadSuccess winner instance " + strR + " missing from waterfall. auctionId = " + this.l);
                    a(83317, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{"ext1", strR}});
                }
            }
            if (this.f14703c == BannerManagerState.LOADING) {
                this.f14705e.sendBannerAdLoaded(progBannerSmash.r());
                a(3110);
            }
            j();
            com.ironsource.mediationsdk.utils.m.a().b(3);
            a(BannerManagerState.LOADED);
            this.f14704d.a((c.a) this);
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mCurrentState = " + this.f14703c);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2330ka
    public void a(com.ironsource.mediationsdk.logger.b bVar, ProgBannerSmash progBannerSmash, boolean z) {
        IronLog.INTERNAL.verbose("error = " + bVar);
        if (l()) {
            this.s.put(progBannerSmash.r(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceFailedToLoad);
            m();
            return;
        }
        IronLog.INTERNAL.warning("wrong state - mCurrentState = " + this.f14703c);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2330ka
    public void a(ProgBannerSmash progBannerSmash) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(progBannerSmash.A());
        if (d()) {
            this.f14705e.sendBannerAdScreenDismissed();
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(3114, objArr);
    }

    private void a(View view, FrameLayout.LayoutParams layoutParams) {
        this.f14705e.addViewWithFrameLayoutParams(view, layoutParams);
    }

    private void a(C2325i c2325i) {
        ProgBannerSmash progBannerSmash = this.j.get(c2325i.b());
        if (progBannerSmash != null) {
            AbstractC2311b abstractC2311bA = C2313c.a().a(progBannerSmash.f15009b.g());
            if (abstractC2311bA != null) {
                ProgBannerSmash progBannerSmash2 = new ProgBannerSmash(this.f14702b, this, progBannerSmash.f15009b.g(), abstractC2311bA, this.i, this.l, this.n, this.m);
                progBannerSmash2.b(true);
                this.k.add(progBannerSmash2);
                this.r.put(progBannerSmash2.r(), c2325i);
                this.s.put(c2325i.b(), AuctionHistory.ISAuctionPerformance.ISAuctionPerformanceDidntAttemptToLoad);
                return;
            }
            return;
        }
        IronLog.INTERNAL.error("could not find matching smash for auction response item - item = " + c2325i.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        a(i, (Object[][]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object[][] objArr) {
        JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(false, true, 1);
        try {
            C2374v c2374vG = g();
            if (c2374vG != null) {
                a(jSONObjectA, c2374vG);
            }
            if (this.f14706f != null) {
                jSONObjectA.put("placement", h());
            }
            jSONObjectA.put("sessionDepth", this.i);
            if (!TextUtils.isEmpty(this.l)) {
                jSONObjectA.put("auctionId", this.l);
            }
            if (b(i)) {
                jSONObjectA.put("auctionTrials", this.n);
                if (!TextUtils.isEmpty(this.m)) {
                    jSONObjectA.put("auctionFallback", this.m);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    jSONObjectA.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, jSONObjectA));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void a(JSONObject jSONObject, C2374v c2374v) {
        try {
            String strA = c2374v.a();
            byte b2 = -1;
            switch (strA.hashCode()) {
                case -387072689:
                    if (strA.equals("RECTANGLE")) {
                        b2 = 2;
                    }
                    break;
                case 72205083:
                    if (strA.equals("LARGE")) {
                        b2 = 1;
                    }
                    break;
                case 79011241:
                    if (strA.equals("SMART")) {
                        b2 = 3;
                    }
                    break;
                case 1951953708:
                    if (strA.equals("BANNER")) {
                        b2 = 0;
                    }
                    break;
                case 1999208305:
                    if (strA.equals("CUSTOM")) {
                        b2 = 4;
                    }
                    break;
            }
            if (b2 == 0) {
                jSONObject.put("bannerAdSize", 1);
                return;
            }
            if (b2 == 1) {
                jSONObject.put("bannerAdSize", 2);
                return;
            }
            if (b2 == 2) {
                jSONObject.put("bannerAdSize", 3);
                return;
            }
            if (b2 == 3) {
                jSONObject.put("bannerAdSize", 5);
                return;
            }
            if (b2 != 4) {
                return;
            }
            jSONObject.put("bannerAdSize", 6);
            jSONObject.put("custom_banner_size", c2374v.c() + "x" + c2374v.b());
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
    }
}
