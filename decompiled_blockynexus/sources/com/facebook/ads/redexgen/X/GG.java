package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GG {
    public static byte[] A00;
    public static String[] A01;
    public static final int A02;
    public static final int A03;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-52, -18, -22, -34, -3, -14, -11, 113, -127, 116, 94, -71, -77, -85, -90, -99, -75, -77, -70, -70, -77, -72, -79, 106, -68, -81, -73, -85, -77, -72, -82, -81, -68, 106, -71, -80, 106, -73, -85, -74, -80, -71, -68, -73, -81, -82, 106, -99, -113, -109, 106, -104, -117, -106, 106, -65, -72, -77, -66, 120};
    }

    public static void A03() {
        A01 = new String[]{"ijZd2SvY", "Ph5fJqf6OowbUT2cqzgcB298kDhnW2OX", "wB5WDB4JU6krUWdN", "eBmlwoifn7sQacvwvpCdDN7mM49lFTV9", "8TaUd8AxspPDe4hMAHd3njvqxnnZalZZ", "my8xvAbSAhbAvtjE", "sCujs14tvAISPjVlxjJqhwIZMpV4htIn", "ZuHVfppKLGIB3c7uxsgIg35bH7izaigq"};
    }

    static {
        A03();
        A02();
        A03 = IW.A08(A01(11, 4, 102));
        A02 = IW.A08(A01(7, 4, 33));
    }

    public static int A00(IG ig) {
        int b2 = 0;
        while (ig.A05() != 0) {
            int iA0F = ig.A0F();
            String[] strArr = A01;
            if (strArr[2].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "2iVFcVRayhlXICIL";
            strArr2[5] = "cB88SmkuRLYvydLN";
            b2 += iA0F;
            if (iA0F != 255) {
                return b2;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A04(long r13, com.facebook.ads.redexgen.X.IG r15, com.facebook.ads.redexgen.X.CM[] r16) {
        /*
        L0:
            r4 = r15
            int r0 = r4.A05()
            r8 = 1
            if (r0 <= r8) goto La3
            int r2 = A00(r4)
            int r1 = A00(r4)
            int r3 = r4.A07()
            int r3 = r3 + r1
            r0 = -1
            if (r1 == r0) goto L1e
            int r0 = r4.A05()
            if (r1 <= r0) goto L3b
        L1e:
            r2 = 0
            r1 = 7
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r3 = A01(r2, r1, r0)
            r2 = 15
            r1 = 45
            r0 = 62
            java.lang.String r0 = A01(r2, r1, r0)
            android.util.Log.w(r3, r0)
            int r3 = r4.A08()
        L37:
            r4.A0Z(r3)
            goto L0
        L3b:
            r0 = 4
            if (r2 != r0) goto L37
            r0 = 8
            if (r1 < r0) goto L37
            int r10 = r4.A0F()
            int r9 = r4.A0J()
            r7 = 0
            r6 = 49
            if (r9 != r6) goto L53
            int r7 = r4.A09()
        L53:
            int r5 = r4.A0F()
            r1 = 47
            if (r9 != r1) goto L5e
            r4.A0a(r8)
        L5e:
            r0 = 181(0xb5, float:2.54E-43)
            r2 = 0
            if (r10 != r0) goto La1
            if (r9 == r6) goto L67
            if (r9 != r1) goto La1
        L67:
            r0 = 3
            if (r5 != r0) goto La1
            r1 = 1
        L6b:
            if (r9 != r6) goto L77
            int r0 = com.facebook.ads.redexgen.X.GG.A03
            if (r7 == r0) goto L75
            int r0 = com.facebook.ads.redexgen.X.GG.A02
            if (r7 != r0) goto L9f
        L75:
            r0 = 1
        L76:
            r1 = r1 & r0
        L77:
            if (r1 == 0) goto L37
            int r0 = r4.A0F()
            r0 = r0 & 31
            r4.A0a(r8)
            int r10 = r0 * 3
            int r1 = r4.A07()
            r5 = r16
            int r0 = r5.length
        L8b:
            if (r2 >= r0) goto L37
            r6 = r5[r2]
            r4.A0Z(r1)
            r6.ACx(r4, r10)
            r9 = 1
            r11 = 0
            r12 = 0
            r7 = r13
            r6.ACy(r7, r9, r10, r11, r12)
            int r2 = r2 + 1
            goto L8b
        L9f:
            r0 = 0
            goto L76
        La1:
            r1 = 0
            goto L6b
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GG.A04(long, com.facebook.ads.redexgen.X.IG, com.facebook.ads.redexgen.X.CM[]):void");
    }
}
