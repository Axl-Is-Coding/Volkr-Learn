package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum C9I {
    A02,
    A04,
    A03;

    public static byte[] A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{58, 57, 40, Utf8.REPLACEMENT_BYTE, 52, 57, 56, 35, 46, 57, Utf8.REPLACEMENT_BYTE, 51, 46, 56, 47, 67, 64, 81, 70, 77, 90, 71, 80, 67, 67, 64, 87, 90, 81, 74, 74, 90, 86, 72, 68, 73, 73, 77, 76, 92, 81, 70, 64, 76, 81, 71, 80, 92, 87, 76, 92, 69, 70, 87, 64, 75};
    }

    static {
        A01();
    }
}
