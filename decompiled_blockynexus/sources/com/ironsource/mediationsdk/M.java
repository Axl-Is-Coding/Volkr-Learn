package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2361p;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.utils.CappingManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: InterstitialManager.java */
/* JADX INFO: loaded from: classes2.dex */
class M extends AbstractC2309a implements MediationInitializer.b, InterfaceC2361p, com.ironsource.mediationsdk.utils.d {
    private long C;
    private boolean D;
    private ListenersWrapper t;
    private boolean w;
    private com.ironsource.mediationsdk.model.i x;
    private final String s = M.class.getName();
    private CopyOnWriteArraySet<String> B = new CopyOnWriteArraySet<>();
    private Map<String, P> A = new ConcurrentHashMap();
    private CallbackThrottler y = CallbackThrottler.a();
    private boolean z = false;
    private boolean v = false;
    private boolean u = false;

    M() {
        this.g = new com.ironsource.mediationsdk.utils.f("interstitial", this);
        this.D = false;
    }

    private synchronized void i() {
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                abstractSmash.a(AbstractSmash.MEDIATION_STATE.INITIATED);
            }
        }
    }

    private void j() {
        if (k()) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            for (AbstractSmash abstractSmash : this.i) {
                if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                    abstractSmash.j();
                }
            }
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
        }
    }

    private boolean k() {
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INIT_PENDING || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INITIATED || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                return false;
            }
        }
        return true;
    }

    private void l() {
        for (int i = 0; i < this.i.size(); i++) {
            String strI = this.i.get(i).f14598c.i();
            if (strI.equalsIgnoreCase("IronSource") || strI.equalsIgnoreCase("SupersonicAds")) {
                C2313c.a().a(this.i.get(i).f14598c, this.i.get(i).f14598c.f());
                return;
            }
        }
    }

    private AbstractC2311b m() {
        AbstractC2311b abstractC2311bH = null;
        int i = 0;
        for (int i2 = 0; i2 < this.i.size() && abstractC2311bH == null; i2++) {
            if (this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.AVAILABLE || this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.INITIATED || this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.INIT_PENDING || this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING) {
                i++;
                if (i >= this.h) {
                    break;
                }
            } else if (this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED && (abstractC2311bH = h((P) this.i.get(i2))) == null) {
                this.i.get(i2).a(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            }
        }
        return abstractC2311bH;
    }

    public void a(ListenersWrapper listenersWrapper) {
        this.t = listenersWrapper;
        this.y.a(listenersWrapper);
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.b
    public void a(List<IronSource.AD_UNIT> list, boolean z) {
    }

    public void b(String str) {
        if (this.D) {
            this.n.b(IronSourceLogger.IronSourceTag.API, "showInterstitial error: can't show ad while an ad is already showing", 3);
            this.t.b(new com.ironsource.mediationsdk.logger.b(1036, "showInterstitial error: can't show ad while an ad is already showing"));
            return;
        }
        if (!this.u) {
            this.n.b(IronSourceLogger.IronSourceTag.API, "showInterstitial failed - You need to load interstitial before showing it", 3);
            this.t.b(com.ironsource.mediationsdk.utils.g.b("Interstitial", "showInterstitial failed - You need to load interstitial before showing it"));
            return;
        }
        if (this.o && !com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().b())) {
            this.n.b(IronSourceLogger.IronSourceTag.API, "showInterstitial error: can't show ad when there's no internet connection", 3);
            this.t.b(com.ironsource.mediationsdk.utils.g.f("Interstitial"));
            return;
        }
        for (int i = 0; i < this.i.size(); i++) {
            AbstractSmash abstractSmash = this.i.get(i);
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                CappingManager.b(com.ironsource.mediationsdk.utils.c.c().b(), this.x);
                if (CappingManager.c(com.ironsource.mediationsdk.utils.c.c().b(), this.x) != CappingManager.ECappingStatus.NOT_CAPPED) {
                    b(2400, (Object[][]) null);
                }
                b(2201, abstractSmash, null);
                this.D = true;
                ((P) abstractSmash).I();
                if (abstractSmash.A()) {
                    a(2401, abstractSmash);
                }
                this.g.b(abstractSmash);
                if (this.g.c(abstractSmash)) {
                    abstractSmash.a(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                    a(250, abstractSmash, new Object[][]{new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE}});
                }
                this.u = false;
                if (abstractSmash.C()) {
                    return;
                }
                m();
                return;
            }
        }
        this.t.b(com.ironsource.mediationsdk.utils.g.b("Interstitial", "showInterstitial failed - No adapters ready to show"));
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public void c(P p) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdClicked()", 1);
        b(AdError.INTERNAL_ERROR_2006, p, null);
        this.t.d();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public void d(P p) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdVisible()", 1);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public void e(P p) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdClosed()", 1);
        this.D = false;
        b(2204, p, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(com.ironsource.mediationsdk.utils.m.a().a(2))}});
        com.ironsource.mediationsdk.utils.m.a().b(2);
        this.t.c();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public void f(P p) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdOpened()", 1);
        b(2005, p, null);
        this.t.e();
    }

    public synchronized boolean g() {
        if (this.o && !com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().b())) {
            return false;
        }
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE && ((P) abstractSmash).G()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void h() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            com.ironsource.mediationsdk.logger.b bVarC = com.ironsource.mediationsdk.utils.g.c("loadInterstitial exception " + e2.getMessage());
            this.n.b(IronSourceLogger.IronSourceTag.API, bVarC.b(), 3);
            this.y.a(bVarC);
            if (this.z) {
                this.z = false;
                a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVarC.a())}, new Object[]{"reason", e2.getMessage()}});
            }
        }
        if (this.D) {
            this.n.b(IronSourceLogger.IronSourceTag.API, "loadInterstitial cannot be invoked while showing an ad", 3);
            K.a().a(new com.ironsource.mediationsdk.logger.b(1037, "loadInterstitial cannot be invoked while showing an ad"));
            return;
        }
        this.x = null;
        this.t.a((com.ironsource.mediationsdk.model.i) null);
        if (!this.v && !this.y.b()) {
            MediationInitializer.EInitStatus eInitStatusA = MediationInitializer.b().a();
            if (eInitStatusA == MediationInitializer.EInitStatus.NOT_INIT) {
                this.n.b(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                return;
            }
            if (eInitStatusA == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                if (MediationInitializer.b().c()) {
                    this.n.b(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    this.y.a(com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
                } else {
                    this.C = new Date().getTime();
                    a(2001, (Object[][]) null);
                    this.u = true;
                    this.z = true;
                }
                return;
            }
            if (eInitStatusA == MediationInitializer.EInitStatus.INIT_FAILED) {
                this.n.b(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                this.y.a(com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
                return;
            }
            if (this.i.size() == 0) {
                this.n.b(IronSourceLogger.IronSourceTag.API, "the server response does not contain interstitial data", 3);
                this.y.a(com.ironsource.mediationsdk.utils.g.a("the server response does not contain interstitial data", "Interstitial"));
                return;
            }
            this.C = new Date().getTime();
            a(2001, (Object[][]) null);
            this.z = true;
            i();
            if (a(AbstractSmash.MEDIATION_STATE.INITIATED) == 0) {
                if (!this.w) {
                    this.u = true;
                    return;
                }
                com.ironsource.mediationsdk.logger.b bVarB = com.ironsource.mediationsdk.utils.g.b("no ads to load");
                this.n.b(IronSourceLogger.IronSourceTag.API, bVarB.b(), 1);
                this.y.a(bVarB);
                a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVarB.a())}});
                this.z = false;
                return;
            }
            this.u = true;
            this.v = true;
            int i = 0;
            for (AbstractSmash abstractSmash : this.i) {
                if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                    abstractSmash.a(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                    g((P) abstractSmash);
                    i++;
                    if (i >= this.h) {
                        return;
                    }
                }
            }
            return;
        }
        this.n.b(IronSourceLogger.IronSourceTag.API, "Load Interstitial is already in progress", 3);
    }

    public synchronized void a(String str, String str2) {
        this.n.b(IronSourceLogger.IronSourceTag.NATIVE, this.s + ":initInterstitial(appKey: " + str + ", userId: " + str2 + ")", 1);
        long time = new Date().getTime();
        c(82312);
        this.m = str;
        this.l = str2;
        int i = 0;
        for (AbstractSmash abstractSmash : this.i) {
            if (this.g.d(abstractSmash)) {
                a(250, abstractSmash, new Object[][]{new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "false"}});
            }
            if (this.g.c(abstractSmash)) {
                abstractSmash.a(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                i++;
            }
        }
        if (i == this.i.size()) {
            this.w = true;
        }
        l();
        for (int i2 = 0; i2 < this.h && m() != null; i2++) {
        }
        a(82313, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
    }

    private void c(int i) {
        a(i, (Object[][]) null);
    }

    private void e(AbstractSmash abstractSmash) {
        if (!abstractSmash.C()) {
            m();
            j();
        } else {
            abstractSmash.a(AbstractSmash.MEDIATION_STATE.INITIATED);
        }
    }

    private synchronized void g(P p) {
        a(2002, p, (Object[][]) null);
        p.H();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public synchronized void a(P p) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + " :onInterstitialInitSuccess()", 1);
        a(2205, p);
        this.w = true;
        if (this.u && a(AbstractSmash.MEDIATION_STATE.AVAILABLE, AbstractSmash.MEDIATION_STATE.LOAD_PENDING) < this.h) {
            p.a(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
            g(p);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public synchronized void a(P p, long j) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdReady()", 1);
        a(AdError.INTERNAL_ERROR_2003, p, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        long time = new Date().getTime() - this.C;
        p.a(AbstractSmash.MEDIATION_STATE.AVAILABLE);
        this.v = false;
        if (this.z) {
            this.z = false;
            this.t.a();
            a(AdError.INTERNAL_ERROR_2004, new Object[][]{new Object[]{"duration", Long.valueOf(time)}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public synchronized void b(com.ironsource.mediationsdk.logger.b bVar, P p) {
        try {
            this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialInitFailed(" + bVar + ")", 1);
            a(2206, p, new Object[][]{new Object[]{"reason", bVar.b()}});
            if (a(AbstractSmash.MEDIATION_STATE.INIT_FAILED) >= this.i.size()) {
                this.n.b(IronSourceLogger.IronSourceTag.NATIVE, "Smart Loading - initialization failed - no adapters are initiated and no more left to init, error: " + bVar.b(), 2);
                if (this.u) {
                    this.y.a(com.ironsource.mediationsdk.utils.g.b("no ads to show"));
                    a(2110, new Object[][]{new Object[]{"errorCode", 510}});
                    this.z = false;
                }
                this.w = true;
            } else {
                if (m() == null && this.u && a(AbstractSmash.MEDIATION_STATE.INIT_FAILED, AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY, AbstractSmash.MEDIATION_STATE.EXHAUSTED) >= this.i.size()) {
                    this.y.a(new com.ironsource.mediationsdk.logger.b(509, "No ads to show"));
                    a(2110, new Object[][]{new Object[]{"errorCode", 509}});
                    this.z = false;
                }
                j();
            }
        } catch (Exception e2) {
            this.n.a(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onInterstitialInitFailed(error:" + bVar + ", provider:" + p.w() + ")", e2);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public synchronized void a(com.ironsource.mediationsdk.logger.b bVar, P p, long j) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdLoadFailed(" + bVar + ")", 1);
        com.ironsource.mediationsdk.utils.j.c(p.r() + ":onInterstitialAdLoadFailed(" + bVar + ")");
        a(2200, p, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(j)}});
        p.a(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
        int iA = a(AbstractSmash.MEDIATION_STATE.AVAILABLE, AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
        if (iA >= this.h) {
            return;
        }
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                abstractSmash.a(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                g((P) abstractSmash);
                return;
            }
        }
        if (m() != null) {
            return;
        }
        if (this.u && iA + a(AbstractSmash.MEDIATION_STATE.INIT_PENDING) == 0) {
            j();
            this.v = false;
            this.y.a(new com.ironsource.mediationsdk.logger.b(509, "No ads to show"));
            a(2110, new Object[][]{new Object[]{"errorCode", 509}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public void b(P p) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdShowSucceeded()", 1);
        b(2202, p, null);
        boolean z = false;
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                e(abstractSmash);
                z = true;
            }
        }
        if (!z && (p.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || p.v() == AbstractSmash.MEDIATION_STATE.EXHAUSTED || p.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY)) {
            j();
        }
        i();
        this.t.f();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2361p
    public void a(com.ironsource.mediationsdk.logger.b bVar, P p) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, p.r() + ":onInterstitialAdShowFailed(" + bVar + ")", 1);
        b(2203, p, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}});
        this.D = false;
        e((AbstractSmash) p);
        Iterator<AbstractSmash> it = this.i.iterator();
        while (it.hasNext()) {
            if (it.next().v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                this.u = true;
                com.ironsource.mediationsdk.model.i iVar = this.x;
                b(iVar != null ? iVar.c() : "");
                return;
            }
        }
        this.t.b(bVar);
    }

    private void b(int i, Object[][] objArr) {
        a(i, objArr, true);
    }

    private void b(int i, AbstractSmash abstractSmash, Object[][] objArr) {
        a(i, abstractSmash, objArr, true);
    }

    @Override // com.ironsource.mediationsdk.utils.d
    public void b() {
        CopyOnWriteArrayList<AbstractSmash> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            for (AbstractSmash abstractSmash : copyOnWriteArrayList) {
                if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) {
                    a(250, abstractSmash, new Object[][]{new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "false"}});
                    if (abstractSmash.A()) {
                        abstractSmash.a(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                    } else if (abstractSmash.B()) {
                        abstractSmash.a(AbstractSmash.MEDIATION_STATE.EXHAUSTED);
                    } else {
                        abstractSmash.a(AbstractSmash.MEDIATION_STATE.INITIATED);
                    }
                }
            }
        }
    }

    private synchronized AbstractC2311b h(P p) {
        this.n.b(IronSourceLogger.IronSourceTag.NATIVE, this.s + ":startAdapter(" + p.w() + ")", 1);
        AbstractC2311b abstractC2311bA = C2313c.a().a(p.f14598c, p.f14598c.f());
        if (abstractC2311bA == null) {
            this.n.b(IronSourceLogger.IronSourceTag.API, p.r() + " is configured in IronSource's platform, but the adapter is not integrated", 2);
            return null;
        }
        p.a(abstractC2311bA);
        p.a(AbstractSmash.MEDIATION_STATE.INIT_PENDING);
        c((AbstractSmash) p);
        try {
            p.c(this.m, this.l);
            return abstractC2311bA;
        } catch (Throwable th) {
            this.n.a(IronSourceLogger.IronSourceTag.API, this.s + "failed to init adapter: " + p.w() + "v", th);
            p.a(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            return null;
        }
    }

    void a(Context context, boolean z) {
        this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, this.s + " Should Track Network State: " + z, 0);
        this.o = z;
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.b
    public void a(String str) {
        if (this.u) {
            this.y.a(com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial"));
            this.u = false;
            this.v = false;
        }
    }

    public void b(int i) {
        this.y.a(i);
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.b
    public void a() {
        if (this.u) {
            com.ironsource.mediationsdk.logger.b bVarA = com.ironsource.mediationsdk.utils.g.a("init() had failed", "Interstitial");
            this.y.a(bVarA);
            this.u = false;
            this.v = false;
            if (this.z) {
                a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVarA.a())}});
                this.z = false;
            }
        }
    }

    void a(com.ironsource.mediationsdk.model.i iVar) {
        this.x = iVar;
        this.t.a(iVar);
    }

    private void a(int i, Object[][] objArr) {
        a(i, objArr, false);
    }

    private void a(int i, Object[][] objArr, boolean z) {
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        if (z) {
            try {
                if (this.x != null && !TextUtils.isEmpty(this.x.c())) {
                    jSONObjectB.put("placement", this.x.c());
                }
            } catch (Exception e2) {
                this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "InterstitialManager logMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        if (objArr != null) {
            for (Object[] objArr2 : objArr) {
                jSONObjectB.put(objArr2[0].toString(), objArr2[1]);
            }
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, jSONObjectB));
    }

    private void a(int i, AbstractSmash abstractSmash) {
        a(i, abstractSmash, (Object[][]) null);
    }

    private void a(int i, AbstractSmash abstractSmash, Object[][] objArr) {
        a(i, abstractSmash, objArr, false);
    }

    private void a(int i, AbstractSmash abstractSmash, Object[][] objArr, boolean z) {
        JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(abstractSmash);
        if (z) {
            try {
                if (this.x != null && !TextUtils.isEmpty(this.x.c())) {
                    jSONObjectA.put("placement", this.x.c());
                }
            } catch (Exception e2) {
                this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "InterstitialManager logProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        if (objArr != null) {
            for (Object[] objArr2 : objArr) {
                jSONObjectA.put(objArr2[0].toString(), objArr2[1]);
            }
        }
        com.ironsource.mediationsdk.b.h.g().c(new b.f.b.b(i, jSONObjectA));
    }

    private int a(AbstractSmash.MEDIATION_STATE... mediation_stateArr) {
        int i = 0;
        for (AbstractSmash abstractSmash : this.i) {
            int i2 = i;
            for (AbstractSmash.MEDIATION_STATE mediation_state : mediation_stateArr) {
                if (abstractSmash.v() == mediation_state) {
                    i2++;
                }
            }
            i = i2;
        }
        return i;
    }
}
