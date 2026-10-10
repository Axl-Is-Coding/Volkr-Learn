package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1694Iz {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{123, 126, 116, 109, 69, 123, 116, 126, 104, 117, 115, 126, 69, 123, 118, 118, 117, 109, 69, 115, 123, 120, 69, 121, 117, 116, 110, 127, 98, 110, 69, 109, 104, 123, 106, 106, 127, 104, 69, 121, 104, 127, 123, 110, 115, 117, 116, 100, 97, 107, 114, 90, 100, 107, 97, 119, 106, 108, 97, 90, 96, 107, 100, 103, 105, 96, 90, 108, 107, 90, 100, 117, 117, 90, 103, 119, 106, 114, 118, 96, 119, 90, 99, 108, 105, 96, 90, 102, 109, 106, 106, 118, 96, 119, 119, 114, 120, 97, 73, 119, 120, 114, 100, 121, 127, 114, 73, 115, 120, 119, 116, 122, 115, 73, 127, 120, 73, 119, 102, 102, 73, 116, 100, 121, 97, 101, 115, 100, 73, 120, 119, 96, 127, 113, 119, 98, 127, 121, 120, 101, 96, 106, 115, 91, 101, 106, 96, 118, 107, 109, 96, 91, 109, 101, 102, 91, 109, 105, 116, 118, 107, 114, 97, 91, 102, 118, 107, 115, 119, 109, 106, 99, 91, 103, 101, 116, 101, 102, 109, 104, 109, 112, 109, 97, 119, 76, 73, 67, 90, 114, 72, 67, 76, 79, 65, 72, 114, 68, 76, 79};
    }

    public static boolean A02(Context context) {
        return C1693Iy.A0M(context).A1q(A00(0, 47, 108), true);
    }

    public static boolean A03(Context context) {
        return C1693Iy.A0M(context).A1q(A00(47, 47, 115), false);
    }

    public static boolean A04(Context context) {
        return C1693Iy.A0M(context).A1q(A00(139, 46, 114), false);
    }

    public static boolean A05(Context context) {
        return Build.VERSION.SDK_INT >= 19 && C1693Iy.A0M(context).A1q(A00(185, 15, 91), false);
    }

    public static boolean A06(Context context) {
        return C1693Iy.A0M(context).A1q(A00(94, 45, 96), false);
    }
}
