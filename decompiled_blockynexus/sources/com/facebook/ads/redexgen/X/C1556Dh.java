package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1556Dh extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{36, Utf8.REPLACEMENT_BYTE, 71, 74, 67, 66, -2, 82, 77, -2, 79, 83, 67, 80, 87, -2, 83, 76, 66, 67, 80, 74, 87, 71, 76, 69, -2, 75, 67, 66, 71, Utf8.REPLACEMENT_BYTE, -2, 65, 77, 66, 67, 65, 81};
    }

    public C1556Dh(Throwable th) {
        super(A00(0, 39, 121), th);
    }
}
