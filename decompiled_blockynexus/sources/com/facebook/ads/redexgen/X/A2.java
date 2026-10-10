package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class A2 {
    public int A00;
    public int A01;
    public AE A02;
    public boolean A03;

    public A2() {
    }

    public final void A03(int i) {
        this.A01 += i;
    }

    public final void A04(int i) {
        if (this.A03 && this.A00 != 4) {
            C1662Hr.A03(i == 4);
        } else {
            this.A03 = true;
            this.A00 = i;
        }
    }

    public final void A05(AE ae) {
        this.A02 = ae;
        this.A01 = 0;
        this.A03 = false;
    }

    public final boolean A06(AE ae) {
        return ae != this.A02 || this.A01 > 0 || this.A03;
    }
}
