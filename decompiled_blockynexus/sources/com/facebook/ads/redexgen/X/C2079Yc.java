package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2079Yc implements D3, CJ {
    public static String[] A05;
    public long A00 = -1;
    public long A01 = -1;
    public long[] A02;
    public long[] A03;
    public final /* synthetic */ C2080Yd A04;

    static {
        A00();
    }

    public static void A00() {
        A05 = new String[]{"yHlOCb8hYCUAGFBSR1KAQUls", "juuz7zvmjSSgkVuftf6ZJcl9wJUxZwvI", "9ebISPaipFvwM", "wI75rrP9DnRc8cDmDq6gSrlsVWTLnppT", "4k7x4VjdHI9zouAPkna3Rg4ZAMvyURep", "hKkxNrfwukp47", "HBJCJbTVml8ZYTmPInpazFF5", "aaJAILk2rqVBl9Nm5Oiw"};
    }

    public C2079Yc(C2080Yd c2080Yd) {
        this.A04 = c2080Yd;
    }

    public final void A01(long j) {
        this.A00 = j;
    }

    public final void A02(IG ig) {
        ig.A0a(1);
        int iA0H = ig.A0H() / 18;
        this.A02 = new long[iA0H];
        this.A03 = new long[iA0H];
        for (int i = 0; i < iA0H; i++) {
            this.A02[i] = ig.A0M();
            if (A05[4].charAt(31) != 'p') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "w9Elnsp9xD6AY";
            strArr[2] = "jAQAlpm0y2ybi";
            this.A03[i] = ig.A0M();
            ig.A0a(2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.D3
    public final CJ A4R() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return this.A04.A01.A01();
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long j) {
        int iA0B = IW.A0B(this.A02, this.A04.A05(j), true, true);
        long seekTimeUs = this.A04.A04(this.A02[iA0B]);
        CK ck = new CK(seekTimeUs, this.A00 + this.A03[iA0B]);
        if (seekTimeUs < j) {
            long[] jArr = this.A02;
            if (iA0B != jArr.length - 1) {
                long jA04 = this.A04.A04(jArr[iA0B + 1]);
                long secondSeekTimeUs = this.A00;
                return new CI(ck, new CK(jA04, secondSeekTimeUs + this.A03[iA0B + 1]));
            }
        }
        return new CI(ck);
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.D3
    public final long ACH(CB cb) throws InterruptedException, IOException {
        long j = this.A01;
        if (j < 0) {
            return -1L;
        }
        long j2 = -(j + 2);
        this.A01 = -1L;
        return j2;
    }

    @Override // com.facebook.ads.redexgen.X.D3
    public final long ADg(long j) {
        long jA05 = this.A04.A05(j);
        this.A01 = this.A02[IW.A0B(this.A02, jA05, true, true)];
        return jA05;
    }
}
