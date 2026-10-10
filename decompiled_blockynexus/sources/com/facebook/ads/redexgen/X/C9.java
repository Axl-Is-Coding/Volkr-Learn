package com.facebook.ads.redexgen.X;

import android.util.Pair;
import java.util.Arrays;
import java.util.Map;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9 {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{30, 59, 49, 55, 60, 33, 55, 22, 39, 32, 51, 38, 59, 61, 60, 0, 55, Utf8.REPLACEMENT_BYTE, 51, 59, 60, 59, 60, 53, 7, 59, 54, 46, 53, 54, 52, 60, 19, 34, 37, 54, 35, 62, 56, 57, 5, 50, 58, 54, 62, 57, 62, 57, 48};
    }

    public static long A00(Map<String, String> keyStatus, String str) {
        if (keyStatus != null) {
            try {
                String value = keyStatus.get(str);
                if (value != null) {
                    return Long.parseLong(value);
                }
                return -9223372036854775807L;
            } catch (NumberFormatException unused) {
                return -9223372036854775807L;
            }
        }
        return -9223372036854775807L;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.facebook.ads.internal.exoplayer2.drm.DrmSession<?> */
    public static Pair<Long, Long> A01(InterfaceC1520Bt<?> interfaceC1520Bt) {
        Map<String, String> keyStatus = interfaceC1520Bt.ACC();
        if (keyStatus == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(A00(keyStatus, A02(0, 24, 28))), Long.valueOf(A00(keyStatus, A02(24, 25, 25))));
    }
}
