package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2350e;
import java.util.Timer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSmash implements InterfaceC2350e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AbstractC2311b f14597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.ironsource.mediationsdk.model.p f14598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f14599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f14600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f14601f;
    String g;
    String h;
    Timer k;
    Timer l;
    int m;
    int n;
    int o;
    int p;
    final String r = "maxAdsPerSession";
    final String s = "maxAdsPerIteration";
    final String t = "maxAdsPerDay";
    int j = 0;
    int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MEDIATION_STATE f14596a = MEDIATION_STATE.NOT_INITIATED;
    com.ironsource.mediationsdk.logger.c q = com.ironsource.mediationsdk.logger.c.c();

    public enum MEDIATION_STATE {
        NOT_INITIATED(0),
        INIT_FAILED(1),
        INITIATED(2),
        AVAILABLE(3),
        NOT_AVAILABLE(4),
        EXHAUSTED(5),
        CAPPED_PER_SESSION(6),
        INIT_PENDING(7),
        LOAD_PENDING(8),
        CAPPED_PER_DAY(9);

        private int mValue;

        MEDIATION_STATE(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    AbstractSmash(com.ironsource.mediationsdk.model.p pVar) {
        this.f14599d = pVar.i();
        this.f14600e = pVar.g();
        this.f14601f = pVar.m();
        this.f14598c = pVar;
        this.g = pVar.l();
        this.h = pVar.a();
    }

    boolean A() {
        return this.i >= this.n;
    }

    boolean B() {
        return this.j >= this.m;
    }

    boolean C() {
        return (B() || A() || z()) ? false : true;
    }

    void D() {
        this.j++;
        this.i++;
        if (A()) {
            a(MEDIATION_STATE.CAPPED_PER_SESSION);
        } else if (B()) {
            a(MEDIATION_STATE.EXHAUSTED);
        }
    }

    void E() {
        try {
            try {
                if (this.k != null) {
                    this.k.cancel();
                }
            } catch (Exception e2) {
                a("stopInitTimer", e2.getLocalizedMessage());
            }
        } finally {
            this.k = null;
        }
    }

    void F() {
        try {
            try {
                if (this.l != null) {
                    this.l.cancel();
                }
            } catch (Exception e2) {
                a("stopLoadTimer", e2.getLocalizedMessage());
            }
        } finally {
            this.l = null;
        }
    }

    void a(AbstractC2311b abstractC2311b) {
        this.f14597b = abstractC2311b;
    }

    void b(String str, String str2) {
        AbstractC2311b abstractC2311b = this.f14597b;
        if (abstractC2311b != null) {
            abstractC2311b.setPluginData(str, str2);
        }
    }

    abstract void j();

    public String o() {
        return !TextUtils.isEmpty(this.h) ? this.h : w();
    }

    protected abstract String p();

    public AbstractC2311b q() {
        return this.f14597b;
    }

    String r() {
        return this.f14600e;
    }

    public int s() {
        return this.o;
    }

    int t() {
        return this.m;
    }

    int u() {
        return this.n;
    }

    MEDIATION_STATE v() {
        return this.f14596a;
    }

    public String w() {
        return this.f14601f ? this.f14599d : this.f14600e;
    }

    public int x() {
        return this.p;
    }

    public String y() {
        return this.g;
    }

    boolean z() {
        return this.f14596a == MEDIATION_STATE.CAPPED_PER_DAY;
    }

    synchronized void a(MEDIATION_STATE mediation_state) {
        if (this.f14596a == mediation_state) {
            return;
        }
        this.f14596a = mediation_state;
        this.q.b(IronSourceLogger.IronSourceTag.INTERNAL, "Smart Loading - " + r() + " state changed to " + mediation_state.toString(), 0);
        if (this.f14597b != null && (mediation_state == MEDIATION_STATE.CAPPED_PER_SESSION || mediation_state == MEDIATION_STATE.CAPPED_PER_DAY)) {
            this.f14597b.setMediationState(mediation_state, p());
        }
    }

    public void a(String str) {
        if (this.f14597b != null) {
            this.q.b(IronSourceLogger.IronSourceTag.ADAPTER_API, w() + ":setMediationSegment(segment:" + str + ")", 1);
            this.f14597b.setMediationSegment(str);
        }
    }

    void a(int i) {
        this.p = i;
    }

    void a(String str, String str2) {
        this.q.b(IronSourceLogger.IronSourceTag.INTERNAL, str + " exception: " + r() + " | " + str2, 3);
    }
}
