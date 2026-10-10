package com.ironsource.mediationsdk;

import android.util.Log;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardedVideoSmash.java */
/* JADX INFO: loaded from: classes2.dex */
public class Pa extends AbstractSmash implements com.ironsource.mediationsdk.sdk.W, com.ironsource.mediationsdk.sdk.X {
    public int A;
    private final String B;
    private JSONObject u;
    private com.ironsource.mediationsdk.sdk.V v;
    private AtomicBoolean w;
    private long x;
    private String y;
    private int z;

    Pa(com.ironsource.mediationsdk.model.p pVar, int i) {
        super(pVar);
        this.B = "requestUrl";
        this.u = pVar.k();
        this.m = this.u.optInt("maxAdsPerIteration", 99);
        this.n = this.u.optInt("maxAdsPerSession", 99);
        this.o = this.u.optInt("maxAdsPerDay", 99);
        this.y = this.u.optString("requestUrl");
        this.w = new AtomicBoolean(false);
        this.z = i;
    }

    public void G() {
        if (this.f14597b != null) {
            if (v() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY && v() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION) {
                this.w.set(true);
                this.x = new Date().getTime();
            }
            this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":fetchRewardedVideoForAutomaticLoad()", 1);
            this.f14597b.fetchRewardedVideoForAutomaticLoad(this.u, this);
        }
    }

    String H() {
        return this.y;
    }

    public boolean I() {
        if (this.f14597b == null) {
            return false;
        }
        this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":isRewardedVideoAvailable()", 1);
        return this.f14597b.isRewardedVideoAvailable(this.u);
    }

    public void J() {
        if (this.f14597b != null) {
            this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":showRewardedVideo()", 1);
            D();
            this.f14597b.showRewardedVideo(this.u, this);
        }
    }

    void K() {
        try {
            E();
            this.k = new Timer();
            this.k.schedule(new Oa(this), this.z * 1000);
        } catch (Exception e2) {
            a("startInitTimer", e2.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        a(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"duration", Long.valueOf(new Date().getTime() - this.x)}});
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void f(com.ironsource.mediationsdk.logger.b bVar) {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void g() {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void i() {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.f(this);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractSmash
    void j() {
        this.j = 0;
        a(I() ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void k() {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.a(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void l() {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void m() {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void n() {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void onRewardedVideoAdClosed() {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.g(this);
        }
        G();
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void onRewardedVideoAdOpened() {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractSmash
    protected String p() {
        return "rewardedvideo";
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void b() {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.e(this);
        }
    }

    public void c(String str, String str2) {
        K();
        if (this.f14597b != null) {
            this.w.set(true);
            this.x = new Date().getTime();
            this.f14597b.addRewardedVideoListener(this);
            this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, r() + ":initRewardedVideo()", 1);
            this.f14597b.initRewardedVideo(str, str2, this.u, this);
        }
    }

    public void a(com.ironsource.mediationsdk.sdk.V v) {
        this.v = v;
    }

    private void b(int i) {
        a(i, (Object[][]) null);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public synchronized void a(boolean z) {
        E();
        if (this.w.compareAndSet(true, false)) {
            a(z ? 1002 : 1200, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.x)}});
        } else {
            b(z ? 1207 : 1208);
        }
        if (C() && ((z && this.f14596a != AbstractSmash.MEDIATION_STATE.AVAILABLE) || (!z && this.f14596a != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE))) {
            a(z ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
            if (this.v != null) {
                this.v.a(z, this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void c(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.sdk.V v = this.v;
        if (v != null) {
            v.a(bVar, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object[][] objArr) {
        JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(this);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObjectA.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                this.q.b(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoSmash logProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, jSONObjectA));
    }
}
