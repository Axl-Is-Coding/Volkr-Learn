package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DD {
    public static byte[] A00;
    public static String[] A01;

    static {
        A07();
        A06();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static DC A04(IG ig) throws AD {
        A0B(1, ig, false);
        long jA0L = ig.A0L();
        int iA0F = ig.A0F();
        long jA0L2 = ig.A0L();
        int iA0B = ig.A0B();
        int iA0B2 = ig.A0B();
        int iA0B3 = ig.A0B();
        int iA0F2 = ig.A0F();
        return new DC(jA0L, iA0F, jA0L2, iA0B, iA0B2, iA0B3, (int) Math.pow(2.0d, iA0F2 & 15), (int) Math.pow(2.0d, (iA0F2 & 240) >> 4), (ig.A0F() & 1) > 0, Arrays.copyOf(ig.A00, ig.A08()));
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{35, 26, 7, 23, 28, 6, 32, 1, 28, 25, 74, 87, 95, 74, 76, 91, 74, 75, ci.m, 76, 71, 78, 93, 78, 76, 91, 74, 93, 92, ci.m, 8, 89, 64, 93, 77, 70, 92, 8, 100, 121, 113, 100, 98, 117, 100, 101, 33, 98, 110, 101, 100, 33, 99, 110, 110, 106, 33, 117, 110, 33, 114, 117, 96, 115, 117, 33, 118, 104, 117, 105, 33, 90, 49, 121, 52, 55, 45, 33, 49, 121, 53, 50, 45, 33, 49, 121, 53, 51, 92, 33, 96, 117, 33, 88, 69, 77, 88, 94, 73, 88, 89, 29, 85, 88, 92, 89, 88, 79, 29, 73, 68, 77, 88, 29, 47, 37, 38, 38, 59, 105, 61, 48, 57, 44, 105, 46, 59, 44, 40, 61, 44, 59, 105, 61, 33, 40, 39, 105, 120, 105, 39, 38, 61, 105, 45, 44, 42, 38, 45, 40, 43, 37, 44, 115, 105, 20, 0, 19, 31, 27, 28, 21, 82, ci.n, 27, 6, 82, 19, 20, 6, 23, 0, 82, 31, 29, 22, 23, 1, 82, 28, 29, 6, 82, 1, 23, 6, 82, 19, 1, 82, 23, 10, 2, 23, 17, 6, 23, 22, 87, 67, 80, 92, 88, 95, 86, 17, 83, 88, 69, 17, 84, 73, 65, 84, 82, 69, 84, 85, 17, 69, 94, 17, 83, 84, 17, 66, 84, 69, 66, 65, 65, 69, 91, 94, ci.l, 90, 87, 94, 75, ci.l, 73, 92, 75, 79, 90, 75, 92, ci.l, 90, 70, 79, 64, ci.l, 28, ci.l, 64, 65, 90, ci.l, 74, 75, 77, 65, 74, 79, 76, 66, 75, 20, ci.l, 38, 42, 59, 59, 34, 37, 44, 107, Utf8.REPLACEMENT_BYTE, 50, 59, 46, 107, 36, Utf8.REPLACEMENT_BYTE, 35, 46, 57, 107, Utf8.REPLACEMENT_BYTE, 35, 42, 37, 107, 123, 107, 37, 36, Utf8.REPLACEMENT_BYTE, 107, 56, 62, 59, 59, 36, 57, Utf8.REPLACEMENT_BYTE, 46, 47, 113, 107, 41, 53, 56, 58, 60, 49, 54, 53, 61, 60, 43, 121, 54, Utf8.REPLACEMENT_BYTE, 121, 45, 48, 52, 60, 121, 61, 54, 52, 56, 48, 55, 121, 45, 43, 56, 55, 42, Utf8.REPLACEMENT_BYTE, 54, 43, 52, 42, 121, 55, 54, 45, 121, 35, 60, 43, 54, 60, 61, 121, 54, 44, 45, 84, 67, 85, 79, 66, 83, 67, 114, 95, 86, 67, 6, 65, 84, 67, 71, 82, 67, 84, 6, 82, 78, 71, 72, 6, 20, 6, 79, 85, 6, 72, 73, 82, 6, 66, 67, 69, 73, 66, 71, 68, 74, 67, 113, 106, 37, 119, 96, 118, 96, 119, 115, 96, 97, 37, 103, 108, 113, 118, 37, 104, 112, 118, 113, 37, 103, 96, 37, 127, 96, 119, 106, 37, 100, 99, 113, 96, 119, 37, 104, 100, 117, 117, 108, 107, 98, 37, 102, 106, 112, 117, 105, 108, 107, 98, 37, 118, 113, 96, 117, 118, 3, 24, 24, 87, 4, 31, 24, 5, 3, 87, 31, 18, 22, 19, 18, 5, 77, 87};
    }

    public static void A07() {
        A01 = new String[]{"97CkWcXqrjyz7Qw2gcwWTf0UsRxLJkLY", "KmKspjn8yBhlsuKfHc5dD1By4HqwQES7", "tM7dEAyUMmHTAlM7QEv8AsYa9vZW08DW", "cnFzSmdUdmsM2SVrr3BadDXsi4nDpClW", "tMN7ldEkNAphgvj5y1u3W8bdaUauudV5", "yEIP5bnoN3ttum2IDgG23FKNyE9RzpP8", "N0hhc3G9NfQEzjT9vQvNmE", "ceiH1Z9CkPvfm4IJnpqvFzCjzC6OBPie"};
    }

    public static int A00(int val) {
        int i = 0;
        while (val > 0) {
            i++;
            String[] strArr = A01;
            if (strArr[1].charAt(17) != strArr[0].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "aCblbtCs51TFarEUteijDfi4L2eIPPB5";
            strArr2[3] = "aCblbtCs51TFarEUteijDfi4L2eIPPB5";
            val >>>= 1;
        }
        return i;
    }

    public static long A01(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    /* JADX WARN: Incorrect condition in loop: B:18:0x004f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.D9 A02(com.facebook.ads.redexgen.X.D7 r12) throws com.facebook.ads.redexgen.X.AD {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DD.A02(com.facebook.ads.redexgen.X.D7):com.facebook.ads.redexgen.X.D9");
    }

    public static DA A03(IG ig) throws AD {
        A0B(3, ig, false);
        int len = (int) ig.A0L();
        String strA0T = ig.A0T(len);
        int len2 = strA0T.length();
        int i = 7 + 4 + len2;
        long jA0L = ig.A0L();
        int len3 = (int) jA0L;
        String[] strArr = new String[len3];
        int i2 = i + 4;
        for (int i3 = 0; i3 < jA0L; i3++) {
            int i4 = (int) ig.A0L();
            strArr[i3] = ig.A0T(i4);
            int i5 = strArr[i3].length();
            i2 = i2 + 4 + i5;
        }
        int i6 = ig.A0F();
        int i7 = i6 & 1;
        if (A01[6].length() != 22) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "uufDOlXzPXn7e2vsUzYQOzPoYhXCwGZ3";
        strArr2[7] = "uufDOlXzPXn7e2vsUzYQOzPoYhXCwGZ3";
        if (i7 != 0) {
            return new DA(strA0T, strArr, i2 + 1);
        }
        throw new AD(A05(198, 30, 6));
    }

    public static void A08(int mappingsCount, D7 d7) throws AD {
        int iA02;
        int iA022 = d7.A02(6) + 1;
        for (int i = 0; i < iA022; i++) {
            int iA023 = d7.A02(16);
            if (iA023 != 0) {
                Log.e(A05(0, 10, 66), A05(270, 41, 124) + iA023);
            } else {
                if (d7.A04()) {
                    iA02 = d7.A02(4) + 1;
                } else {
                    iA02 = 1;
                }
                boolean zA04 = d7.A04();
                if (A01[7].charAt(17) == '3') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[1] = "2d5iZcFzMvct5JxqCcZ0JFUoYSVZwGiZ";
                strArr[0] = "NTut6iZFc5ITOEQfsc6CPFa8BEeWuqD1";
                if (zA04) {
                    int iA024 = d7.A02(8) + 1;
                    for (int i2 = 0; i2 < iA024; i2++) {
                        int i3 = mappingsCount - 1;
                        d7.A03(A00(i3));
                        int i4 = mappingsCount - 1;
                        d7.A03(A00(i4));
                    }
                }
                int i5 = d7.A02(2);
                if (i5 == 0) {
                    if (iA02 > 1) {
                        for (int i6 = 0; i6 < mappingsCount; i6++) {
                            d7.A03(4);
                        }
                    }
                    for (int i7 = 0; i7 < iA02; i7++) {
                        d7.A03(8);
                        d7.A03(8);
                        d7.A03(8);
                    }
                } else {
                    throw new AD(A05(406, 58, 50));
                }
            }
        }
    }

    public static void A09(D7 d7) throws AD {
        int iA02 = d7.A02(6) + 1;
        for (int floorType = 0; floorType < iA02; floorType++) {
            int iA022 = d7.A02(16);
            if (iA022 == 0) {
                d7.A03(8);
                d7.A03(16);
                d7.A03(16);
                d7.A03(6);
                d7.A03(8);
                int iA023 = d7.A02(4) + 1;
                for (int rangeBits = 0; rangeBits < iA023; rangeBits++) {
                    d7.A03(8);
                }
            } else if (iA022 == 1) {
                int j = d7.A02(5);
                int i = -1;
                int[] iArr = new int[j];
                for (int i2 = 0; i2 < j; i2++) {
                    iArr[i2] = d7.A02(4);
                    if (iArr[i2] > i) {
                        i = iArr[i2];
                    }
                }
                int[] iArr2 = new int[i + 1];
                int i3 = 0;
                while (true) {
                    int length = iArr2.length;
                    String[] strArr = A01;
                    if (strArr[1].charAt(17) != strArr[0].charAt(17)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[5] = "G5LXKc5ovtw5smiaOglq2UN4xBS1bXIF";
                    strArr2[5] = "G5LXKc5ovtw5smiaOglq2UN4xBS1bXIF";
                    if (i3 < length) {
                        iArr2[i3] = d7.A02(3) + 1;
                        int classSubclasses = d7.A02(2);
                        if (classSubclasses > 0) {
                            d7.A03(8);
                        }
                        for (int i4 = 0; i4 < (1 << classSubclasses); i4++) {
                            d7.A03(8);
                        }
                        i3++;
                    } else {
                        d7.A03(2);
                        int iA024 = d7.A02(4);
                        int i5 = 0;
                        int i6 = 0;
                        for (int k = 0; k < j; k++) {
                            int rangeBits2 = iArr[k];
                            i5 += iArr2[rangeBits2];
                            while (i6 < i5) {
                                d7.A03(iA024);
                                i6++;
                            }
                        }
                    }
                }
            } else {
                throw new AD(A05(114, 41, 126) + iA022);
            }
        }
    }

    public static void A0A(D7 d7) throws AD {
        int iA02 = d7.A02(6) + 1;
        for (int classifications = 0; classifications < iA02; classifications++) {
            if (d7.A02(16) <= 2) {
                d7.A03(24);
                d7.A03(24);
                d7.A03(24);
                int iA022 = d7.A02(6) + 1;
                d7.A03(8);
                int[] iArr = new int[iA022];
                for (int i = 0; i < iA022; i++) {
                    int iA023 = 0;
                    int iA024 = d7.A02(3);
                    if (d7.A04()) {
                        iA023 = d7.A02(5);
                    }
                    int highBits = iA023 * 8;
                    iArr[i] = highBits + iA024;
                }
                for (int i2 = 0; i2 < iA022; i2++) {
                    for (int i3 = 0; i3 < 8; i3++) {
                        int k = 1 << i3;
                        if ((iArr[i2] & k) != 0) {
                            d7.A03(8);
                        }
                    }
                }
            } else {
                throw new AD(A05(363, 43, 17));
            }
        }
    }

    public static boolean A0B(int i, IG ig, boolean z) throws AD {
        if (ig.A05() < 7) {
            if (z) {
                return false;
            }
            throw new AD(A05(464, 18, 64) + ig.A05());
        }
        if (ig.A0F() != i) {
            if (z) {
                return false;
            }
            throw new AD(A05(93, 21, 10) + Integer.toHexString(i));
        }
        if (ig.A0F() != 118 || ig.A0F() != 111 || ig.A0F() != 114 || ig.A0F() != 98 || ig.A0F() != 105 || ig.A0F() != 115) {
            if (z) {
                return false;
            }
            throw new AD(A05(10, 28, 24));
        }
        if (A01[6].length() != 22) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "3PFcydRg4Lp36gDWvcJwdxiXGhHOWBjb";
        strArr[0] = "aGBtdcQRGSwkEsynEcaJAL8zRbeII6kr";
        return true;
    }

    public static DB[] A0C(D7 d7) {
        int iA02 = d7.A02(6) + 1;
        DB[] dbArr = new DB[iA02];
        for (int windowType = 0; windowType < iA02; windowType++) {
            dbArr[windowType] = new DB(d7.A04(), d7.A02(16), d7.A02(16), d7.A02(8));
        }
        return dbArr;
    }

    public static DB[] A0D(IG ig, int i) throws AD {
        A0B(5, ig, false);
        int i2 = ig.A0F() + 1;
        D7 d7 = new D7(ig.A00);
        d7.A03(ig.A07() * 8);
        for (int i3 = 0; i3 < i2; i3++) {
            A02(d7);
        }
        int iA02 = d7.A02(6) + 1;
        for (int timeCount = 0; timeCount < iA02; timeCount++) {
            int i4 = d7.A02(16);
            if (i4 != 0) {
                throw new AD(A05(311, 52, 110));
            }
        }
        A09(d7);
        A0A(d7);
        A08(i, d7);
        DB[] dbArrA0C = A0C(d7);
        if (d7.A04()) {
            return dbArrA0C;
        }
        throw new AD(A05(155, 43, 69));
    }
}
