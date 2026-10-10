package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum QS {
    A03(A01(35, 4, 104)),
    A04(A01(39, 4, 113));

    public static byte[] A01;
    public String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-99, -84, -93, -93, -22, ci.m, 23, 2, ci.k, 10, 5, -63, 20, 6, 19, 23, 6, 19, -63, 19, 6, 20, 17, ci.n, ci.m, 20, 6, -37, -63, -58, 20, -34, -40, -40, -29, 36, 51, 42, 42, 50, 44, 44, 55};
    }

    static {
        A02();
    }

    QS(String str) {
        this.A00 = str;
    }

    public static QS A00(String str) {
        for (QS qs : values()) {
            if (qs.A00.equals(str)) {
                return qs;
            }
        }
        throw new IllegalArgumentException(String.format(Locale.US, A01(4, 27, 75), str));
    }
}
