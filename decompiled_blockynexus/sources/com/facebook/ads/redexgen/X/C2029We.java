package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.We, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2029We extends KT {
    public final /* synthetic */ NZ A00;

    public C2029We(NZ nz) {
        this.A00 = nz;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        this.A00.clearAnimation();
        LX.A0H(1000, this.A00.A06, this.A00);
        this.A00.postDelayed(this, r2.A07);
    }
}
