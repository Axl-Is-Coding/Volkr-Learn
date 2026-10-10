package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YT implements InterfaceC1526Cd {
    public final int A00;
    public final int A01;
    public final IG A02;

    public YT(YS ys) {
        this.A02 = ys.A00;
        this.A02.A0Z(12);
        this.A00 = this.A02.A0I();
        this.A01 = this.A02.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1526Cd
    public final int A6x() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1526Cd
    public final boolean A7q() {
        return this.A00 != 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1526Cd
    public final int ACM() {
        int i = this.A00;
        return i == 0 ? this.A02.A0I() : i;
    }
}
