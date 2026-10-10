package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2361p;
import com.ironsource.mediationsdk.sdk.InterfaceC2362q;
import java.util.Date;
import java.util.Timer;
import org.json.JSONObject;

/* JADX INFO: compiled from: InterstitialSmash.java */
/* JADX INFO: loaded from: classes2.dex */
public class P extends AbstractSmash implements InterfaceC2362q, com.ironsource.mediationsdk.sdk.r {
    private JSONObject u;
    private InterfaceC2361p v;
    private long w;
    private int x;

    P(com.ironsource.mediationsdk.model.p pVar, int i) {
        super(pVar);
        this.u = pVar.f();
        this.m = this.u.optInt("maxAdsPerIteration", 99);
        this.n = this.u.optInt("maxAdsPerSession", 99);
        this.o = this.u.optInt("maxAdsPerDay", 99);
        this.f14601f = pVar.m();
        this.g = pVar.l();
        this.x = i;
    }

    public boolean G() {
        if (this.f14597b == null) {
            return false;
        }
        this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":isInterstitialReady()", 1);
        return this.f14597b.isInterstitialReady(this.u);
    }

    public void H() {
        K();
        if (this.f14597b != null) {
            this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":loadInterstitial()", 1);
            this.w = new Date().getTime();
            this.f14597b.loadInterstitial(this.u, this);
        }
    }

    public void I() {
        if (this.f14597b != null) {
            this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":showInterstitial()", 1);
            D();
            this.f14597b.showInterstitial(this.u, this);
        }
    }

    void J() {
        try {
            E();
            this.k = new Timer();
            this.k.schedule(new N(this), this.x * 1000);
        } catch (Exception e2) {
            a("startInitTimer", e2.getLocalizedMessage());
        }
    }

    void K() {
        try {
            F();
            this.l = new Timer();
            this.l.schedule(new O(this), this.x * 1000);
        } catch (Exception e2) {
            a("startLoadTimer", e2.getLocalizedMessage());
        }
    }

    public void c(String str, String str2) {
        J();
        AbstractC2311b abstractC2311b = this.f14597b;
        if (abstractC2311b != null) {
            abstractC2311b.addInterstitialListener(this);
            this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":initInterstitial()", 1);
            this.f14597b.initInterstitial(str, str2, this.u, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void d() {
        InterfaceC2361p interfaceC2361p = this.v;
        if (interfaceC2361p != null) {
            interfaceC2361p.c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void e() {
        InterfaceC2361p interfaceC2361p = this.v;
        if (interfaceC2361p != null) {
            interfaceC2361p.f(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void f() {
        InterfaceC2361p interfaceC2361p = this.v;
        if (interfaceC2361p != null) {
            interfaceC2361p.b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void g(com.ironsource.mediationsdk.logger.b bVar) {
        E();
        if (this.f14596a == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            a(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            InterfaceC2361p interfaceC2361p = this.v;
            if (interfaceC2361p != null) {
                interfaceC2361p.b(bVar, this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void h() {
        InterfaceC2361p interfaceC2361p = this.v;
        if (interfaceC2361p != null) {
            interfaceC2361p.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractSmash
    void j() {
        this.j = 0;
        a(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void onInterstitialInitSuccess() {
        E();
        if (this.f14596a == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            a(AbstractSmash.MEDIATION_STATE.INITIATED);
            InterfaceC2361p interfaceC2361p = this.v;
            if (interfaceC2361p != null) {
                interfaceC2361p.a(this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractSmash
    protected String p() {
        return "interstitial";
    }

    public void a(InterfaceC2361p interfaceC2361p) {
        this.v = interfaceC2361p;
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void b(com.ironsource.mediationsdk.logger.b bVar) {
        InterfaceC2361p interfaceC2361p = this.v;
        if (interfaceC2361p != null) {
            interfaceC2361p.a(bVar, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void a() {
        F();
        if (this.f14596a != AbstractSmash.MEDIATION_STATE.LOAD_PENDING || this.v == null) {
            return;
        }
        this.v.a(this, new Date().getTime() - this.w);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void c() {
        InterfaceC2361p interfaceC2361p = this.v;
        if (interfaceC2361p != null) {
            interfaceC2361p.e(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        F();
        if (this.f14596a != AbstractSmash.MEDIATION_STATE.LOAD_PENDING || this.v == null) {
            return;
        }
        this.v.a(bVar, this, new Date().getTime() - this.w);
    }
}
