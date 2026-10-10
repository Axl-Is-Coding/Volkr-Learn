package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class XN implements ND {
    public final /* synthetic */ N4 A00;

    public XN(N4 n4) {
        this.A00 = n4;
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final void A9H(boolean z) {
        if (this.A00.A07 && this.A00.A00 != null) {
            this.A00.A00.setEnabled(z);
            this.A00.A00.setAlpha(z ? 1.0f : 0.3f);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ND
    public final void A9v(boolean z) {
        if (this.A00.A07 && this.A00.A02 != null) {
            this.A00.A02.setEnabled(z);
            this.A00.A02.setAlpha(z ? 1.0f : 0.3f);
        }
    }
}
