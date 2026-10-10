package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YU implements InterfaceC1526Cd {
    public int A00;
    public int A01;
    public final int A02;
    public final int A03;
    public final IG A04;

    public YU(YS ys) {
        this.A04 = ys.A00;
        this.A04.A0Z(12);
        this.A02 = this.A04.A0I() & 255;
        this.A03 = this.A04.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1526Cd
    public final int A6x() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1526Cd
    public final boolean A7q() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1526Cd
    public final int ACM() {
        int i = this.A02;
        if (i == 8) {
            return this.A04.A0F();
        }
        if (i == 16) {
            return this.A04.A0J();
        }
        int i2 = this.A01;
        this.A01 = i2 + 1;
        if (i2 % 2 == 0) {
            this.A00 = this.A04.A0F();
            return (this.A00 & 240) >> 4;
        }
        return this.A00 & 15;
    }
}
