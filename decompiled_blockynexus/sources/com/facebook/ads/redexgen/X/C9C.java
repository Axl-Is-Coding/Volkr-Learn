package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9C {
    public static byte[] A00;
    public static final String A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-2, -15, -17, -5, -2, -16, -21, -16, -19, 0, -19, -18, -19, -1, -15};
    }

    static {
        A03();
        A01 = C9C.class.getSimpleName();
    }

    public static C9E A00(C2027Wc c2027Wc) {
        try {
            return new XI(c2027Wc);
        } catch (IOException e2) {
            c2027Wc.A04().A8H(A02(0, 15, 89), C8Y.A1x, new C8Z(e2));
            return new XF();
        }
    }

    public static CV A01(C2027Wc c2027Wc) {
        return new CV(c2027Wc);
    }
}
