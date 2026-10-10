package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum O9 {
    A09(A01(206, 10, 80)),
    A0B(A01(226, 24, 43)),
    A03(A01(140, 13, 57)),
    A06(A01(177, 18, 53)),
    A05(A01(158, 19, 61)),
    A0A(A01(216, 10, 6)),
    A0C(A01(250, 3, 40)),
    A04(A01(153, 5, 53)),
    A08(A01(200, 6, 110)),
    A0D(A01(253, 10, 76)),
    A0E(A01(263, 15, 2)),
    A07(A01(195, 5, 64)),
    A0F(A01(0, 0, 107));

    public static byte[] A01;
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-21, -12, -9, -5, -19, 7, -22, -6, -9, -1, -5, -19, -6, -44, -43, -46, -27, -41, -82, -77, -67, -85, -84, -74, -81, -55, -84, -85, -83, -75, -55, -84, -65, -66, -66, -71, -72, -25, -16, -29, -28, -18, -25, 1, -28, -29, -27, -19, 1, -28, -9, -10, -10, -15, -16, -40, -27, -27, -30, -27, -12, 3, -4, -4, -13, -6, 24, 17, 30, 20, 28, 21, 47, 19, 36, 17, -40, -36, -33, -31, -44, -30, -30, -40, -34, -35, -58, -69, -49, -56, -67, -62, -39, -69, -66, -39, -52, -65, -54, -55, -52, -50, -61, -56, -63, 24, 27, 19, 26, 17, 35, 43, 18, 33, 26, 26, 17, 24, 31, 18, 36, ci.l, 31, 17, 44, ci.n, 28, 26, 29, 25, 18, 33, 18, -13, -20, -23, -20, -19, -11, -20, -8, 1, 4, 8, -6, -12, -9, 7, 4, 12, 8, -6, 7, -11, -10, -13, 6, -8, -3, 2, 12, -6, -5, 5, -2, -8, -5, -6, -4, 4, -8, -5, ci.l, ci.k, ci.k, 8, 7, -10, -1, -14, -13, -3, -10, -16, -13, -14, -12, -4, -16, -13, 6, 5, 5, 0, -1, 1, ci.l, ci.l, 11, ci.l, 48, Utf8.REPLACEMENT_BYTE, 56, 56, 47, 54, 20, ci.k, 26, ci.n, 24, 17, 11, ci.m, 32, ci.k, -53, -49, -46, -44, -57, -43, -43, -53, -47, -48, -13, -24, -4, -11, -22, -17, -26, -24, -21, -26, -7, -20, -9, -10, -7, -5, -16, -11, -18, -26, -19, -13, -10, -2, -16, -13, -21, 22, ci.k, 31, 7, ci.l, 29, 22, 22, ci.k, 20, -48, -61, -43, -65, -48, -62, -67, -63, -51, -53, -50, -54, -61, -46, -61};
    }

    static {
        A02();
    }

    O9(String str) {
        this.A00 = str;
    }

    public static O9 A00(String str) {
        for (O9 o9 : values()) {
            if (o9.A00.equalsIgnoreCase(str)) {
                return o9;
            }
        }
        return A0F;
    }
}
