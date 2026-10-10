package com.facebook.ads.redexgen.X;

import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AR extends AbstractC2068Xr implements G6 {
    public static String[] A02;
    public long A00;
    public G6 A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"", "mui60dwzFhaHNm2Uk6c71g13RzPqoL9o", "B0rzWlns", "IaExOe45iIyqIoKsg3ghGHNojNO5y7aX", "6x0KWKc5lmTcd6rSDKCIntspSHI5N7vM", "fpXFGNqhd64a2XzCiJ5Y2uwqVb67lOfi", "JEeTPk6X6cicZdwnLWr3cLjXKJNjxOw", "om0z9vsHwazWN6uDNjDMJ"};
    }

    public abstract void A08();

    @Override // com.facebook.ads.redexgen.X.BP
    public final void A07() {
        super.A07();
        this.A01 = null;
    }

    public final void A09(long j, G6 g6, long j2) {
        super.A01 = j;
        this.A01 = g6;
        if (j2 == Long.MAX_VALUE) {
            j2 = super.A01;
        }
        this.A00 = j2;
        if (A02[0].length() != 0) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[1] = "xukRyz5yFwN1nVXA8Rs2f92E1X9llmA1";
        strArr[1] = "xukRyz5yFwN1nVXA8Rs2f92E1X9llmA1";
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final List<G5> A5w(long j) {
        return this.A01.A5w(j - this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final long A6L(int i) {
        return this.A01.A6L(i) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6M() {
        return this.A01.A6M();
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6f(long j) {
        return this.A01.A6f(j - this.A00);
    }
}
