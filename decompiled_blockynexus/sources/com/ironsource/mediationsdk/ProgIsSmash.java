package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: loaded from: classes2.dex */
public class ProgIsSmash extends AbstractC2373ua implements com.ironsource.mediationsdk.sdk.r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SMASH_STATE f14713f;
    private InterfaceC2336na g;
    private Timer h;
    private int i;
    private String j;
    private String k;
    private long l;
    private final Object m;

    protected enum SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        INIT_SUCCESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED
    }

    public ProgIsSmash(String str, String str2, com.ironsource.mediationsdk.model.p pVar, InterfaceC2336na interfaceC2336na, int i, AbstractC2311b abstractC2311b) {
        super(new com.ironsource.mediationsdk.model.a(pVar, pVar.f()), abstractC2311b);
        this.m = new Object();
        this.f14713f = SMASH_STATE.NO_INIT;
        this.j = str;
        this.k = str2;
        this.g = interfaceC2336na;
        this.h = null;
        this.i = i;
        this.f15008a.addInterstitialListener(this);
    }

    private void F() {
        try {
            String strH = U.e().h();
            if (!TextUtils.isEmpty(strH)) {
                this.f15008a.setMediationSegment(strH);
            }
            String strC = com.ironsource.mediationsdk.a.a.a().c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            this.f15008a.setPluginData(strC, com.ironsource.mediationsdk.a.a.a().b());
        } catch (Exception e2) {
            c("setCustomParams() " + e2.getMessage());
        }
    }

    private void G() {
        synchronized (this.m) {
            c("start timer");
            H();
            this.h = new Timer();
            this.h.schedule(new C2338oa(this), this.i * 1000);
        }
    }

    private void H() {
        synchronized (this.m) {
            if (this.h != null) {
                this.h.cancel();
                this.h = null;
            }
        }
    }

    private void logAdapterCallback(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "ProgIsSmash " + r() + " : " + str, 0);
    }

    public void A() {
        c("initForBidding()");
        a(SMASH_STATE.INIT_IN_PROGRESS);
        F();
        try {
            this.f15008a.initInterstitialForBidding(this.j, this.k, this.f15011d, this);
        } catch (Throwable th) {
            d(r() + "loadInterstitial exception : " + th.getLocalizedMessage());
            th.printStackTrace();
            g(new com.ironsource.mediationsdk.logger.b(1041, th.getLocalizedMessage()));
        }
    }

    public boolean B() {
        SMASH_STATE smash_state = this.f14713f;
        return smash_state == SMASH_STATE.INIT_IN_PROGRESS || smash_state == SMASH_STATE.LOAD_IN_PROGRESS;
    }

    public boolean C() {
        try {
            return this.f15008a.isInterstitialReady(this.f15011d);
        } catch (Throwable th) {
            d("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            return false;
        }
    }

    public void D() {
        this.f15008a.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, "interstitial");
    }

    public void E() {
        try {
            this.f15008a.showInterstitial(this.f15011d, this);
        } catch (Throwable th) {
            d(r() + "showInterstitial exception : " + th.getLocalizedMessage());
            th.printStackTrace();
            this.g.a(new com.ironsource.mediationsdk.logger.b(1039, th.getLocalizedMessage()), this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void d() {
        logAdapterCallback("onInterstitialAdClicked");
        this.g.e(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void e() {
        logAdapterCallback("onInterstitialAdOpened");
        this.g.c(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void f() {
        logAdapterCallback("onInterstitialAdShowSucceeded");
        this.g.f(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void g(com.ironsource.mediationsdk.logger.b bVar) {
        logAdapterCallback("onInterstitialInitFailed error" + bVar.b() + " state=" + this.f14713f.name());
        if (this.f14713f != SMASH_STATE.INIT_IN_PROGRESS) {
            return;
        }
        H();
        a(SMASH_STATE.NO_INIT);
        this.g.b(bVar, this);
        if (y()) {
            return;
        }
        this.g.a(bVar, this, new Date().getTime() - this.l);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void h() {
        logAdapterCallback("onInterstitialAdVisible");
        this.g.b(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void onInterstitialInitSuccess() {
        logAdapterCallback("onInterstitialInitSuccess state=" + this.f14713f.name());
        if (this.f14713f != SMASH_STATE.INIT_IN_PROGRESS) {
            return;
        }
        H();
        if (y()) {
            a(SMASH_STATE.INIT_SUCCESS);
        } else {
            a(SMASH_STATE.LOAD_IN_PROGRESS);
            G();
            try {
                this.f15008a.loadInterstitial(this.f15011d, this);
            } catch (Throwable th) {
                d("onInterstitialInitSuccess exception: " + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
        this.g.a(this);
    }

    public Map<String, Object> z() {
        try {
            if (y()) {
                return this.f15008a.getInterstitialBiddingData(this.f15011d);
            }
            return null;
        } catch (Throwable th) {
            d("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        try {
            this.l = new Date().getTime();
            c("loadInterstitial");
            b(false);
            if (y()) {
                G();
                a(SMASH_STATE.LOAD_IN_PROGRESS);
                this.f15008a.loadInterstitialForBidding(this.f15011d, this, str);
            } else if (this.f14713f != SMASH_STATE.NO_INIT) {
                G();
                a(SMASH_STATE.LOAD_IN_PROGRESS);
                this.f15008a.loadInterstitial(this.f15011d, this);
            } else {
                G();
                a(SMASH_STATE.INIT_IN_PROGRESS);
                F();
                this.f15008a.initInterstitial(this.j, this.k, this.f15011d, this);
            }
        } catch (Throwable th) {
            d("loadInterstitial exception: " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void c() {
        logAdapterCallback("onInterstitialAdClosed");
        this.g.d(this);
    }

    private void d(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsSmash " + r() + " : " + str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SMASH_STATE smash_state) {
        c("current state=" + this.f14713f + ", new state=" + smash_state);
        this.f14713f = smash_state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsSmash " + r() + " : " + str, 0);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void a() {
        logAdapterCallback("onInterstitialAdReady state=" + this.f14713f.name());
        H();
        if (this.f14713f != SMASH_STATE.LOAD_IN_PROGRESS) {
            return;
        }
        a(SMASH_STATE.LOADED);
        this.g.a(this, new Date().getTime() - this.l);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        logAdapterCallback("onInterstitialAdLoadFailed error=" + bVar.b() + " state=" + this.f14713f.name());
        H();
        if (this.f14713f != SMASH_STATE.LOAD_IN_PROGRESS) {
            return;
        }
        a(SMASH_STATE.LOAD_FAILED);
        this.g.a(bVar, this, new Date().getTime() - this.l);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void b(com.ironsource.mediationsdk.logger.b bVar) {
        logAdapterCallback("onInterstitialAdShowFailed error=" + bVar.b());
        this.g.a(bVar, this);
    }
}
