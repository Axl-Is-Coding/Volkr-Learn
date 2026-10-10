package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Collections;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2092Yp implements DG {
    public static byte[] A0H;
    public static String[] A0I;
    public static final byte[] A0J;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public CM A07;
    public CM A08;
    public CM A09;
    public String A0A;
    public boolean A0B;
    public boolean A0C;
    public final IF A0D;
    public final IG A0E;
    public final String A0F;
    public final boolean A0G;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] - i3) - 49);
            if (A0I[4].charAt(1) != 'n') {
                throw new RuntimeException();
            }
            String[] strArr = A0I;
            strArr[4] = "bnluMaXE1Uw3b3JGoNOZfy6HcCqjlXqz";
            strArr[4] = "bnluMaXE1Uw3b3JGoNOZfy6HcCqjlXqz";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0H = new byte[]{-120, 124, -66, -47, -48, 124, -67, -49, -49, -47, -55, -59, -54, -61, 124, -99, -99, -97, 124, -88, -97, -118, -118, -83, -67, -68, -101, -82, -86, -83, -82, -69, -18, ci.m, 30, ci.m, ci.k, 30, ci.m, ci.l, -54, 11, 31, ci.l, 19, 25, -54, 25, 12, 20, ci.m, ci.k, 30, -54, 30, 35, 26, ci.m, -28, -54, -26, -11, -11, -15, -18, -24, -26, -7, -18, -12, -13, -76, -18, -23, -72, ci.n, 36, 19, 24, 30, -34, 28, 31, -29, ci.n, -36, 27, ci.n, 35, 28};
    }

    public static void A07() {
        A0I = new String[]{"wge6vcbYVd2LlwU9IzXxO7y1yc7Npjql", "e4ah1", "HxlECSCujzZIBhcakhB8llOPpIPg4jPi", "c3jgZ7razfwrLoite54T", "YnWTxT53I9VC0eKuEFoJi1GxqSMOrSIM", "mGJBSiyG9M2YGViPKeXmqCjoZalx0YC5", "VtpTHv8dn8NrwXo7ikKBEmVWKD8j4YCX", "dqOZRsMzwGVkln1A4hbisIXuNnIWGGSy"};
    }

    static {
        A07();
        A06();
        A0J = new byte[]{73, 68, 51};
    }

    public C2092Yp(boolean z) {
        this(z, null);
    }

    public C2092Yp(boolean z, String str) {
        this.A0D = new IF(new byte[7]);
        this.A0E = new IG(Arrays.copyOf(A0J, 10));
        A03();
        this.A0G = z;
        this.A0F = str;
    }

    private void A01() throws AD {
        this.A0D.A08(0);
        if (!this.A0C) {
            int iA05 = this.A0D.A05(2) + 1;
            if (iA05 != 2) {
                Log.w(A00(22, 10, 24), A00(32, 28, 121) + iA05 + A00(0, 22, 43));
                iA05 = 2;
            }
            int iA052 = this.A0D.A05(4);
            this.A0D.A09(1);
            int sampleRateIndex = this.A0D.A05(3);
            byte[] bArrA08 = C1666Hv.A08(iA05, iA052, sampleRateIndex);
            Pair<Integer, Integer> pairA03 = C1666Hv.A03(bArrA08);
            Format formatA07 = Format.A07(this.A0A, A00(75, 15, 126), null, -1, -1, ((Integer) pairA03.second).intValue(), ((Integer) pairA03.first).intValue(), Collections.singletonList(bArrA08), null, 0, this.A0F);
            this.A05 = 1024000000 / ((long) formatA07.A0C);
            this.A09.A5I(formatA07);
            this.A0C = true;
        } else {
            IF r6 = this.A0D;
            String[] strArr = A0I;
            String str = strArr[3];
            String str2 = strArr[1];
            int length = str.length();
            int sampleSize = str2.length();
            if (length == sampleSize) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[4] = "gnfbeCT7ETb0BF6eGTwxRLZIMNoo6eBq";
            strArr2[4] = "gnfbeCT7ETb0BF6eGTwxRLZIMNoo6eBq";
            r6.A09(10);
        }
        this.A0D.A09(4);
        int iA053 = (this.A0D.A05(13) - 2) - 5;
        if (this.A0B) {
            iA053 -= 2;
        }
        CM cm = this.A09;
        long j = this.A05;
        if (A0I[0].charAt(1) != 'g') {
            throw new RuntimeException();
        }
        String[] strArr3 = A0I;
        strArr3[5] = "DPeEZCdjnoP4QwMjUw7HIDON5EObNWtY";
        strArr3[6] = "TWt76gMmW2EkEQM2OhdsBT8X6vSrq3Ij";
        A08(cm, j, 0, iA053);
    }

    private void A02() {
        this.A08.ACx(this.A0E, 10);
        this.A0E.A0Z(6);
        A08(this.A08, 0L, 10, this.A0E.A0E() + 10);
    }

    private void A03() {
        this.A03 = 0;
        this.A00 = 0;
        this.A01 = 256;
    }

    private void A04() {
        this.A03 = 2;
        this.A00 = 0;
    }

    private void A05() {
        this.A03 = 1;
        this.A00 = A0J.length;
        this.A02 = 0;
        this.A0E.A0Z(0);
    }

    private void A08(CM cm, long j, int i, int i2) {
        this.A03 = 3;
        this.A00 = i;
        this.A07 = cm;
        this.A04 = j;
        this.A02 = i2;
    }

    private void A09(IG ig) {
        byte[] bArr = ig.A00;
        int position = ig.A07();
        int iA08 = ig.A08();
        while (position < iA08) {
            int i = position + 1;
            int i2 = bArr[position] & 255;
            int position2 = this.A01;
            if (position2 == 512 && i2 >= 240 && i2 != 255) {
                int position3 = i2 & 1;
                this.A0B = position3 == 0;
                A04();
                ig.A0Z(i);
                return;
            }
            int i3 = this.A01;
            int i4 = i3 | i2;
            if (i4 == 329) {
                this.A01 = LogType.UNEXP_OTHER;
            } else if (i4 == 511) {
                this.A01 = 512;
            } else if (i4 == 836) {
                this.A01 = 1024;
            } else if (i4 != 1075) {
                if (i3 != 256) {
                    this.A01 = 256;
                    position = i - 1;
                }
            } else {
                A05();
                ig.A0Z(i);
                return;
            }
            position = i;
        }
        ig.A0Z(position);
    }

    private void A0A(IG ig) {
        int iMin = Math.min(ig.A05(), this.A02 - this.A00);
        this.A07.ACx(ig, iMin);
        this.A00 += iMin;
        int i = this.A00;
        int i2 = this.A02;
        if (i == i2) {
            this.A07.ACy(this.A06, 1, i2, 0, null);
            this.A06 += this.A04;
            A03();
        }
    }

    private boolean A0B(IG ig, byte[] bArr, int i) {
        int iMin = Math.min(ig.A05(), i - this.A00);
        ig.A0d(bArr, this.A00, iMin);
        this.A00 += iMin;
        return this.A00 == i;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) throws AD {
        while (ig.A05() > 0) {
            int i = this.A03;
            if (i == 0) {
                A09(ig);
            } else if (i != 1) {
                String[] strArr = A0I;
                if (strArr[5].charAt(25) == strArr[6].charAt(25)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[5] = "9CqnxzaEQimEcBf5cSINZxdBysafSxdF";
                strArr2[6] = "zLp55t2V8ycwykcXwXcmLQHdTFNUXCiS";
                if (i == 2) {
                    boolean zA0B = A0B(ig, this.A0D.A00, this.A0B ? 7 : 5);
                    if (A0I[0].charAt(1) == 'g') {
                        String[] strArr3 = A0I;
                        strArr3[3] = "PBSyuwIG2tPzzgRnoBM9";
                        strArr3[1] = "owzwp";
                        if (zA0B) {
                            A01();
                        }
                    } else if (zA0B) {
                        A01();
                    }
                } else if (i == 3) {
                    A0A(ig);
                }
            } else if (A0B(ig, this.A0E.A00, 10)) {
                A02();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        du.A06();
        this.A0A = du.A05();
        this.A09 = cc.ADr(du.A04(), 1);
        if (this.A0G) {
            du.A06();
            this.A08 = cc.ADr(du.A04(), 4);
            this.A08.A5I(Format.A0B(du.A05(), A00(60, 15, 84), null, -1, null));
            return;
        }
        this.A08 = new Y9();
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABo() {
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABp(long j, boolean z) {
        this.A06 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void AD1() {
        A03();
    }
}
