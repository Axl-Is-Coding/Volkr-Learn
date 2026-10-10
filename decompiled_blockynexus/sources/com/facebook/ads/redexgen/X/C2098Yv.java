package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2098Yv implements DG {
    public static byte[] A0E;
    public static String[] A0F;
    public long A00;
    public long A01;
    public CM A02;
    public DL A03;
    public String A04;
    public boolean A05;
    public final DP A0B;
    public final boolean[] A0D = new boolean[3];
    public final DM A0A = new DM(32, 128);
    public final DM A08 = new DM(33, 128);
    public final DM A06 = new DM(34, 128);
    public final DM A07 = new DM(39, 128);
    public final DM A09 = new DM(40, 128);
    public final IG A0C = new IG();

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0E = new byte[]{-65, -87, -83, -84, -55, -36, -40, -37, -36, -23, -20, 5, -4, ci.m, 7, -4, -6, 11, -4, -5, -73, -8, 10, 7, -4, -6, 11, -10, 9, -8, 11, 0, 6, -10, 0, -5, -6, -73, ci.k, -8, 3, 12, -4, -47, -73, 49, 36, 31, 32, 42, -22, 35, 32, 49, 30};
    }

    public static void A03() {
        A0F = new String[]{com.umeng.analytics.pro.au.at, "PSzfdfjRZC0XN6VxjsgcztfFaZhzgWb7", "1Gl4YGiW2C7ithS", "fAa", "AJgx", "lYVk", "kBtUfz7weItcbZk1MBk54uJpUuqD7Dj9", "de5NTYCoeu4fZv0TXl8jvZIWd"};
    }

    public C2098Yv(DP dp) {
        this.A0B = dp;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.internal.exoplayer2.Format A00(java.lang.String r17, com.facebook.ads.redexgen.X.DM r18, com.facebook.ads.redexgen.X.DM r19, com.facebook.ads.redexgen.X.DM r20) {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2098Yv.A00(java.lang.String, com.facebook.ads.redexgen.X.DM, com.facebook.ads.redexgen.X.DM, com.facebook.ads.redexgen.X.DM):com.facebook.ads.internal.exoplayer2.Format");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04(long r6, int r8, int r9, long r10) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2098Yv.A04(long, int, int, long):void");
    }

    private void A05(long j, int i, int i2, long j2) {
        if (this.A05) {
            this.A03.A04(j, i, i2, j2);
        } else {
            this.A0A.A02(i2);
            this.A08.A02(i2);
            this.A06.A02(i2);
        }
        this.A07.A02(i2);
        this.A09.A02(i2);
    }

    public static void A06(IH ih) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                if (!ih.A0B()) {
                    ih.A05();
                } else {
                    int iMin = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        ih.A04();
                    }
                    for (int i3 = 0; i3 < iMin; i3++) {
                        ih.A04();
                    }
                }
                int i4 = 3;
                if (i != 3) {
                    i4 = 1;
                }
                i2 += i4;
            }
        }
    }

    public static void A07(IH ih) {
        int iA05 = ih.A05();
        boolean zA0B = false;
        int stRpsIdx = 0;
        for (int numNegativePics = 0; numNegativePics < iA05; numNegativePics++) {
            if (numNegativePics != 0) {
                zA0B = ih.A0B();
            }
            if (zA0B) {
                ih.A07();
                ih.A05();
                for (int i = 0; i <= stRpsIdx; i++) {
                    if (ih.A0B()) {
                        ih.A07();
                    }
                }
            } else {
                int numPositivePics = ih.A05();
                int iA052 = ih.A05();
                stRpsIdx = numPositivePics + iA052;
                for (int i2 = 0; i2 < numPositivePics; i2++) {
                    ih.A05();
                    ih.A07();
                }
                for (int i3 = 0; i3 < iA052; i3++) {
                    ih.A05();
                    if (A0F[2].length() != 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0F;
                    strArr[7] = "29HJBmKLkgSGGX3jFY36NCeZA";
                    strArr[7] = "29HJBmKLkgSGGX3jFY36NCeZA";
                    ih.A07();
                }
            }
        }
    }

    private void A08(byte[] bArr, int i, int i2) {
        if (this.A05) {
            this.A03.A05(bArr, i, i2);
        } else {
            this.A0A.A03(bArr, i, i2);
            this.A08.A03(bArr, i, i2);
            this.A06.A03(bArr, i, i2);
        }
        this.A07.A03(bArr, i, i2);
        this.A09.A03(bArr, i, i2);
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) {
        while (ig.A05() > 0) {
            int iA07 = ig.A07();
            int iA08 = ig.A08();
            byte[] bArr = ig.A00;
            this.A01 += (long) ig.A05();
            this.A02.ACx(ig, ig.A05());
            while (iA07 < iA08) {
                int iA04 = IC.A04(bArr, iA07, iA08, this.A0D);
                if (iA04 == iA08) {
                    A08(bArr, iA07, iA08);
                    return;
                }
                int iA00 = IC.A00(bArr, iA04);
                int nalUnitType = iA04 - iA07;
                if (nalUnitType > 0) {
                    A08(bArr, iA07, iA04);
                }
                int lengthToNalUnit = iA08 - iA04;
                long j = this.A01 - ((long) lengthToNalUnit);
                A04(j, lengthToNalUnit, nalUnitType < 0 ? -nalUnitType : 0, this.A00);
                long absolutePosition = this.A00;
                A05(j, lengthToNalUnit, iA00, absolutePosition);
                iA07 = iA04 + 3;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        du.A06();
        this.A04 = du.A05();
        this.A02 = cc.ADr(du.A04(), 2);
        this.A03 = new DL(this.A02);
        this.A0B.A03(cc, du);
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABo() {
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABp(long j, boolean z) {
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void AD1() {
        IC.A0C(this.A0D);
        this.A0A.A01();
        this.A08.A01();
        this.A06.A01();
        this.A07.A01();
        this.A09.A01();
        this.A03.A02();
        this.A01 = 0L;
    }
}
