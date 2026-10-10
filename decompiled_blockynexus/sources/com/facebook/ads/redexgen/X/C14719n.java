package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14719n extends ST {
    public static String[] A08;
    public float A00;
    public int A01;
    public int A02;
    public C14739p A03;
    public int[] A04;
    public final C2026Wb A05;
    public final OG A06;
    public final OH A07;

    static {
        A04();
    }

    public static void A04() {
        A08 = new String[]{"bHvO3zM", "7z8VpEP", "iw2Y0c", "LME8njBPiXs011hhslbtp", "9K0lNzbR5X2b0vS5", "Pt0EnZUFnGQLsNks8pQcEgn0FivkNzUh", "t6anbflpJj2CGicCnIMdWTRCydsD", "D9TL9YTSSd0lWzGeUvgWfvwaUF0YdAOx"};
    }

    public C14719n(C2026Wb c2026Wb, OH oh, OG og) {
        super(c2026Wb);
        this.A02 = 0;
        this.A00 = 50.0f;
        this.A05 = c2026Wb;
        this.A07 = oh;
        this.A06 = og;
        this.A01 = -1;
        this.A03 = new C14739p(this, this.A05);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0 == 0) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
    @Override // com.facebook.ads.redexgen.X.C4E
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1K(com.facebook.ads.redexgen.X.C4M r17, com.facebook.ads.redexgen.X.C4T r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C14719n.A1K(com.facebook.ads.redexgen.X.4M, com.facebook.ads.redexgen.X.4T, int, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.ST, com.facebook.ads.redexgen.X.C4E
    public final void A1u(int i) {
        super.A2G(i, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ST, com.facebook.ads.redexgen.X.C4E
    public final void A22(EI ei, C4T c4t, int i) {
        this.A03.A0B(i);
        A1M(this.A03);
    }

    public final void A2L(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0d;
        }
        this.A00 = (float) (50.0d / d2);
        this.A03 = new C14739p(this, this.A05);
    }

    public final void A2M(int i) {
        this.A01 = i;
    }

    public final void A2N(int i) {
        this.A02 = i;
    }
}
