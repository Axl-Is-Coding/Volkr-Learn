package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IG {
    public static byte[] A03;
    public static String[] A04;
    public byte[] A00;
    public int A01;
    public int A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 24);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-33, 4, 12, -9, 2, -1, -6, -74, -21, -22, -36, -61, -50, -74, 9, -5, 7, 11, -5, 4, -7, -5, -74, -7, 5, 4, 10, -1, 4, 11, -9, 10, -1, 5, 4, -74, -8, ci.m, 10, -5, -48, -74, -67, -30, -22, -43, -32, -35, -40, -108, -55, -56, -70, -95, -84, -108, -25, -39, -27, -23, -39, -30, -41, -39, -108, -38, -35, -26, -25, -24, -108, -42, -19, -24, -39, -82, -108, -113, -86, -85, 91, -99, -92, -81, 91, -87, -86, -81, 91, -75, -96, -83, -86, 117, 91, -49, -50, -64, -89, -78};
    }

    public static void A02() {
        A04 = new String[]{"HJCnnsvFRKCxDDAbEWuhDIcdg3xeT1pm", "aXWy8CvsRXCMVcJtmBA1wVRdgUuSFZpH", "GQPvM", "pDI65rPXKWggiakX8tUTXOsWDv9apWvH", "LM6A01RjpialbK5Oi", "vEfQavrNrAXrkYYeEOthMrPonFtv4Upj", "EEXi7u9hiAizt85cGACEO5SSNblzx1I5", "5Jpn3XfqvoPj"};
    }

    public IG() {
    }

    public IG(int i) {
        this.A00 = new byte[i];
        this.A01 = i;
    }

    public IG(byte[] bArr) {
        this.A00 = bArr;
        this.A01 = bArr.length;
    }

    public IG(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A01 = i;
    }

    public final char A03() {
        byte[] bArr = this.A00;
        int i = this.A02;
        return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public final double A04() {
        return Double.longBitsToDouble(A0M());
    }

    public final int A05() {
        return this.A01 - this.A02;
    }

    public final int A06() {
        byte[] bArr = this.A00;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int A07() {
        return this.A02;
    }

    public final int A08() {
        return this.A01;
    }

    public final int A09() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 16);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr[i5] & 255) << 8);
        int i7 = this.A02;
        this.A02 = i7 + 1;
        return (bArr[i7] & 255) | i6;
    }

    public final int A0A() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = ((bArr[i] & 255) << 24) >> 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return (bArr[i5] & 255) | i4;
    }

    public final int A0B() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = bArr[i] & 255;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        int i6 = i4 | ((bArr[i5] & 255) << 16);
        int i7 = this.A02;
        this.A02 = i7 + 1;
        return ((bArr[i7] & 255) << 24) | i6;
    }

    public final int A0C() {
        int iA0B = A0B();
        if (iA0B >= 0) {
            return iA0B;
        }
        throw new IllegalStateException(A00(77, 18, 35) + iA0B);
    }

    public final int A0D() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = bArr[i] & 255;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        return ((bArr[i3] & 255) << 8) | i2;
    }

    public final int A0E() {
        int b2 = A0F();
        int b3 = A0F();
        int b4 = A0F();
        int b22 = (b2 << 21) | (b3 << 14);
        int b32 = b4 << 7;
        return b22 | b32 | A0F();
    }

    public final int A0F() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        return bArr[i] & 255;
    }

    public final int A0G() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = (bArr[i3] & 255) | i2;
        this.A02 += 2;
        return i4;
    }

    public final int A0H() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        return (bArr[i5] & 255) | i4;
    }

    public final int A0I() {
        int iA09 = A09();
        if (iA09 >= 0) {
            return iA09;
        }
        throw new IllegalStateException(A00(77, 18, 35) + iA09);
    }

    public final int A0J() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    public final long A0K() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.A02;
        this.A02 = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 24);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32);
        int i6 = this.A02;
        this.A02 = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 40);
        int i7 = this.A02;
        this.A02 = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 48);
        int i8 = this.A02;
        this.A02 = i8 + 1;
        return j7 | ((255 & ((long) bArr[i8])) << 56);
    }

    public final long A0L() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.A02;
        this.A02 = i4 + 1;
        return j3 | ((255 & ((long) bArr[i4])) << 24);
    }

    public final long A0M() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i4 = this.A02;
        this.A02 = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i5 = this.A02;
        this.A02 = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.A02;
        this.A02 = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i7 = this.A02;
        this.A02 = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        int i8 = this.A02;
        this.A02 = i8 + 1;
        return j7 | (255 & ((long) bArr[i8]));
    }

    public final long A0N() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i2 = this.A02;
        this.A02 = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i3 = this.A02;
        this.A02 = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.A02;
        this.A02 = i4 + 1;
        return j3 | (255 & ((long) bArr[i4]));
    }

    public final long A0O() {
        long jA0M = A0M();
        if (jA0M >= 0) {
            return jA0M;
        }
        throw new IllegalStateException(A00(77, 18, 35) + jA0M);
    }

    public final long A0P() {
        int i = 0;
        long j = this.A00[this.A02];
        int i2 = 7;
        while (true) {
            if (i2 < 0) {
                break;
            }
            int j2 = 1 << i2;
            long j3 = ((long) j2) & j;
            if (A04[3].charAt(7) == 'H') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[7] = "lhGNf9ZIwuKG";
            strArr[7] = "lhGNf9ZIwuKG";
            if (j3 != 0) {
                i2--;
            } else if (i2 < 6) {
                int j4 = 1 << i2;
                j &= (long) (j4 - 1);
                i = 7 - i2;
            } else if (i2 == 7) {
                i = 1;
            }
        }
        if (i != 0) {
            int i3 = 1;
            while (i3 < i) {
                byte[] bArr = this.A00;
                int i4 = this.A02;
                byte b2 = bArr[i4 + i3];
                if ((b2 & 192) == 128) {
                    long j5 = j << 6;
                    String[] strArr2 = A04;
                    String str = strArr2[5];
                    String str2 = strArr2[6];
                    int iCharAt = str.charAt(9);
                    int i5 = str2.charAt(9);
                    if (iCharAt != i5) {
                        String[] strArr3 = A04;
                        strArr3[7] = "BvJ8XuqLfWkj";
                        strArr3[7] = "BvJ8XuqLfWkj";
                        int i6 = b2 & Utf8.REPLACEMENT_BYTE;
                        j = j5 | ((long) i6);
                        i3 += 0;
                    } else {
                        String[] strArr4 = A04;
                        strArr4[7] = "bl64THqm1YbP";
                        strArr4[7] = "bl64THqm1YbP";
                        int i7 = b2 & Utf8.REPLACEMENT_BYTE;
                        j = j5 | ((long) i7);
                        i3++;
                    }
                } else {
                    throw new NumberFormatException(A00(0, 42, 126) + j);
                }
            }
            int i8 = this.A02;
            this.A02 = i8 + i;
            return j;
        }
        throw new NumberFormatException(A00(42, 35, 92) + j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
    
        if (r6.A02 == r3) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a7, code lost:
    
        if (r6.A02 == r3) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0Q() {
        /*
            r6 = this;
            int r0 = r6.A05()
            if (r0 != 0) goto L28
            r3 = 0
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.IG.A04
            r0 = 3
            r1 = r1[r0]
            r0 = 7
            char r1 = r1.charAt(r0)
            r0 = 72
            if (r1 == r0) goto L22
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.IG.A04
            java.lang.String r1 = "Lp13SRVWSAlchtHB237WPpHnlSgF4gaJ"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "rKST0dS6uAv5sauBNsTeIX1rNmAgPgcE"
            r0 = 6
            r2[r0] = r1
            return r3
        L22:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L28:
            int r5 = r6.A02
        L2a:
            int r0 = r6.A01
            if (r5 >= r0) goto L3b
            byte[] r0 = r6.A00
            r0 = r0[r5]
            boolean r0 = com.facebook.ads.redexgen.X.IW.A0e(r0)
            if (r0 != 0) goto L3b
            int r5 = r5 + 1
            goto L2a
        L3b:
            int r4 = r6.A02
            int r0 = r5 - r4
            r3 = 3
            if (r0 < r3) goto L5d
            byte[] r2 = r6.A00
            r1 = r2[r4]
            r0 = -17
            if (r1 != r0) goto L5d
            int r0 = r4 + 1
            r1 = r2[r0]
            r0 = -69
            if (r1 != r0) goto L5d
            int r0 = r4 + 2
            r1 = r2[r0]
            r0 = -65
            if (r1 != r0) goto L5d
            int r4 = r4 + r3
            r6.A02 = r4
        L5d:
            byte[] r2 = r6.A00
            int r1 = r6.A02
            int r0 = r5 - r1
            java.lang.String r4 = com.facebook.ads.redexgen.X.IW.A0R(r2, r1, r0)
            r6.A02 = r5
            int r2 = r6.A02
            int r3 = r6.A01
            if (r2 != r3) goto L70
            return r4
        L70:
            byte[] r0 = r6.A00
            r1 = r0[r2]
            r0 = 13
            if (r1 != r0) goto Laa
            int r0 = r2 + 1
            r6.A02 = r0
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.IG.A04
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 5
            if (r1 == r0) goto L99
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.IG.A04
            java.lang.String r1 = "7WLwSFEg60VT5h1w5xCSRnUKgnyD8yNS"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "aRAvn4znRhpfiIQyr1UPz3MngzOxDO2U"
            r0 = 0
            r2[r0] = r1
            int r0 = r6.A02
            if (r0 != r3) goto Laa
        L98:
            return r4
        L99:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.IG.A04
            java.lang.String r1 = "q7voCOqIwzwrpNWuoMFHLwpJUMmmskbB"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "q7voCOqIwzwrpNWuoMFHLwpJUMmmskbB"
            r0 = 3
            r2[r0] = r1
            int r0 = r6.A02
            if (r0 != r3) goto Laa
            goto L98
        Laa:
            byte[] r0 = r6.A00
            int r2 = r6.A02
            r1 = r0[r2]
            r0 = 10
            if (r1 != r0) goto Lb8
            int r0 = r2 + 1
            r6.A02 = r0
        Lb8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IG.A0Q():java.lang.String");
    }

    public final String A0R() {
        if (A05() == 0) {
            return null;
        }
        int i = this.A02;
        while (i < this.A01 && this.A00[i] != 0) {
            i++;
        }
        byte[] bArr = this.A00;
        int i2 = this.A02;
        String strA0R = IW.A0R(bArr, i2, i - i2);
        this.A02 = i;
        int i3 = this.A02;
        if (i3 < this.A01) {
            this.A02 = i3 + 1;
        }
        return strA0R;
    }

    public final String A0S(int lastIndex) {
        if (lastIndex == 0) {
            return A00(0, 0, 47);
        }
        int i = lastIndex;
        int i2 = (this.A02 + lastIndex) - 1;
        if (i2 < this.A01 && this.A00[i2] == 0) {
            i--;
        }
        String strA0R = IW.A0R(this.A00, this.A02, i);
        this.A02 += lastIndex;
        return strA0R;
    }

    public final String A0T(int i) {
        return A0U(i, Charset.forName(A00(95, 5, 98)));
    }

    public final String A0U(int i, Charset charset) {
        String str = new String(this.A00, this.A02, i, charset);
        this.A02 += i;
        return str;
    }

    public final short A0V() {
        byte[] bArr = this.A00;
        int i = this.A02;
        this.A02 = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.A02;
        this.A02 = i3 + 1;
        return (short) ((bArr[i3] & 255) | i2);
    }

    public final void A0W() {
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0X(int i) {
        A0c(A06() < i ? new byte[i] : this.A00, i);
    }

    public final void A0Y(int i) {
        C1662Hr.A03(i >= 0 && i <= this.A00.length);
        this.A01 = i;
    }

    public final void A0Z(int i) {
        C1662Hr.A03(i >= 0 && i <= this.A01);
        this.A02 = i;
    }

    public final void A0a(int i) {
        A0Z(this.A02 + i);
    }

    public final void A0b(IF r3, int i) {
        A0d(r3.A00, 0, i);
        r3.A08(0);
    }

    public final void A0c(byte[] bArr, int i) {
        this.A00 = bArr;
        this.A01 = i;
        this.A02 = 0;
    }

    public final void A0d(byte[] bArr, int i, int i2) {
        System.arraycopy(this.A00, this.A02, bArr, i, i2);
        this.A02 += i2;
    }
}
