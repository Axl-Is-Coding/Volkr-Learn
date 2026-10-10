package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1756Lo {
    public static byte[] A00;
    public static final String A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{100, -105, -126, -124, -113, -109, -120, -114, -115, Utf8.REPLACEMENT_BYTE, -120, -115, Utf8.REPLACEMENT_BYTE, -110, -126, -111, -124, -124, -115, Utf8.REPLACEMENT_BYTE, -120, -115, -109, -124, -111, -128, -126, -109, -120, -107, -124, Utf8.REPLACEMENT_BYTE, -126, -121, -124, -126, -118, 75, Utf8.REPLACEMENT_BYTE, -128, -110, -110, -108, -116, -120, -115, -122, Utf8.REPLACEMENT_BYTE, -120, -115, -109, -124, -111, -128, -126, -109, -120, -107, -124, 77, -103, -104, -96, -114, -101, -46, -55, -45, -53, -39};
    }

    static {
        A01();
        A01 = C1756Lo.class.getSimpleName();
    }

    public static boolean A02(C2026Wb c2026Wb) {
        return A03(c2026Wb) && C1757Lp.A04(c2026Wb);
    }

    public static boolean A03(C2026Wb c2026Wb) {
        if (c2026Wb == null) {
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) c2026Wb.getSystemService(A00(60, 5, 18));
            if (Build.VERSION.SDK_INT >= 20) {
                return powerManager.isInteractive();
            }
            return powerManager.isScreenOn();
        } catch (Exception e2) {
            Log.e(A01, A00(0, 60, 8), e2);
            c2026Wb.A04().A8H(A00(65, 5, 73), C8Y.A25, new C8Z(e2));
            return true;
        }
    }
}
