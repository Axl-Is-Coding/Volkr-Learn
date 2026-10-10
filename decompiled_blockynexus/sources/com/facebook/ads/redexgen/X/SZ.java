package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SZ implements C3Y {
    public final /* synthetic */ EI A00;

    public SZ(EI ei) {
        this.A00 = ei;
    }

    private final void A00(C3Z c3z) {
        int i = c3z.A00;
        if (i == 1) {
            this.A00.A06.A1R(this.A00, c3z.A02, c3z.A01);
            return;
        }
        if (i == 2) {
            this.A00.A06.A1S(this.A00, c3z.A02, c3z.A01);
        } else if (i == 4) {
            this.A00.A06.A1U(this.A00, c3z.A02, c3z.A01, c3z.A03);
        } else {
            if (i != 8) {
                return;
            }
            this.A00.A06.A1T(this.A00, c3z.A02, c3z.A01, 1);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final C4W A5F(int i) {
        C4W c4wA1H = this.A00.A1H(i, true);
        if (c4wA1H == null || this.A00.A01.A0L(c4wA1H.A0H)) {
            return null;
        }
        return c4wA1H;
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final void A8j(int i, int i2, Object obj) {
        this.A00.A1g(i, i2, obj);
        this.A00.A0H = true;
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final void A8x(int i, int i2) {
        this.A00.A1d(i, i2);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final void A8y(int i, int i2) {
        this.A00.A1e(i, i2);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final void A8z(int i, int i2) {
        this.A00.A1h(i, i2, true);
        EI ei = this.A00;
        ei.A0G = true;
        ei.A0s.A00 += i2;
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final void A90(int i, int i2) {
        this.A00.A1h(i, i2, false);
        this.A00.A0G = true;
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final void A9c(C3Z c3z) {
        A00(c3z);
    }

    @Override // com.facebook.ads.redexgen.X.C3Y
    public final void A9e(C3Z c3z) {
        A00(c3z);
    }
}
