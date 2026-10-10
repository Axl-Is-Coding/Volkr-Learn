package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC12420d {
    A02,
    A03;

    public static byte[] A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-25, -27, -14, -14, -13, -8, 3, -13, -12, -23, -14, -6, -8, 5, 5, 6, 11, 22, 11, 9, -8, -6, 2};
    }

    static {
        A01();
    }

    public static boolean A02(@Nullable EnumC12420d enumC12420d) {
        return A02.equals(enumC12420d) || A03.equals(enumC12420d);
    }
}
