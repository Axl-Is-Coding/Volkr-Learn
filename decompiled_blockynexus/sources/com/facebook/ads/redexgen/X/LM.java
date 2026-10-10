package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum LM {
    A08(0),
    A07(0),
    A06(1),
    A03(2),
    A04(3),
    A05(4);

    public static byte[] A01;
    public final int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-85, -83, -96, -89, -86, -93, -67, -112, -91, -36, -34, -47, -40, -37, -44, -18, -62, -42, -45, -43, -56, -49, -46, -53, -27, -70, -51, -26, -24, -37, -30, -27, -34, -8, -30, -25, -19, -34, -21, -25, -34, -19, -90, -89, -90, -99, -34, -41, -44, -41, -40, -32, -41};
    }

    static {
        A01();
    }

    LM(int i) {
        this.A00 = i;
    }
}
