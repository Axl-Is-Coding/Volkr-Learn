package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum JT {
    A06(-1, 100, 1, 0),
    A07(-1, 120, 2, 1),
    A08(-1, 300, 3, 2),
    A09(-1, 400, 4, 3),
    A0A(-1, 50, 5, 4),
    A0B(-1, -1, 6, 5);

    public static byte[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-110, -113, -109, -111, -110, -98, -87, 123, 122, 122, -63, -66, -62, -64, -63, -51, -40, -86, -85, -87, -65, -68, -64, -66, -65, -53, -42, -86, -89, -89, -47, -50, -46, -48, -47, -35, -24, -67, -71, -71, -121, -124, -120, -122, -121, -109, -98, 116, 111, -72, -85, -87, -70, -59, -86, -65, -76, -89, -77, -81, -87};
    }

    static {
        A02();
    }

    JT(int i, int i2, int i3, int i4) {
        this.A03 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A00 = i4;
    }

    public static JT A00(int i) {
        for (JT jt : values()) {
            if (jt.A00 == i) {
                return jt;
            }
        }
        return null;
    }

    public final int A03() {
        return this.A01;
    }

    public final int A04() {
        return this.A02;
    }

    public final int A05() {
        return this.A03;
    }
}
