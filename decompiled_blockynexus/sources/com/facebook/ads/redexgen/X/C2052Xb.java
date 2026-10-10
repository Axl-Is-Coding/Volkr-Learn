package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2052Xb implements MU {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{50, 62, 60, 127, 55, 48, 50, 52, 51, 62, 62, 58, 127, 48, 53, 34, 127, 56, Utf8.REPLACEMENT_BYTE, 37, 52, 35, 34, 37, 56, 37, 56, 48, 61, 127, 50, 61, 56, 50, 58, 52, 53, 103, 107, 105, 42, 98, 101, 103, 97, 102, 107, 107, 111, 42, 101, 96, 119, 42, 109, 106, 112, 97, 118, 119, 112, 109, 112, 109, 101, 104, 42, 97, 118, 118, 107, 118, 54, 58, 56, 123, 51, 52, 54, 48, 55, 58, 58, 62, 123, 52, 49, 38, 123, 60, 59, 33, 48, 39, 38, 33, 60, 33, 60, 52, 57, 123, 51, 60, 59, 60, 38, 61, 10, 52, 54, 33, 60, 35, 60, 33, 44, 66, 78, 76, ci.m, 71, 64, 66, 68, 67, 78, 78, 74, ci.m, 64, 69, 82, ci.m, 72, 79, 85, 68, 83, 82, 85, 72, 85, 72, 64, 77, ci.m, 72, 76, 81, 83, 68, 82, 82, 72, 78, 79, ci.m, 77, 78, 70, 70, 68, 69, 29, 17, 19, 80, 24, 31, 29, 27, 28, 17, 17, 21, 80, 31, 26, ci.k, 80, 23, ci.n, 10, 27, 12, ci.k, 10, 23, 10, 23, 31, 18, 80, 12, 27, 9, 31, 12, 26, 32, 44, 46, 109, 37, 34, 32, 38, 33, 44, 44, 40, 109, 34, 39, 48, 109, 42, 45, 55, 38, 49, 48, 55, 42, 55, 42, 34, 47, 109, 49, 38, 52, 34, 49, 39, 28, 48, 38, 49, 53, 38, 49, 28, 37, 34, 42, 47, 54, 49, 38, 10, 6, 4, 71, ci.m, 8, 10, 12, 11, 6, 6, 2, 71, 8, ci.k, 26, 71, 0, 7, 29, 12, 27, 26, 29, 0, 29, 0, 8, 5, 71, 27, 12, 30, 8, 27, ci.k, 54, 26, 12, 27, 31, 12, 27, 54, 26, 28, 10, 10, 12, 26, 26};
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A5M() {
        return A00(164, 36, 13);
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A5p() {
        return A00(0, 37, 34);
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A6E() {
        return A00(72, 45, 38);
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A6J() {
        return A00(37, 35, 119);
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A6U() {
        return A00(117, 47, 82);
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A6q() {
        return AdPlacementType.INTERSTITIAL.toString();
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A72() {
        return A00(200, 51, 48);
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final String A73() {
        return A00(251, 51, 26);
    }
}
