package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2130a5 implements G8 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{62, 11, 11, 26, 18, ci.m, 11, 26, 27, 95, 11, ci.n, 95, 28, ci.k, 26, 30, 11, 26, 95, 27, 26, 28, ci.n, 27, 26, ci.k, 95, 25, ci.n, ci.k, 95, 10, 17, 12, 10, ci.m, ci.m, ci.n, ci.k, 11, 26, 27, 95, 25, ci.n, ci.k, 18, 30, 11, 113, 96, 96, 124, 121, 115, 113, 100, 121, 127, 126, Utf8.REPLACEMENT_BYTE, 115, 117, 113, 61, 38, 32, 40, 29, 12, 12, ci.n, 21, 31, 29, 8, 21, 19, 18, 83, 31, 25, 29, 81, 75, 76, 68, 103, 118, 118, 106, 111, 101, 103, 114, 111, 105, 104, 41, 98, 112, 100, 117, 115, 100, 117, 28, ci.k, ci.k, 17, 20, 30, 28, 9, 20, 18, 19, 82, ci.k, 26, ci.l, 81, 64, 64, 92, 89, 83, 81, 68, 89, 95, 94, 31, 68, 68, 93, 92, 27, 72, 93, 92, 33, 48, 48, 44, 41, 35, 33, 52, 41, 47, 46, 111, 56, 109, 45, 48, 116, 109, 35, 37, 33, 109, 118, 112, 120, Utf8.REPLACEMENT_BYTE, 46, 46, 50, 55, 61, Utf8.REPLACEMENT_BYTE, 42, 55, 49, 48, 113, 38, 115, 51, 46, 106, 115, 40, 42, 42, 123, 106, 106, 118, 115, 121, 123, 110, 115, 117, 116, 53, 98, 55, 107, 111, 115, 121, 113, 110, 115, 119, 127, 55, 110, 98, 41, 125, 4, 21, 21, 9, 12, 6, 4, 17, 12, 10, 11, 74, 29, 72, 22, ci.n, 7, 23, 12, 21, 99, 114, 111, 99, 56, 97, 99, 99, 70, 87, 74, 70, 29, 74, 31, 65, 65, 83};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0009  */
    @Override // com.facebook.ads.redexgen.X.G8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.InterfaceC2129a4 A4F(com.facebook.ads.internal.exoplayer2.Format r5) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2130a5.A4F(com.facebook.ads.internal.exoplayer2.Format):com.facebook.ads.redexgen.X.a4");
    }

    @Override // com.facebook.ads.redexgen.X.G8
    public final boolean ADm(Format format) {
        String str = format.A0O;
        return A00(236, 8, 112).equals(str) || A00(244, 10, 85).equals(str) || A00(122, 20, 87).equals(str) || A00(167, 21, 57).equals(str) || A00(216, 20, 2).equals(str) || A00(188, 28, 125).equals(str) || A00(50, 19, 119).equals(str) || A00(142, 25, 39).equals(str) || A00(69, 19, 27).equals(str) || A00(88, 19, 97).equals(str) || A00(107, 15, 26).equals(str);
    }
}
