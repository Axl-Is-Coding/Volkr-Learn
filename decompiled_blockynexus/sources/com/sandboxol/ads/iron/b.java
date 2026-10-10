package com.sandboxol.ads.iron;

import com.ironsource.mediationsdk.sdk.InterfaceC2360o;
import com.sandboxol.common.interfaces.InterstitialAdapter;

/* JADX INFO: compiled from: AdsIronUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements InterfaceC2360o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterstitialAdapter f16032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f16033b;

    b(c cVar, InterstitialAdapter interstitialAdapter) {
        this.f16033b = cVar;
        this.f16032a = interstitialAdapter;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void a() {
        InterstitialAdapter interstitialAdapter = this.f16032a;
        if (interstitialAdapter != null) {
            interstitialAdapter.onAdLoaded();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void b(com.ironsource.mediationsdk.logger.b bVar) {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void c() {
        InterstitialAdapter interstitialAdapter = this.f16032a;
        if (interstitialAdapter != null) {
            interstitialAdapter.onAdClosed();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void d() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void e() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2360o
    public void f() {
    }
}
