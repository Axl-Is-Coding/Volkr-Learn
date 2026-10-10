package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2186b0 implements I7 {
    public static String[] A05;
    public long A00;
    public long A01;
    public AF A02 = AF.A04;
    public boolean A03;
    public final InterfaceC1665Hu A04;

    static {
        A00();
    }

    public static void A00() {
        A05 = new String[]{"JbcDsPAiqgb9rsViVRKehTXv1iFS9Alt", "AfEyeuF2jCfkWNmIQlP22Iq9vQ5XDBZo", "cIPTiq2qkEqnYzKxb3sH3HOJO6VigB4N", "bIuwftDwBGArWYVN2grLSP1kPnHfbgfq", "1GGMxn0jatOJtlepcpEnLiyqpa0L6Zpp", "dBndgbsmlMbgteIClih73P1Nf1skDdlq", "kMZcBPwOEd1j6nxu2sFbdi5kLjNzhQnH", "M7tzCbQcNsxxyZ9EacAqZIMXmH340eiG"};
    }

    public C2186b0(InterfaceC1665Hu interfaceC1665Hu) {
        this.A04 = interfaceC1665Hu;
    }

    public final void A01() {
        if (!this.A03) {
            this.A00 = this.A04.A4z();
            this.A03 = true;
        }
    }

    public final void A02() {
        if (this.A03) {
            long jA6v = A6v();
            if (A05[0].charAt(9) == 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "yV0nDN2yEP24GlsqsYFBRUnmoDIsFkRQ";
            strArr[0] = "yV0nDN2yEP24GlsqsYFBRUnmoDIsFkRQ";
            A03(jA6v);
            this.A03 = false;
        }
    }

    public final void A03(long j) {
        this.A01 = j;
        if (this.A03) {
            this.A00 = this.A04.A4z();
        }
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final AF A6s() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final long A6v() {
        long elapsedSinceBaseMs = this.A01;
        if (this.A03) {
            long jA4z = this.A04.A4z();
            if (A05[0].charAt(9) == 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "ixlqsHFDPmeKY4bwdkSegalU4BLtdIOn";
            strArr[1] = "ixlqsHFDPmeKY4bwdkSegalU4BLtdIOn";
            long j = jA4z - this.A00;
            if (this.A02.A01 == 1.0f) {
                long jA00 = C14729o.A00(j);
                if (A05[3].charAt(4) != 'j') {
                    String[] strArr2 = A05;
                    strArr2[0] = "AIwpqv7aDt0R5Z0o8sSBDj22LkfdUh0v";
                    strArr2[0] = "AIwpqv7aDt0R5Z0o8sSBDj22LkfdUh0v";
                    return elapsedSinceBaseMs + jA00;
                }
                String[] strArr3 = A05;
                strArr3[0] = "vgrMGSSY4L8ja71DPmzZRGyrcWnnIJj3";
                strArr3[0] = "vgrMGSSY4L8ja71DPmzZRGyrcWnnIJj3";
                return elapsedSinceBaseMs + jA00;
            }
            return elapsedSinceBaseMs + this.A02.A00(j);
        }
        return elapsedSinceBaseMs;
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final AF ADM(AF af) {
        if (this.A03) {
            A03(A6v());
        }
        this.A02 = af;
        return af;
    }
}
