package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RE implements InterfaceC12701f {
    public final /* synthetic */ C1584En A00;
    public final /* synthetic */ RJ A01;

    public RE(C1584En c1584En, RJ rj) {
        this.A00 = c1584En;
        this.A01 = rj;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12701f
    public final void AAk(AdError adError) {
        this.A00.A01.ABB(this.A01, adError);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12701f
    public final void AAl() {
        this.A00.A0B.set(true);
        this.A00.A01.AB8(this.A01);
    }
}
