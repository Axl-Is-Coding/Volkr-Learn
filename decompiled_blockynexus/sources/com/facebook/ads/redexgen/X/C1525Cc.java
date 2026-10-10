package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1525Cc {
    public static byte[] A09;
    public static String[] A0A;
    public int A00;
    public int A01;
    public long A02;
    public int A03;
    public int A04;
    public final int A05;
    public final IG A06;
    public final IG A07;
    public final boolean A08;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{27, 20, ci.m, ci.l, 9, 34, 30, 21, 8, 19, 22, 93, ci.n, 8, ci.l, 9, 93, 31, 24, 93, 76};
    }

    public static void A02() {
        A0A = new String[]{"fT4", "9XJ", "BdT8ugCih1Mpz00LrHVoF8KqNvgOr8AQ", "ItU4Mc5lT2NsoQYD", "XQJ1SNvFfokPp3KD", "IGCc23FH28N7ANBVj9k1dGnz4ha0U", "1lzK38hIt0", "A8GyDlY1o0KAgmQELzlat0ZxMGcgz"};
    }

    public C1525Cc(IG ig, IG ig2, boolean z) {
        this.A07 = ig;
        this.A06 = ig2;
        this.A08 = z;
        ig2.A0Z(12);
        this.A05 = ig2.A0I();
        ig.A0Z(12);
        this.A04 = ig.A0I();
        C1662Hr.A06(ig.A09() == 1, A00(0, 21, 44));
        this.A00 = -1;
    }

    public final boolean A03() {
        long jA0N;
        int iA0I;
        int i = this.A00 + 1;
        this.A00 = i;
        if (i == this.A05) {
            if (A0A[6].length() == 19) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[2] = "dfpT2dt5bGn60gbEA6wBElGJneIfVZr3";
            strArr[2] = "dfpT2dt5bGn60gbEA6wBElGJneIfVZr3";
            return false;
        }
        if (this.A08) {
            jA0N = this.A06.A0O();
        } else {
            jA0N = this.A06.A0N();
        }
        this.A02 = jA0N;
        if (this.A00 == this.A03) {
            this.A01 = this.A07.A0I();
            this.A07.A0a(4);
            int i2 = this.A04 - 1;
            this.A04 = i2;
            if (i2 > 0) {
                IG ig = this.A07;
                String[] strArr2 = A0A;
                if (strArr2[0].length() != strArr2[1].length()) {
                    iA0I = ig.A0I() - 1;
                } else {
                    String[] strArr3 = A0A;
                    strArr3[2] = "DxoiDv7jb7q87sjQbqIMGefCzqS86q5Y";
                    strArr3[2] = "DxoiDv7jb7q87sjQbqIMGefCzqS86q5Y";
                    iA0I = ig.A0I() - 1;
                }
            } else {
                iA0I = -1;
            }
            this.A03 = iA0I;
        }
        return true;
    }
}
