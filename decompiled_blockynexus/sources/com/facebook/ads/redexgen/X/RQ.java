package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RQ implements InterfaceC12701f {
    public final /* synthetic */ RR A00;

    public RQ(RR rr) {
        this.A00 = rr;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12701f
    public final void AAk(AdError adError) {
        this.A00.A03.A92(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12701f
    public final void AAl() {
        this.A00.A03.A93();
    }
}
