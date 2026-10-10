package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0f, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12440f {
    public static byte[] A00;
    public static final String A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 80, 73, 85, 84, 26, 94, 91, 78, 91, 26, 83, 84, 26, 123, 94, 123, 89, 78, 83, 85, 84, 124, 91, 89, 78, 85, 72, 67, 20, 19, 22, 3, 22, 82, 77, 88, 83, 98, 81, 84, 83, 86, 94, 79, 92, 93, 71, 64, 73, 98, 115, 97, 97, 102, 122, 96, 125, 103, 117, 122, 24, 31, 4, 25, ci.l, 34, 61, 48, 49, 59, 11, 33, 38, 56};
    }

    static {
        A03();
        A01 = C12440f.class.getSimpleName();
    }

    @Nullable
    public static AbstractC12430e A00(C2026Wb c2026Wb, J5 j5, String str, Uri uri, Map<String, String> extraData) {
        return A01(c2026Wb, j5, str, uri, extraData, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.AbstractC12430e A01(com.facebook.ads.redexgen.X.C2026Wb r14, com.facebook.ads.redexgen.X.J5 r15, java.lang.String r16, android.net.Uri r17, java.util.Map<java.lang.String, java.lang.String> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C12440f.A01(com.facebook.ads.redexgen.X.Wb, com.facebook.ads.redexgen.X.J5, java.lang.String, android.net.Uri, java.util.Map, boolean, boolean):com.facebook.ads.redexgen.X.0e");
    }

    public static boolean A04(String str) {
        return A02(76, 5, 74).equalsIgnoreCase(str) || A02(49, 9, 28).equalsIgnoreCase(str);
    }
}
