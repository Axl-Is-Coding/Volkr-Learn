package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1H implements Serializable {
    public static byte[] A03 = null;
    public static final long serialVersionUID = -4041915335826065133L;
    public final String A00;
    public final String A01;
    public final String A02;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{91, 64, 89, 89};
    }

    public C1H(String str, String str2, String str3) {
        this.A02 = A01(str);
        this.A01 = A01(str2);
        this.A00 = A01(str3);
    }

    public static String A01(String str) {
        if (A00(0, 4, 119).equalsIgnoreCase(str)) {
            return A00(0, 0, 68);
        }
        return str;
    }

    public final String A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A02;
    }
}
