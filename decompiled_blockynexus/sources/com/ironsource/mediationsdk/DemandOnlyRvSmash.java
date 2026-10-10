package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2352g;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DemandOnlyRvSmash extends DemandOnlySmash implements com.ironsource.mediationsdk.sdk.X {
    private InterfaceC2352g l;
    private long m;

    DemandOnlyRvSmash(String str, String str2, com.ironsource.mediationsdk.model.p pVar, InterfaceC2352g interfaceC2352g, int i, AbstractC2311b abstractC2311b) {
        super(new com.ironsource.mediationsdk.model.a(pVar, pVar.f()), abstractC2311b);
        this.f14648b = new com.ironsource.mediationsdk.model.a(pVar, pVar.k());
        this.f14649c = this.f14648b.b();
        this.f14647a = abstractC2311b;
        this.l = interfaceC2352g;
        this.f14652f = i;
        this.f14647a.initRewardedVideoForDemandOnly(str, str2, this.f14649c, this);
    }

    private void logAdapterCallback(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyRewardedVideoSmash " + this.f14648b.e() + " : " + str, 0);
    }

    private void u() {
        b("start timer");
        a(new r(this));
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void a(boolean z) {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void b() {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void c(com.ironsource.mediationsdk.logger.b bVar) {
        a(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onRewardedVideoAdClosed error=" + bVar);
        this.l.a(bVar, this);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        logAdapterCallback("onRewardedVideoLoadFailed error=" + bVar.b() + " state=" + q());
        t();
        if (a(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.l.a(bVar, this, new Date().getTime() - this.m);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void f(com.ironsource.mediationsdk.logger.b bVar) {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void g() {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void i() {
        logAdapterCallback("onRewardedVideoAdVisible");
        this.l.d(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void k() {
        logAdapterCallback("onRewardedVideoAdClicked");
        this.l.b(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void l() {
        logAdapterCallback("onRewardedVideoAdRewarded");
        this.l.c(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void m() {
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void n() {
        logAdapterCallback("onRewardedVideoLoadSuccess state=" + q());
        t();
        if (a(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.LOADED)) {
            this.l.a(this, new Date().getTime() - this.m);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void onRewardedVideoAdClosed() {
        a(DemandOnlySmash.SMASH_STATE.NOT_LOADED);
        logAdapterCallback("onRewardedVideoAdClosed");
        this.l.a(this);
    }

    @Override // com.ironsource.mediationsdk.sdk.X
    public void onRewardedVideoAdOpened() {
        logAdapterCallback("onRewardedVideoAdOpened");
        this.l.e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRewardedVideoSmash " + this.f14648b.e() + " : " + str, 0);
    }

    public void a(String str, String str2, List<String> list) {
        b("loadRewardedVideo state=" + q());
        DemandOnlySmash.SMASH_STATE smash_stateA = a(new DemandOnlySmash.SMASH_STATE[]{DemandOnlySmash.SMASH_STATE.NOT_LOADED, DemandOnlySmash.SMASH_STATE.LOADED}, DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS);
        if (smash_stateA != DemandOnlySmash.SMASH_STATE.NOT_LOADED && smash_stateA != DemandOnlySmash.SMASH_STATE.LOADED) {
            if (smash_stateA == DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS) {
                this.l.a(new com.ironsource.mediationsdk.logger.b(1053, "load already in progress"), this, 0L);
                return;
            } else {
                this.l.a(new com.ironsource.mediationsdk.logger.b(1056, "cannot load because show is in progress"), this, 0L);
                return;
            }
        }
        this.m = new Date().getTime();
        u();
        if (s()) {
            this.g = str2;
            this.h = list;
            this.f14647a.loadRewardedVideoForDemandOnlyForBidding(this.f14649c, this, str);
            return;
        }
        this.f14647a.loadRewardedVideoForDemandOnly(this.f14649c, this);
    }
}
