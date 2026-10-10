package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9H {
    public static byte[] A02;
    public static String[] A03;
    public final int A00;
    public final int A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-85, -48, -40, -61, -50, -53, -58, -126, -53, -48, -58, -57, -38, -90, -57, -50, -42, -61, -126, -118, -121, -58, -114, -126, -53, -48, -58, -57, -38, -126, -97, -126, -121, -58, -117, -88, -85, -82, -89, 98, 106, 103, -90, 107, 98, 126, 98, 111, 115, -93, -90, -87, -94, 93, 122, 93, 98, -95, 93, 99, 99, 93, -90, -85, -95, -94, -75, 93, 122, 93, 98, -95, -51, -48, -45, -52, -121, -92, -92, -121, -108, -104, -121, -115, -115, -121, -48, -43, -53, -52, -33, -121, -92, -121, -116, -53};
    }

    public static void A02() {
        A03 = new String[]{"x3S2W4LbSFe5E5feiuJV3xvLrDJW5MIT", "c6l", "kksKjEgnZRd2qIBKnSBjD5FFw", "r4XHqvELKUQNiUGngs8vqNM0Mk3b9MGe", "kvUI2sJVOm05aD2rNLnp8ceY2vExoctW", "R5zC7nE0u0bj6wUda1FjOq7V7", "PNiW5N8GwPzy1zueKCYWrY6DC52FHCY", "sp7WuMlrQg67lkIbNPhafgU9zVWwTylU"};
    }

    public C9H() {
        this(-1, -1);
    }

    public C9H(int i, int i2) {
        if (i >= -1) {
            if (i < 0 || i2 >= 0) {
                if (i != -1 || i2 == -1) {
                    this.A00 = i;
                    this.A01 = i2;
                    return;
                }
                throw new IllegalArgumentException(String.format(Locale.US, A00(72, 24, 68), Integer.valueOf(i2)));
            }
            throw new IllegalArgumentException(String.format(Locale.US, A00(49, 23, 26), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        throw new IllegalArgumentException(String.format(Locale.US, A00(35, 14, 31), Integer.valueOf(i)));
    }

    public final int A03() {
        return this.A00;
    }

    public final int A04() {
        return this.A01;
    }

    public final int A05(C9H c9h) {
        int i = this.A00;
        int i2 = c9h.A00;
        if (i != i2) {
            return i - i2;
        }
        return this.A01 - c9h.A01;
    }

    public final C9H A06(int i) {
        int i2 = this.A01;
        if (i + i2 >= 0) {
            return new C9H(this.A00, i2 + i);
        }
        throw new IllegalArgumentException(String.format(Locale.US, A00(0, 35, 63), Integer.valueOf(i), Integer.valueOf(this.A01)));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C9H)) {
            return false;
        }
        C9H c9h = (C9H) obj;
        int i = c9h.A00;
        int i2 = this.A00;
        if (A03[4].charAt(2) != 'U') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[2] = "8FF357LC7LaQaiaU3dBgrFv1B";
        strArr[5] = "tq4t252ij5wfM6c4Cr38q8OJQ";
        return i == i2 && c9h.A01 == this.A01;
    }

    public final int hashCode() {
        return (this.A00 * 2) + (this.A01 * 3);
    }
}
