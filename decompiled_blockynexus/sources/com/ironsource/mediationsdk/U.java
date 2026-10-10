package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2360o;
import com.ironsource.mediationsdk.sdk.InterfaceC2363s;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.just.agentweb.WebIndicator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceObject.java */
/* JADX INFO: loaded from: classes2.dex */
public class U implements MediationInitializer.b, InterfaceC2363s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static U f14733a;
    private Activity A;
    private Set<IronSource.AD_UNIT> B;
    private Set<IronSource.AD_UNIT> C;
    private V E;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private Boolean M;
    private IronSourceBannerLayout N;
    private String O;
    private InterfaceC2372u Q;
    private ProgIsManager R;
    private ProgBannerManager S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private CopyOnWriteArraySet<String> Y;
    private CopyOnWriteArraySet<String> Z;
    private DemandOnlyIsManager aa;
    private DemandOnlyRvManager ba;
    private W ca;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC2311b f14736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Na f14737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private M f14738f;
    private C2320fa g;
    private BannerManager h;
    private com.ironsource.mediationsdk.logger.c i;
    private ListenersWrapper j;
    private com.ironsource.mediationsdk.logger.f k;
    private AtomicBoolean l;
    private AtomicBoolean u;
    private List<IronSource.AD_UNIT> w;
    private String x;
    private Context y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14734b = U.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14735c = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:\u200b7.0.2";
    private final Object m = new Object();
    private com.ironsource.mediationsdk.utils.k n = null;
    private String o = null;
    private String p = null;
    private String q = null;
    private String r = null;
    private Map<String, String> s = null;
    private String t = null;
    private boolean v = false;
    private Boolean z = null;
    private boolean D = true;
    private final String F = "sessionDepth";
    private Boolean P = null;

    /* JADX INFO: compiled from: IronSourceObject.java */
    public interface a {
        void a(String str);
    }

    private U() {
        this.x = null;
        t();
        this.l = new AtomicBoolean();
        this.B = new HashSet();
        this.C = new HashSet();
        this.I = false;
        this.H = false;
        this.u = new AtomicBoolean(true);
        this.G = 0;
        this.J = false;
        this.K = false;
        this.L = false;
        this.x = UUID.randomUUID().toString();
        this.M = false;
        this.V = false;
        this.O = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = false;
        this.U = false;
        this.W = false;
        this.Y = new CopyOnWriteArraySet<>();
        this.Z = new CopyOnWriteArraySet<>();
        this.aa = null;
        this.ba = null;
        this.h = null;
        this.X = 1;
        this.ca = new W();
    }

    private void A() {
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.c().e().size(); i++) {
            String str = this.n.c().e().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.n.d().b(str));
            }
        }
        if (arrayList.size() <= 0) {
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        synchronized (this.Z) {
            this.ba = new DemandOnlyRvManager(arrayList, this.n.a().e(), f(), g());
        }
        Iterator<String> it = this.Z.iterator();
        while (it.hasNext()) {
            this.ba.a(it.next(), (String) null, false);
        }
        this.Z.clear();
    }

    private void B() {
        com.ironsource.mediationsdk.model.p pVarB;
        if (this.I) {
            z();
            return;
        }
        this.U = this.n.a().c().g().f();
        a(82000, com.ironsource.mediationsdk.utils.j.a(false, this.U, 1));
        if (this.U) {
            C();
            return;
        }
        int iE = this.n.a().c().e();
        this.f14738f.b(this.n.a().c().c());
        for (int i = 0; i < this.n.c().b().size(); i++) {
            String str = this.n.c().b().get(i);
            if (!TextUtils.isEmpty(str) && (pVarB = this.n.d().b(str)) != null) {
                P p = new P(pVarB, iE);
                if (a(p)) {
                    p.a(this.f14738f);
                    p.a(i + 1);
                    this.f14738f.a((AbstractSmash) p);
                }
            }
        }
        if (this.f14738f.i.size() <= 0) {
            JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(false, false, 1);
            a(jSONObjectA, new Object[][]{new Object[]{"errorCode", 1010}});
            a(82314, jSONObjectA);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        this.f14738f.a(this.n.a().c().d());
        this.f14738f.a(f(), com.ironsource.mediationsdk.utils.j.g());
        if (this.V) {
            this.V = false;
            this.f14738f.h();
        }
    }

    private void C() {
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in programmatic mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.c().b().size(); i++) {
            String str = this.n.c().b().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.n.d().b(str));
            }
        }
        if (arrayList.size() <= 0) {
            JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(false, true, 1);
            a(jSONObjectA, new Object[][]{new Object[]{"errorCode", 1010}});
            a(82314, jSONObjectA);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        this.R = new ProgIsManager(arrayList, this.n.a().c(), f(), com.ironsource.mediationsdk.utils.j.g(), this.n.a().c().c(), this.ca.a());
        Boolean bool = this.z;
        if (bool != null) {
            this.R.a(this.y, bool.booleanValue());
            if (this.z.booleanValue()) {
                this.f14738f.a(this.y, false);
            }
        }
        if (this.V) {
            this.V = false;
            this.R.e();
        }
    }

    private void D() {
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.c().e().size(); i++) {
            String str = this.n.c().e().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.n.d().b(str));
            }
        }
        if (arrayList.size() <= 0) {
            JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(false, true, this.X);
            a(jSONObjectA, new Object[][]{new Object[]{"errorCode", 1010}});
            b(81314, jSONObjectA);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        if (this.n.a().e().h().e()) {
            this.Q = new LWSProgRvManager(arrayList, this.n.a().e(), f(), com.ironsource.mediationsdk.utils.j.g(), this.ca.a());
        } else {
            this.Q = new ProgRvManager(arrayList, this.n.a().e(), f(), com.ironsource.mediationsdk.utils.j.g(), this.ca.a());
        }
        Boolean bool = this.z;
        if (bool != null) {
            this.Q.a(this.y, bool.booleanValue());
            if (this.z.booleanValue()) {
                this.f14737e.a(this.y, false);
            }
        }
    }

    private void E() {
        com.ironsource.mediationsdk.model.p pVarB;
        com.ironsource.mediationsdk.model.p pVarB2;
        com.ironsource.mediationsdk.model.p pVarB3;
        if (this.H) {
            A();
            return;
        }
        this.T = this.n.a().e().h().f();
        this.X = this.n.a().e().h().e() ? 2 : 1;
        b(81000, com.ironsource.mediationsdk.utils.j.a(false, this.T, this.X));
        if (this.T) {
            D();
            return;
        }
        int iF = this.n.a().e().f();
        for (int i = 0; i < this.n.c().e().size(); i++) {
            String str = this.n.c().e().get(i);
            if (!TextUtils.isEmpty(str) && (pVarB3 = this.n.d().b(str)) != null) {
                Pa pa = new Pa(pVarB3, iF);
                if (a(pa)) {
                    pa.a(this.f14737e);
                    pa.a(i + 1);
                    this.f14737e.a((AbstractSmash) pa);
                }
            }
        }
        if (this.f14737e.i.size() <= 0) {
            JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(false, false, this.X);
            a(jSONObjectA, new Object[][]{new Object[]{"errorCode", 1010}});
            b(81314, jSONObjectA);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        this.f14737e.b(this.n.a().e().i().k());
        this.f14737e.a(this.n.a().e().e());
        this.f14737e.b(this.n.a().e().c());
        String strE = this.n.e();
        if (!TextUtils.isEmpty(strE) && (pVarB2 = this.n.d().b(strE)) != null) {
            Pa pa2 = new Pa(pVarB2, iF);
            if (a(pa2)) {
                pa2.a(this.f14737e);
                this.f14737e.b((AbstractSmash) pa2);
            }
        }
        String strF = this.n.f();
        if (!TextUtils.isEmpty(strF) && (pVarB = this.n.d().b(strF)) != null) {
            Pa pa3 = new Pa(pVarB, iF);
            if (a(pa3)) {
                pa3.a(this.f14737e);
                this.f14737e.d((AbstractSmash) pa3);
            }
        }
        this.f14737e.a(f(), com.ironsource.mediationsdk.utils.j.g());
    }

    private void c(Activity activity) {
        AtomicBoolean atomicBoolean = this.l;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        com.ironsource.mediationsdk.b.l.a().a(new com.ironsource.mediationsdk.utils.h(activity.getApplicationContext()));
        com.ironsource.mediationsdk.b.h.g().a(activity.getApplicationContext(), this.E);
        com.ironsource.mediationsdk.b.k.g().a(activity.getApplicationContext(), this.E);
    }

    public static synchronized U e() {
        if (f14733a == null) {
            f14733a = new U();
        }
        return f14733a;
    }

    private com.ironsource.mediationsdk.model.i g(String str) {
        com.ironsource.mediationsdk.model.h hVarC = this.n.a().c();
        if (hVarC != null) {
            return hVarC.a(str);
        }
        return null;
    }

    private void k(String str) {
        String strC = null;
        try {
            com.ironsource.mediationsdk.model.i iVarG = g(str);
            if (iVarG == null) {
                iVarG = q();
            }
            if (iVarG != null) {
                strC = iVarG.c();
            }
        } catch (Exception e2) {
            this.i.a(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e2);
        }
        this.R.a(strC);
    }

    private void l(String str) {
        com.ironsource.mediationsdk.model.l lVarJ = j(str);
        if (lVarJ == null) {
            lVarJ = r();
        }
        if (lVarJ != null) {
            this.Q.a(lVarJ);
            return;
        }
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticRewardedVideo error: empty default placement in response", 3);
        this.j.c(new com.ironsource.mediationsdk.logger.b(1021, "showProgrammaticRewardedVideo error: empty default placement in response"));
    }

    private com.ironsource.mediationsdk.model.i q() {
        com.ironsource.mediationsdk.model.h hVarC = this.n.a().c();
        if (hVarC != null) {
            return hVarC.b();
        }
        return null;
    }

    private com.ironsource.mediationsdk.model.l r() {
        com.ironsource.mediationsdk.model.r rVarE = this.n.a().e();
        if (rVarE != null) {
            return rVarE.b();
        }
        return null;
    }

    private void s() {
        if (this.M.booleanValue()) {
            this.M = false;
            a(this.N, this.O);
            this.N = null;
            this.O = null;
        }
    }

    private void t() {
        this.i = com.ironsource.mediationsdk.logger.c.b(0);
        this.k = new com.ironsource.mediationsdk.logger.f(null, 1);
        this.i.a(this.k);
        this.j = new ListenersWrapper();
        this.f14737e = new Na();
        this.f14737e.a(this.j);
        this.f14738f = new M();
        this.f14738f.a(this.j);
        this.g = new C2320fa();
        this.g.a(this.j);
    }

    private boolean u() {
        com.ironsource.mediationsdk.utils.k kVar = this.n;
        return (kVar == null || kVar.a() == null || this.n.a().b() == null) ? false : true;
    }

    private boolean v() {
        com.ironsource.mediationsdk.utils.k kVar = this.n;
        return (kVar == null || kVar.a() == null || this.n.a().c() == null) ? false : true;
    }

    private boolean w() {
        com.ironsource.mediationsdk.utils.k kVar = this.n;
        return (kVar == null || kVar.a() == null || this.n.a().d() == null) ? false : true;
    }

    private boolean x() {
        com.ironsource.mediationsdk.utils.k kVar = this.n;
        return (kVar == null || kVar.a() == null || this.n.a().e() == null) ? false : true;
    }

    private void y() {
        com.ironsource.mediationsdk.model.p pVarB;
        synchronized (this.M) {
            this.W = this.n.a().b().b().f();
            IronLog.INTERNAL.verbose("mIsBnProgrammatic = " + this.W);
            IronLog.INTERNAL.verbose("mIsBnLoadBeforeInitCompleted = " + this.M);
            a(83000, com.ironsource.mediationsdk.utils.j.a(false, this.W, 1));
            ArrayList<com.ironsource.mediationsdk.model.p> arrayList = new ArrayList<>();
            for (int i = 0; i < this.n.c().a().size(); i++) {
                String str = this.n.c().a().get(i);
                if (!TextUtils.isEmpty(str) && (pVarB = this.n.d().b(str)) != null) {
                    arrayList.add(pVarB);
                }
            }
            if (arrayList.size() <= 0) {
                JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(false, this.W, 1);
                a(jSONObjectA, new Object[][]{new Object[]{"errorCode", 1010}});
                a(83314, jSONObjectA);
                a(IronSource.AD_UNIT.BANNER, false);
            } else if (this.W) {
                a(arrayList);
            } else {
                this.h = new BannerManager(arrayList, f(), com.ironsource.mediationsdk.utils.j.g(), this.n.a().b().a(), this.n.a().b().e(), this.n.a().b().c());
                s();
            }
        }
    }

    private void z() {
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.n.c().b().size(); i++) {
            String str = this.n.c().b().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.n.d().b(str));
            }
        }
        if (arrayList.size() <= 0) {
            JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(false, false, 1);
            a(jSONObjectA, new Object[][]{new Object[]{"errorCode", 1010}});
            a(82314, jSONObjectA);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        synchronized (this.Y) {
            this.aa = new DemandOnlyIsManager(arrayList, this.n.a().c(), f(), g());
        }
        Iterator<String> it = this.Y.iterator();
        while (it.hasNext()) {
            this.aa.a(it.next(), (String) null, false);
        }
        this.Y.clear();
    }

    public void a(long j) {
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(this.H || this.I);
        try {
            jSONObjectB.put("duration", j);
            jSONObjectB.put("sessionDepth", this.G);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(514, jSONObjectB));
    }

    synchronized AbstractC2311b b(String str) {
        try {
            if (this.f14736d != null && this.f14736d.getProviderName().equals(str)) {
                return this.f14736d;
            }
        } catch (Exception e2) {
            this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "getOfferwallAdapter exception: " + e2, 1);
        }
        return null;
    }

    synchronized String d() {
        return this.r;
    }

    public synchronized String f() {
        return this.o;
    }

    synchronized String h() {
        return this.q;
    }

    public synchronized String i() {
        return this.t;
    }

    synchronized Map<String, String> j() {
        return this.s;
    }

    public boolean m() {
        Throwable th;
        boolean zG;
        try {
            if (this.H) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead", 3);
                return false;
            }
            zG = this.T ? this.Q != null && this.Q.a() : this.f14737e.g();
            try {
                JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
                if (this.T) {
                    a(jSONObjectB, new Object[][]{new Object[]{"programmatic", Integer.valueOf(this.X)}});
                }
                com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(zG ? 1101 : 1102, jSONObjectB));
                this.i.b(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + zG, 1);
                return zG;
            } catch (Throwable th2) {
                th = th2;
                this.i.b(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + zG, 1);
                this.i.a(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable()", th);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            zG = false;
        }
    }

    public void n() {
        this.i.b(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", 1);
        try {
            if (this.I) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                CallbackThrottler.a().a(com.ironsource.mediationsdk.utils.g.a("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
                return;
            }
            if (!this.K) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                CallbackThrottler.a().a(com.ironsource.mediationsdk.utils.g.a("init() must be called before loadInterstitial()", "Interstitial"));
                return;
            }
            MediationInitializer.EInitStatus eInitStatusA = MediationInitializer.b().a();
            if (eInitStatusA == MediationInitializer.EInitStatus.INIT_FAILED) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                CallbackThrottler.a().a(com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
                return;
            }
            if (eInitStatusA == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                if (!MediationInitializer.b().c()) {
                    this.V = true;
                    return;
                } else {
                    this.i.b(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    CallbackThrottler.a().a(com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
                    return;
                }
            }
            if (this.n != null && this.n.a() != null && this.n.a().c() != null) {
                if (!this.U) {
                    this.f14738f.h();
                    return;
                } else if (this.R == null) {
                    this.V = true;
                    return;
                } else {
                    this.R.e();
                    return;
                }
            }
            this.i.b(IronSourceLogger.IronSourceTag.API, "No interstitial configurations found", 3);
            CallbackThrottler.a().a(com.ironsource.mediationsdk.utils.g.a("the server response does not contain interstitial data", "Interstitial"));
        } catch (Throwable th) {
            this.i.a(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            CallbackThrottler.a().a(new com.ironsource.mediationsdk.logger.b(510, th.getMessage()));
        }
    }

    public void o() {
        this.i.b(IronSourceLogger.IronSourceTag.API, "showInterstitial()", 1);
        try {
            if (this.I) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                this.j.b(new com.ironsource.mediationsdk.logger.b(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"));
            } else {
                if (!v()) {
                    this.j.b(com.ironsource.mediationsdk.utils.g.a("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
                    return;
                }
                com.ironsource.mediationsdk.model.i iVarQ = q();
                if (iVarQ != null) {
                    c(iVarQ.c());
                } else {
                    this.j.b(new com.ironsource.mediationsdk.logger.b(1020, "showInterstitial error: empty default placement in response"));
                }
            }
        } catch (Exception e2) {
            this.i.a(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e2);
            this.j.b(new com.ironsource.mediationsdk.logger.b(510, e2.getMessage()));
        }
    }

    public void p() {
        if (!x()) {
            this.j.c(com.ironsource.mediationsdk.utils.g.a("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
            this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        com.ironsource.mediationsdk.model.l lVarR = r();
        if (lVarR != null) {
            d(lVarR.c());
            return;
        }
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
        this.j.c(new com.ironsource.mediationsdk.logger.b(1021, "showRewardedVideo error: empty default placement in response"));
    }

    private CappingManager.ECappingStatus f(String str) {
        com.ironsource.mediationsdk.utils.k kVar = this.n;
        if (kVar == null || kVar.a() == null || this.n.a().c() == null) {
            return CappingManager.ECappingStatus.NOT_CAPPED;
        }
        com.ironsource.mediationsdk.model.i iVarG = null;
        try {
            iVarG = g(str);
            if (iVarG == null && (iVarG = q()) == null) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iVarG == null ? CappingManager.ECappingStatus.NOT_CAPPED : CappingManager.c(this.A, iVarG);
    }

    private com.ironsource.mediationsdk.model.i h(String str) {
        com.ironsource.mediationsdk.model.i iVarG = g(str);
        if (iVarG == null) {
            this.i.b(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            iVarG = q();
            if (iVarG == null) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String strA = a(iVarG.c(), f(iVarG.c()));
        if (TextUtils.isEmpty(strA)) {
            return iVarG;
        }
        this.i.b(IronSourceLogger.IronSourceTag.API, strA, 1);
        this.j.a(iVarG);
        this.j.b(com.ironsource.mediationsdk.utils.g.a(strA));
        return null;
    }

    private com.ironsource.mediationsdk.model.l i(String str) {
        com.ironsource.mediationsdk.model.l lVarJ = j(str);
        if (lVarJ == null) {
            this.i.b(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            lVarJ = r();
            if (lVarJ == null) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String strA = a(lVarJ.c(), CappingManager.c(this.A, lVarJ));
        if (TextUtils.isEmpty(strA)) {
            return lVarJ;
        }
        this.i.b(IronSourceLogger.IronSourceTag.API, strA, 1);
        this.j.c(com.ironsource.mediationsdk.utils.g.a(strA));
        return null;
    }

    private com.ironsource.mediationsdk.model.l j(String str) {
        com.ironsource.mediationsdk.model.r rVarE = this.n.a().e();
        if (rVarE != null) {
            return rVarE.a(str);
        }
        return null;
    }

    public void d(String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        this.i.b(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (this.H) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                this.j.c(com.ironsource.mediationsdk.utils.g.a("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", "Rewarded Video"));
                return;
            }
            if (!x()) {
                this.j.c(com.ironsource.mediationsdk.utils.g.a("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
                return;
            }
            if (this.T && this.Q != null) {
                l(str);
                return;
            }
            com.ironsource.mediationsdk.model.l lVarI = i(str);
            if (lVarI != null) {
                this.f14737e.a(lVarI);
                this.f14737e.b(lVarI.c());
            }
        } catch (Exception e2) {
            this.i.a(IronSourceLogger.IronSourceTag.API, str2, e2);
            this.j.c(new com.ironsource.mediationsdk.logger.b(510, e2.getMessage()));
        }
    }

    public synchronized String g() {
        return this.p;
    }

    private com.ironsource.mediationsdk.model.f e(String str) {
        com.ironsource.mediationsdk.model.e eVarB = this.n.a().b();
        if (eVarB == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return eVarB.f();
        }
        com.ironsource.mediationsdk.model.f fVarA = eVarB.a(str);
        return fVarA != null ? fVarA : eVarB.f();
    }

    public void c(String str) {
        String str2 = "showInterstitial(" + str + ")";
        this.i.b(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (this.I) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                this.j.b(new com.ironsource.mediationsdk.logger.b(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"));
                return;
            }
            if (!v()) {
                this.j.b(com.ironsource.mediationsdk.utils.g.a("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
                return;
            }
            if (this.U) {
                k(str);
                return;
            }
            com.ironsource.mediationsdk.model.i iVarH = h(str);
            JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
            try {
                if (iVarH != null) {
                    jSONObjectB.put("placement", iVarH.c());
                } else if (!TextUtils.isEmpty(str)) {
                    jSONObjectB.put("placement", str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(AdError.BROKEN_MEDIA_ERROR_CODE, jSONObjectB));
            if (iVarH != null) {
                this.f14738f.a(iVarH);
                this.f14738f.b(iVarH.c());
            }
        } catch (Exception e3) {
            this.i.a(IronSourceLogger.IronSourceTag.API, str2, e3);
            this.j.b(new com.ironsource.mediationsdk.logger.b(510, e3.getMessage()));
        }
    }

    public void b(Activity activity) {
        try {
            this.A = activity;
            this.i.b(IronSourceLogger.IronSourceTag.API, "onResume()", 1);
            com.ironsource.mediationsdk.utils.c.c().b(activity);
            if (this.h != null) {
                this.h.b();
            }
        } catch (Throwable th) {
            this.i.a(IronSourceLogger.IronSourceTag.API, "onResume()", th);
        }
    }

    public synchronized String k() {
        return this.x;
    }

    public boolean l() {
        Throwable th;
        boolean z;
        try {
            if (this.I) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead", 3);
                return false;
            }
            z = !this.U ? this.f14738f == null || !this.f14738f.g() : this.R == null || !this.R.d();
            try {
                com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(z ? 2101 : 2102, com.ironsource.mediationsdk.utils.j.a(false, this.U, 1)));
                this.i.b(IronSourceLogger.IronSourceTag.API, "isInterstitialReady():" + z, 1);
                return z;
            } catch (Throwable th2) {
                th = th2;
                this.i.b(IronSourceLogger.IronSourceTag.API, "isInterstitialReady():" + z, 1);
                this.i.a(IronSourceLogger.IronSourceTag.API, "isInterstitialReady()", th);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    public synchronized void a(Activity activity, String str, boolean z, IronSource.AD_UNIT... ad_unitArr) {
        IronLog.INTERNAL.verbose("");
        if (this.u != null && this.u.compareAndSet(true, false)) {
            if (ad_unitArr == null || ad_unitArr.length == 0) {
                for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                    this.B.add(ad_unit);
                }
                this.J = true;
                this.K = true;
                this.L = true;
            } else {
                for (IronSource.AD_UNIT ad_unit2 : ad_unitArr) {
                    this.B.add(ad_unit2);
                    this.C.add(ad_unit2);
                    if (ad_unit2.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                        this.K = true;
                    }
                    if (ad_unit2.equals(IronSource.AD_UNIT.BANNER)) {
                        this.L = true;
                    }
                    if (ad_unit2.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                        this.J = true;
                    }
                }
            }
            this.i.b(IronSourceLogger.IronSourceTag.API, "init(appKey:" + str + ")", 1);
            if (activity == null) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "Init Fail - provided activity is null", 2);
                return;
            }
            com.ironsource.mediationsdk.utils.c.c().c(activity);
            AuctionDataUtils.b().c();
            this.A = activity;
            c(activity);
            com.ironsource.mediationsdk.a.b bVarN = n(str);
            if (bVarN.b()) {
                this.o = str;
                if (this.D) {
                    JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(z);
                    try {
                        String str2 = ",androidx=" + com.ironsource.mediationsdk.utils.j.h();
                        if (com.ironsource.environment.a.a()) {
                            jSONObjectB.put("ext1", "appLanguage=Kotlin" + str2);
                        } else {
                            jSONObjectB.put("ext1", "appLanguage=Java" + str2);
                        }
                        if (ad_unitArr != null) {
                            for (IronSource.AD_UNIT ad_unit3 : ad_unitArr) {
                                jSONObjectB.put(ad_unit3.toString(), true);
                            }
                        }
                        int i = this.G + 1;
                        this.G = i;
                        jSONObjectB.put("sessionDepth", i);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(14, jSONObjectB));
                    this.D = false;
                }
                if (this.B.contains(IronSource.AD_UNIT.INTERSTITIAL)) {
                    MediationInitializer.b().a(this.f14738f);
                }
                MediationInitializer.b().a(this);
                MediationInitializer.b().a(activity, str, this.p, ad_unitArr);
            } else {
                MediationInitializer.b().d();
                if (this.B.contains(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    this.j.a(false);
                }
                if (this.B.contains(IronSource.AD_UNIT.OFFERWALL)) {
                    this.j.a(false, bVarN.a());
                }
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, bVarN.a().toString(), 1);
            }
        } else if (ad_unitArr != null) {
            a(z, ad_unitArr);
        } else {
            this.i.b(IronSourceLogger.IronSourceTag.API, "Multiple calls to init without ad units are not allowed", 3);
        }
    }

    private com.ironsource.mediationsdk.utils.k b(Context context, String str, a aVar) {
        com.ironsource.mediationsdk.utils.k kVar;
        String str2;
        if (!com.ironsource.mediationsdk.utils.j.d(context)) {
            return null;
        }
        try {
            String strA = a(context);
            if (TextUtils.isEmpty(strA)) {
                strA = com.ironsource.environment.b.l(context);
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            str2 = strA;
        } catch (Exception e2) {
            e = e2;
            kVar = null;
        }
        if (this.E == null) {
            String strA2 = com.ironsource.mediationsdk.f.a.a(com.ironsource.mediationsdk.f.d.a(context, f(), str, str2, i(), null), aVar);
            if (strA2 == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (com.ironsource.mediationsdk.utils.j.d() == 1) {
                IronLog.INTERNAL.verbose("encrypt");
                String strOptString = new JSONObject(strA2).optString("response", null);
                if (TextUtils.isEmpty(strOptString)) {
                    IronLog.INTERNAL.warning("encryptedResponse is empty - return null");
                    return null;
                }
                strA2 = com.ironsource.mediationsdk.utils.i.a("C38FB23A402222A0C17D34A92F971D1F", strOptString);
            }
            kVar = new com.ironsource.mediationsdk.utils.k(context, f(), str, strA2);
            try {
                if (!kVar.g()) {
                    IronLog.INTERNAL.warning("response invalid - return null");
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                IronLog.INTERNAL.warning("exception = " + e);
                e.printStackTrace();
            }
            return kVar;
        }
        this.E.b();
        throw null;
    }

    private boolean m(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    com.ironsource.mediationsdk.utils.k c() {
        return this.n;
    }

    private com.ironsource.mediationsdk.a.b n(String str) {
        com.ironsource.mediationsdk.a.b bVar = new com.ironsource.mediationsdk.a.b();
        if (str != null) {
            if (a(str, 5, 10)) {
                if (!m(str)) {
                    bVar.a(com.ironsource.mediationsdk.utils.g.a("appKey", str, "should contain only english characters and numbers"));
                }
            } else {
                bVar.a(com.ironsource.mediationsdk.utils.g.a("appKey", str, "length should be between 5-10 characters"));
            }
        } else {
            bVar.a(new com.ironsource.mediationsdk.logger.b(506, "Init Fail - appKey is missing"));
        }
        return bVar;
    }

    private void b(com.ironsource.mediationsdk.utils.k kVar, Context context) {
        a(kVar);
        a(kVar, context);
    }

    private void b(int i, JSONObject jSONObject) {
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, jSONObject));
    }

    Boolean b() {
        return this.P;
    }

    private synchronized void a(boolean z, IronSource.AD_UNIT... ad_unitArr) {
        int i = 0;
        for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
            if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                this.K = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                this.L = true;
            }
        }
        if (MediationInitializer.b().a() == MediationInitializer.EInitStatus.INIT_FAILED) {
            try {
                if (this.j != null) {
                    int length = ad_unitArr.length;
                    while (i < length) {
                        IronSource.AD_UNIT ad_unit2 = ad_unitArr[i];
                        if (!this.B.contains(ad_unit2)) {
                            a(ad_unit2, true);
                        }
                        i++;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!this.v) {
            JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(z);
            int length2 = ad_unitArr.length;
            boolean z2 = false;
            while (i < length2) {
                IronSource.AD_UNIT ad_unit3 = ad_unitArr[i];
                if (!this.B.contains(ad_unit3)) {
                    this.B.add(ad_unit3);
                    this.C.add(ad_unit3);
                    try {
                        jSONObjectB.put(ad_unit3.toString(), true);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    z2 = true;
                } else {
                    this.i.b(IronSourceLogger.IronSourceTag.API, ad_unit3 + " ad unit has started initializing.", 3);
                }
                i++;
            }
            if (z2) {
                try {
                    String str = ",androidx=" + com.ironsource.mediationsdk.utils.j.h();
                    if (com.ironsource.environment.a.a()) {
                        jSONObjectB.put("ext1", "appLanguage=Kotlin" + str);
                    } else {
                        jSONObjectB.put("ext1", "appLanguage=Java" + str);
                    }
                    int i2 = this.G + 1;
                    this.G = i2;
                    jSONObjectB.put("sessionDepth", i2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(14, jSONObjectB));
            }
        }
        if (this.w == null) {
            return;
        }
        JSONObject jSONObjectB2 = com.ironsource.mediationsdk.utils.j.b(z);
        boolean z3 = false;
        for (IronSource.AD_UNIT ad_unit4 : ad_unitArr) {
            if (!this.B.contains(ad_unit4)) {
                this.B.add(ad_unit4);
                this.C.add(ad_unit4);
                try {
                    jSONObjectB2.put(ad_unit4.toString(), true);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                if (this.w != null && this.w.contains(ad_unit4)) {
                    a(ad_unit4);
                } else {
                    a(ad_unit4, false);
                }
                z3 = true;
            } else {
                this.i.b(IronSourceLogger.IronSourceTag.API, ad_unit4 + " ad unit has already been initialized", 3);
            }
        }
        if (z3) {
            try {
                String str2 = ",androidx=" + com.ironsource.mediationsdk.utils.j.h();
                if (com.ironsource.environment.a.a()) {
                    jSONObjectB2.put("ext1", "appLanguage=Kotlin" + str2);
                } else {
                    jSONObjectB2.put("ext1", "appLanguage=Java" + str2);
                }
                int i3 = this.G + 1;
                this.G = i3;
                jSONObjectB2.put("sessionDepth", i3);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(14, jSONObjectB2));
        }
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.b
    public void a(List<IronSource.AD_UNIT> list, boolean z) {
        IronLog.INTERNAL.verbose("");
        try {
            this.w = list;
            this.v = true;
            this.i.b(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            com.ironsource.mediationsdk.utils.j.c("init success");
            if (z) {
                JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
                try {
                    jSONObjectB.put("revived", true);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(114, jSONObjectB));
            }
            com.ironsource.mediationsdk.b.h.g().f();
            com.ironsource.mediationsdk.b.k.g().f();
            C2313c.a().a(f(), g());
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.B.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        a(ad_unit);
                    } else {
                        a(ad_unit, false);
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        int i = T.f14728a[ad_unit.ordinal()];
        if (i == 1) {
            E();
            return;
        }
        if (i == 2) {
            B();
        } else if (i == 3) {
            this.g.a(f(), g());
        } else {
            if (i != 4) {
                return;
            }
            y();
        }
    }

    private void a(ArrayList<com.ironsource.mediationsdk.model.p> arrayList) {
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
        this.S = new ProgBannerManager(arrayList, new C2329k(f(), com.ironsource.mediationsdk.utils.j.g(), this.n.a().b()), this.ca.a());
        s();
    }

    private boolean a(AbstractSmash abstractSmash) {
        return abstractSmash.t() >= 1 && abstractSmash.u() >= 1;
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.b
    public void a(String str) {
        try {
            this.i.b(IronSourceLogger.IronSourceTag.API, "onInitFailed(reason:" + str + ")", 1);
            com.ironsource.mediationsdk.utils.j.c("Mediation init failed");
            if (this.j != null) {
                Iterator<IronSource.AD_UNIT> it = this.B.iterator();
                while (it.hasNext()) {
                    a(it.next(), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.b
    public void a() {
        synchronized (this.M) {
            if (this.M.booleanValue()) {
                this.M = false;
                BannerCallbackThrottler.a().a(this.N, new com.ironsource.mediationsdk.logger.b(603, "init had failed"));
                this.N = null;
                this.O = null;
            }
        }
        if (this.V) {
            this.V = false;
            CallbackThrottler.a().a(com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
        }
        synchronized (this.Y) {
            Iterator<String> it = this.Y.iterator();
            while (it.hasNext()) {
                C.a().a(it.next(), com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
            }
            this.Y.clear();
        }
        synchronized (this.Z) {
            Iterator<String> it2 = this.Z.iterator();
            while (it2.hasNext()) {
                Ca.a().a(it2.next(), com.ironsource.mediationsdk.utils.g.a("init() had failed", "Rewarded Video"));
            }
            this.Z.clear();
        }
    }

    private void a(IronSource.AD_UNIT ad_unit, boolean z) {
        int i = T.f14728a[ad_unit.ordinal()];
        if (i == 1) {
            if (this.H) {
                Iterator<String> it = this.Z.iterator();
                while (it.hasNext()) {
                    Ca.a().a(it.next(), com.ironsource.mediationsdk.utils.g.a("initISDemandOnly() had failed", "Rewarded Video"));
                }
                this.Z.clear();
                return;
            }
            if (z || x() || this.C.contains(ad_unit)) {
                this.j.a(false);
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.I) {
                Iterator<String> it2 = this.Y.iterator();
                while (it2.hasNext()) {
                    C.a().a(it2.next(), com.ironsource.mediationsdk.utils.g.a("initISDemandOnly() had failed", "Interstitial"));
                }
                this.Y.clear();
                return;
            }
            if (this.V) {
                this.V = false;
                CallbackThrottler.a().a(com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
                return;
            }
            return;
        }
        if (i == 3) {
            if (z || w() || this.C.contains(ad_unit)) {
                this.j.b(false);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        synchronized (this.M) {
            if (this.M.booleanValue()) {
                this.M = false;
                BannerCallbackThrottler.a().a(this.N, new com.ironsource.mediationsdk.logger.b(602, "Init had failed"));
                this.N = null;
                this.O = null;
            }
        }
    }

    synchronized void a(AbstractC2311b abstractC2311b) {
        this.f14736d = abstractC2311b;
    }

    public void a(Activity activity) {
        try {
            this.i.b(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            com.ironsource.mediationsdk.utils.c.c().a(activity);
            if (this.h != null) {
                this.h.a();
            }
        } catch (Throwable th) {
            this.i.a(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    public void a(com.ironsource.mediationsdk.sdk.U u) {
        if (u == null) {
            this.i.b(IronSourceLogger.IronSourceTag.API, "setRewardedVideoListener(RVListener:null)", 1);
        } else {
            this.i.b(IronSourceLogger.IronSourceTag.API, "setRewardedVideoListener(RVListener)", 1);
        }
        this.j.a(u);
        La.a().a(u);
    }

    public void a(InterfaceC2360o interfaceC2360o) {
        if (interfaceC2360o == null) {
            this.i.b(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener:null)", 1);
        } else {
            this.i.b(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener)", 1);
        }
        this.j.a(interfaceC2360o);
        K.a().a(interfaceC2360o);
        CallbackThrottler.a().a(interfaceC2360o);
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        IronLog.INTERNAL.verbose("placementName = " + str);
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            if (!this.L) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
                BannerCallbackThrottler.a().a(ironSourceBannerLayout, com.ironsource.mediationsdk.utils.g.c("init() must be called before loadBanner()"));
                return;
            }
            if (ironSourceBannerLayout.getSize().a().equals("CUSTOM") && (ironSourceBannerLayout.getSize().c() <= 0 || ironSourceBannerLayout.getSize().b() <= 0)) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
                BannerCallbackThrottler.a().a(ironSourceBannerLayout, com.ironsource.mediationsdk.utils.g.h(""));
                return;
            }
            MediationInitializer.EInitStatus eInitStatusA = MediationInitializer.b().a();
            if (eInitStatusA == MediationInitializer.EInitStatus.INIT_FAILED) {
                this.i.b(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                BannerCallbackThrottler.a().a(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(WebIndicator.DO_END_ANIMATION_DURATION, "Init() had failed"));
                return;
            }
            if (eInitStatusA == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                if (MediationInitializer.b().c()) {
                    this.i.b(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    BannerCallbackThrottler.a().a(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(601, "Init had failed"));
                    return;
                } else {
                    this.N = ironSourceBannerLayout;
                    this.M = true;
                    this.O = str;
                    return;
                }
            }
            synchronized (this.M) {
                if (this.h == null && this.S == null) {
                    this.N = ironSourceBannerLayout;
                    this.M = true;
                    this.O = str;
                    return;
                }
                com.ironsource.mediationsdk.utils.k kVar = this.n;
                if (kVar != null && kVar.a() != null && this.n.a().b() != null) {
                    if (!this.W) {
                        this.h.a(ironSourceBannerLayout, e(str));
                        return;
                    } else {
                        this.S.a(ironSourceBannerLayout, e(str));
                        return;
                    }
                }
                this.i.b(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
                BannerCallbackThrottler.a().a(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(615, "No banner configurations found"));
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("loadBanner can't be called - ");
        sb.append(ironSourceBannerLayout == null ? "banner layout is null " : "banner layout is destroyed");
        String string = sb.toString();
        this.i.b(IronSourceLogger.IronSourceTag.API, string, 3);
        BannerCallbackThrottler.a().a(ironSourceBannerLayout, com.ironsource.mediationsdk.utils.g.c(string));
    }

    com.ironsource.mediationsdk.utils.k a(Context context, String str, a aVar) {
        synchronized (this.m) {
            if (this.n != null) {
                return new com.ironsource.mediationsdk.utils.k(this.n);
            }
            com.ironsource.mediationsdk.utils.k kVarB = b(context, str, aVar);
            if (kVarB == null || !kVarB.g()) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "Null or invalid response. Trying to get cached response", 0);
                kVarB = a(context, str);
            }
            if (kVarB != null) {
                this.n = kVarB;
                com.ironsource.mediationsdk.utils.j.f(context, kVarB.toString());
                b(this.n, context);
            }
            com.ironsource.mediationsdk.b.h.g().a(true);
            com.ironsource.mediationsdk.b.k.g().a(true);
            return kVarB;
        }
    }

    private com.ironsource.mediationsdk.utils.k a(Context context, String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(com.ironsource.mediationsdk.utils.j.c(context));
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("appKey");
        String strOptString2 = jSONObject.optString("userId");
        String strOptString3 = jSONObject.optString("response");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3) || f() == null || !strOptString.equals(f()) || !strOptString2.equals(str)) {
            return null;
        }
        com.ironsource.mediationsdk.utils.k kVar = new com.ironsource.mediationsdk.utils.k(context, strOptString, strOptString2, strOptString3);
        com.ironsource.mediationsdk.logger.b bVarC = com.ironsource.mediationsdk.utils.g.c(strOptString, strOptString2);
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, bVarC.toString(), 1);
        this.i.b(IronSourceLogger.IronSourceTag.INTERNAL, bVarC.toString() + ": " + kVar.toString(), 1);
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(140, com.ironsource.mediationsdk.utils.j.b(false)));
        return kVar;
    }

    private void a(com.ironsource.mediationsdk.utils.k kVar, Context context) {
        boolean zJ = x() ? kVar.a().e().i().j() : false;
        boolean zJ2 = v() ? kVar.a().c().h().j() : false;
        boolean zJ3 = u() ? kVar.a().b().d().j() : false;
        boolean zJ4 = w() ? kVar.a().d().a().j() : false;
        if (zJ) {
            com.ironsource.mediationsdk.model.c cVarI = kVar.a().e().i();
            com.ironsource.mediationsdk.b.k.g().b(cVarI.b(), context);
            com.ironsource.mediationsdk.b.k.g().a(cVarI.c(), context);
            com.ironsource.mediationsdk.b.k.g().d(cVarI.e());
            com.ironsource.mediationsdk.b.k.g().c(cVarI.d());
            com.ironsource.mediationsdk.b.k.g().b(cVarI.a());
            com.ironsource.mediationsdk.b.k.g().c(cVarI.h(), context);
            com.ironsource.mediationsdk.b.k.g().b(cVarI.g(), context);
            com.ironsource.mediationsdk.b.k.g().d(cVarI.i(), context);
            com.ironsource.mediationsdk.b.k.g().a(cVarI.f(), context);
            com.ironsource.mediationsdk.b.k.g().a(kVar.a().a().c());
        } else if (zJ4) {
            com.ironsource.mediationsdk.model.c cVarA = kVar.a().d().a();
            com.ironsource.mediationsdk.b.k.g().b(cVarA.b(), context);
            com.ironsource.mediationsdk.b.k.g().a(cVarA.c(), context);
            com.ironsource.mediationsdk.b.k.g().d(cVarA.e());
            com.ironsource.mediationsdk.b.k.g().c(cVarA.d());
            com.ironsource.mediationsdk.b.k.g().b(cVarA.a());
            com.ironsource.mediationsdk.b.k.g().c(cVarA.h(), context);
            com.ironsource.mediationsdk.b.k.g().b(cVarA.g(), context);
            com.ironsource.mediationsdk.b.k.g().d(cVarA.i(), context);
            com.ironsource.mediationsdk.b.k.g().a(cVarA.f(), context);
            com.ironsource.mediationsdk.b.k.g().a(kVar.a().a().c());
        } else {
            com.ironsource.mediationsdk.b.k.g().b(false);
        }
        if (zJ2) {
            com.ironsource.mediationsdk.model.c cVarH = kVar.a().c().h();
            com.ironsource.mediationsdk.b.h.g().b(cVarH.b(), context);
            com.ironsource.mediationsdk.b.h.g().a(cVarH.c(), context);
            com.ironsource.mediationsdk.b.h.g().d(cVarH.e());
            com.ironsource.mediationsdk.b.h.g().c(cVarH.d());
            com.ironsource.mediationsdk.b.h.g().b(cVarH.a());
            com.ironsource.mediationsdk.b.h.g().c(cVarH.h(), context);
            com.ironsource.mediationsdk.b.h.g().b(cVarH.g(), context);
            com.ironsource.mediationsdk.b.h.g().d(cVarH.i(), context);
            com.ironsource.mediationsdk.b.h.g().a(cVarH.f(), context);
            com.ironsource.mediationsdk.b.h.g().a(kVar.a().a().c());
            return;
        }
        if (zJ3) {
            com.ironsource.mediationsdk.model.c cVarD = kVar.a().b().d();
            com.ironsource.mediationsdk.b.h.g().b(cVarD.b(), context);
            com.ironsource.mediationsdk.b.h.g().a(cVarD.c(), context);
            com.ironsource.mediationsdk.b.h.g().d(cVarD.e());
            com.ironsource.mediationsdk.b.h.g().c(cVarD.d());
            com.ironsource.mediationsdk.b.h.g().b(cVarD.a());
            com.ironsource.mediationsdk.b.h.g().c(cVarD.h(), context);
            com.ironsource.mediationsdk.b.h.g().b(cVarD.g(), context);
            com.ironsource.mediationsdk.b.h.g().d(cVarD.i(), context);
            com.ironsource.mediationsdk.b.h.g().a(cVarD.f(), context);
            com.ironsource.mediationsdk.b.h.g().a(kVar.a().a().c());
            return;
        }
        com.ironsource.mediationsdk.b.h.g().b(false);
    }

    private void a(com.ironsource.mediationsdk.utils.k kVar) {
        this.k.a(kVar.a().a().b().b());
        this.i.a("console", kVar.a().a().b().a());
    }

    synchronized void a(String str, boolean z) {
        IronLog.API.verbose("userId = " + str + ", isFromPublisher = " + z);
        this.p = str;
        if (z) {
            com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(52, com.ironsource.mediationsdk.utils.j.a(false)));
        }
    }

    private boolean a(String str, int i, int i2) {
        return str != null && str.length() >= i && str.length() <= i2;
    }

    public String a(Context context) {
        try {
            String[] strArrC = com.ironsource.environment.b.c(context);
            if (strArrC.length > 0 && strArrC[0] != null) {
                return strArrC[0];
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public void a(Context context, boolean z) {
        this.y = context;
        this.z = Boolean.valueOf(z);
        if (this.U) {
            ProgIsManager progIsManager = this.R;
            if (progIsManager != null) {
                progIsManager.a(context, z);
            }
        } else {
            M m = this.f14738f;
            if (m != null) {
                m.a(context, z);
            }
        }
        if (this.T) {
            InterfaceC2372u interfaceC2372u = this.Q;
            if (interfaceC2372u != null) {
                interfaceC2372u.a(context, z);
                return;
            }
            return;
        }
        Na na = this.f14737e;
        if (na != null) {
            na.a(context, z);
        }
    }

    private void a(int i, JSONObject jSONObject) {
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, jSONObject));
    }

    String a(String str, CappingManager.ECappingStatus eCappingStatus) {
        if (eCappingStatus == null) {
            return null;
        }
        int i = T.f14729b[eCappingStatus.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            return null;
        }
        return "placement " + str + " is capped";
    }

    private void a(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e2), 3);
            }
        }
    }
}
