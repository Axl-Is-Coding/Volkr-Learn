package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2351f;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DemandOnlyIsSmash extends DemandOnlySmash implements com.ironsource.mediationsdk.sdk.r {
    private InterfaceC2351f l;
    private long m;

    public DemandOnlyIsSmash(String str, String str2, com.ironsource.mediationsdk.model.p pVar, InterfaceC2351f interfaceC2351f, int i, AbstractC2311b abstractC2311b) {
        super(new com.ironsource.mediationsdk.model.a(pVar, pVar.f()), abstractC2311b);
        this.l = interfaceC2351f;
        this.f14652f = i;
        this.f14647a.initInterstitial(str, str2, this.f14649c, this);
    }

    private void logAdapterCallback(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyInterstitialSmash " + this.f14648b.e() + " : " + str, 0);
    }

    private void u() {
        b("start timer");
        a(new C2341q(this));
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void c() {
        a(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onInterstitialAdClosed");
        this.l.b(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void d() {
        logAdapterCallback("onInterstitialAdClicked");
        this.l.c(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void e() {
        logAdapterCallback("onInterstitialAdOpened");
        this.l.a(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void f() {
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void g(com.ironsource.mediationsdk.logger.b bVar) {
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void h() {
        logAdapterCallback("onInterstitialAdVisible");
        this.l.d(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void b(com.ironsource.mediationsdk.logger.b bVar) {
        a(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onInterstitialAdShowFailed error=" + bVar.b());
        this.l.a(bVar, this);
    }

    public void a(String str, String str2, List<String> list) {
        b("loadInterstitial state=" + q());
        DemandOnlySmash.SMASH_STATE smash_stateA = a(new DemandOnlySmash.SMASH_STATE[]{DemandOnlySmash.SMASH_STATE.NOT_LOADED, DemandOnlySmash.SMASH_STATE.LOADED}, DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS);
        if (smash_stateA != DemandOnlySmash.SMASH_STATE.NOT_LOADED && smash_stateA != DemandOnlySmash.SMASH_STATE.LOADED) {
            if (smash_stateA == DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS) {
                this.l.a(new com.ironsource.mediationsdk.logger.b(1050, "load already in progress"), this, 0L);
                return;
            } else {
                this.l.a(new com.ironsource.mediationsdk.logger.b(1050, "cannot load because show is in progress"), this, 0L);
                return;
            }
        }
        this.m = new Date().getTime();
        u();
        if (s()) {
            this.g = str2;
            this.h = list;
            this.f14647a.loadInterstitialForBidding(this.f14649c, this, str);
            return;
        }
        this.f14647a.loadInterstitial(this.f14649c, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyInterstitialSmash " + this.f14648b.e() + " : " + str, 0);
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void a() {
        logAdapterCallback("onInterstitialAdReady state=" + q());
        t();
        if (a(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.LOADED)) {
            this.l.a(this, new Date().getTime() - this.m);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.r
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        logAdapterCallback("onInterstitialAdLoadFailed error=" + bVar.b() + " state=" + q());
        t();
        if (a(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.l.a(bVar, this, new Date().getTime() - this.m);
        }
    }
}
