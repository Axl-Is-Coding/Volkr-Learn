package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class RV implements InterfaceC14166z {
    public final boolean A00;

    public abstract void A00();

    public abstract void A01(boolean z);

    public RV(boolean z) {
        this.A00 = z;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9P() {
        if (this.A00) {
            A00();
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9W() {
        A01(true);
    }
}
