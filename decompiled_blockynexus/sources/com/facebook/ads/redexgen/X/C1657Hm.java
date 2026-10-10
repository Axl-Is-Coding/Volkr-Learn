package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1657Hm {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-40, -21, -30, -46, -33, -40, -31, -10, 9, 0, -16, 3, -10, -11, -6, 3};
    }

    public static long A00(InterfaceC1656Hl interfaceC1656Hl) {
        return interfaceC1656Hl.A5K(A02(0, 7, 27), -1L);
    }

    @Nullable
    public static Uri A01(InterfaceC1656Hl interfaceC1656Hl) {
        String strA5L = interfaceC1656Hl.A5L(A02(7, 9, 57), (String) null);
        if (strA5L == null) {
            return null;
        }
        return Uri.parse(strA5L);
    }

    public static void A04(C1658Hn c1658Hn) {
        c1658Hn.A02(A02(7, 9, 57));
    }

    public static void A05(C1658Hn c1658Hn, long j) {
        c1658Hn.A03(A02(0, 7, 27), j);
    }

    public static void A06(C1658Hn c1658Hn, Uri uri) {
        c1658Hn.A04(A02(7, 9, 57), uri.toString());
    }
}
