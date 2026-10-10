package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class IJ extends IOException {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{33, 45, 101, 100, 106, 101, 104, 126, 121, 48, 61, 31, 4, 2, 31, 4, 25, 20, 77, 25, 2, 2, 77, 1, 2, 26, 77, 54, 29, 31, 4, 2, 31, 4, 25, 20, 80, 65};
    }

    public IJ(int i, int i2) {
        super(A00(10, 27, 94) + i + A00(0, 10, 62) + i2 + A00(37, 1, 47));
    }
}
