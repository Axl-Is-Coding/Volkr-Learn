package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2216bW {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
            String[] strArr = A01;
            if (strArr[1].charAt(18) == strArr[2].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "X228u0Qr";
            strArr2[4] = "X228u0Qr";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-69, -67, -50, -61, -48, -61, -50, -45, -71, -55, -68, -60, -65, -67, -50, -71, -61, -66, -43, -40, -45, -32, -35, -25, -24, -39, -30, -39, -26, -45, -25, -39, -24, -26, -23, -28, -8, -18, -1, -22, 4, 2, ci.k, ci.k, 0, 10, 8, ci.m, ci.n, 19, 6, 5, -52, -39, -39, -42, -39, -58, -54, -42, -53, -52, -25, -12, -12, -15, -12, -31, -17, -25, -11, -11, -29, -23, -25, 19, 38, 17, 19, 30, 34, 23, 29, 28, ci.n, 9, 27, 7, 10, 17, 12, -70, -77, -59, -79, -75, -63, -64, -58, -60, -63, -66, -66, -73, -60, -88, -95, -77, -97, -84, -87, -77, -76, -91, -82, -91, -78, -25, -32, -14, -34, -10, -28, -31, -11, -24, -28, -10, -50, -58, -57, -60, -55, -50, -40, -58, -57, -47, -54, -55, -60, -57, -34, -60, -52, -48, -68, -73, -29, -19, -39, -29, -24, -16, -37, -26, -29, -34, -37, -18, -33, -34, 7, 17, -3, ci.l, 19, 0, 10, 7, 1, -67, -64, -78, -75, -80, -59, -70, -66, -74, -80, -66, -60, -59, -56, -70, -67, -62, -57, -64, -72, -70, -67, -70, -55, -51, -66, -53, -43, -51, -52, -47, -55, -36, -47, -41, -42, -57, -41, -34, -51, -38, -44, -55, -31, -57, -37, -51, -36, -88, -96, -82, -82, -100, -94, -96, 6, 2, -9, -7, -5, 3, -5, 4, 10, -11, -1, -6, 35, 31, 20, 22, 24, 32, 24, 33, 39, 18, 39, 44, 35, 24, -84, -97, -101, -83, -87, -88, -72, -85, -73, -69, -85, -71, -70, -91, -81, -86, -2, -13, -6, 2, -22, -3, -16, -2, 0, -9, -1, -57, -65, -67, -60, -77, -58, -71, -75, -57, -61, -62, 35, -24, -37, -41, -23, -47, -26, -21, -30, -41, ci.m, 2, 12, 2, -5, 2, 5, 2, ci.k, 18};
    }

    public static void A02() {
        A01 = new String[]{"gK21opX6pdVXzizTr5B569byzifByDT1", "VXUYBRMamhge5PldHXwCUhQsvqUwyGaK", "A9eN1weHgCPL1SkQ3ZXjYtrHuOy08x6Y", "MZbjV39kBt4hAqLFGwVFLXlTEV84r4gZ", "MdBS2JQ6", "f1VlKL6T46QLbXXjKJzzCBeajzTILabi", "uaXBHv2Fpyp6t9CjlnIdC1IJtF0IP5s0", "SVJaljzXeB5Am8n"};
    }
}
