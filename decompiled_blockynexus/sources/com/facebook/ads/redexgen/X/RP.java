package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RP implements InterfaceC14166z {
    public final /* synthetic */ RR A00;

    public RP(RR rr) {
        this.A00 = rr;
    }

    private void A00(boolean z) {
        if (z) {
            this.A00.A03.A93();
        } else {
            this.A00.A03.A92(AdError.CACHE_ERROR);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9P() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9W() {
        A00(true);
    }
}
