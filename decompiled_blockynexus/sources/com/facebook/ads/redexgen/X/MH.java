package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MH extends KT {
    public final /* synthetic */ LU A00;

    public MH(LU lu) {
        this.A00 = lu;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (!this.A00.A03) {
            AnonymousClass99 anonymousClass99 = this.A00.A0A;
            final int currentPositionInMillis = this.A00.getCurrentPositionInMillis();
            anonymousClass99.A03(new AbstractC1715Jw(currentPositionInMillis) { // from class: com.facebook.ads.redexgen.X.7i
            });
            this.A00.A06.postDelayed(this, this.A00.A00);
        }
    }
}
