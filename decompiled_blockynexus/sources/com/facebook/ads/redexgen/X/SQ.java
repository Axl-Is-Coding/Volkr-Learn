package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SQ implements C4C {
    public static byte[] A04;
    public static String[] A05;
    public int A00;
    public int A01;
    public int A02;
    public int[] A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-87, -66, -42, -52, -46, -47, 125, -51, -52, -48, -58, -47, -58, -52, -53, -48, 125, -54, -46, -48, -47, 125, -65, -62, 125, -53, -52, -53, -118, -53, -62, -60, -66, -47, -58, -45, -62, -60, -35, -20, -39, -32, -108, -40, -35, -25, -24, -43, -30, -41, -39, -108, -31, -23, -25, -24, -108, -42, -39, -108, -30, -29, -30, -95, -30, -39, -37, -43, -24, -35, -22, -39};
    }

    public static void A02() {
        A05 = new String[]{"yYJ6SOT3uDFyj2TBTti7WWfRsn28EaA0", "ibfMp1J9gSZsYrxVf4NvaZx8D9JO1QBg", "rjgnGVcZwB7yGoiyculy9B4zYqmoHpCR", "", "BFeMqfRovMahqpkErO60kJAdny9RRdno", "ZwvbtEc0kmFFJCTTqnK3GQ6ySyfI7Whf", "3RaP0tr92GxZHPCEm9", "lHI5DV8"};
    }

    public final void A03() {
        int[] iArr = this.A03;
        if (iArr != null) {
            if (A05[7].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "V5jR13F";
            strArr[7] = "V5jR13F";
            Arrays.fill(iArr, -1);
        }
        this.A00 = 0;
    }

    public final void A04(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
    }

    public final void A05(EI ei, boolean z) {
        this.A00 = 0;
        int[] iArr = this.A03;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        C4E c4e = ei.A06;
        if (ei.A04 != null && c4e != null && c4e.A1Z()) {
            if (z) {
                boolean zA0K = ei.A00.A0K();
                String[] strArr = A05;
                if (strArr[0].charAt(30) != strArr[5].charAt(30)) {
                    String[] strArr2 = A05;
                    strArr2[7] = "b5aEeD0";
                    strArr2[7] = "b5aEeD0";
                    if (!zA0K) {
                        c4e.A1w(ei.A04.A0E(), this);
                    }
                }
                throw new RuntimeException();
            }
            if (!ei.A1u()) {
                c4e.A1v(this.A01, this.A02, ei.A0s, this);
            }
            int i = this.A00;
            int i2 = c4e.A00;
            String[] strArr3 = A05;
            if (strArr3[3].length() != strArr3[6].length()) {
                String[] strArr4 = A05;
                strArr4[7] = "TjVTm35";
                strArr4[7] = "TjVTm35";
                if (i > i2) {
                    c4e.A00 = this.A00;
                    c4e.A08 = z;
                    ei.A0r.A0P();
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    public final boolean A06(int i) {
        if (this.A03 != null) {
            int i2 = this.A00 * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.A03[i3] == i) {
                    String[] strArr = A05;
                    if (strArr[0].charAt(30) == strArr[5].charAt(30)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A05;
                    strArr2[2] = "SVfMGWcG5IEJEA83X9P3956xbutBXkdM";
                    strArr2[2] = "SVfMGWcG5IEJEA83X9P3956xbutBXkdM";
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4C
    public final void A3J(int i, int i2) {
        if (i >= 0) {
            if (i2 >= 0) {
                int i3 = this.A00 * 2;
                int[] iArr = this.A03;
                if (iArr == null) {
                    this.A03 = new int[4];
                    Arrays.fill(this.A03, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr2 = this.A03;
                    this.A03 = new int[i3 * 2];
                    System.arraycopy(iArr2, 0, this.A03, 0, iArr2.length);
                }
                int[] iArr3 = this.A03;
                iArr3[i3] = i;
                iArr3[i3 + 1] = i2;
                this.A00++;
                return;
            }
            throw new IllegalArgumentException(A00(37, 35, 33));
        }
        throw new IllegalArgumentException(A00(0, 37, 10));
    }
}
