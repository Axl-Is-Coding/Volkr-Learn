package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LP {
    public static byte[] A00;
    public static String[] A01;

    @VisibleForTesting
    public static final LO A02 = null;

    static {
        A08();
        A07();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-76, -67, -62, -11, 84, 81, 85, 86, 87, -83, -53, -40, -111, -34, -118, -48, -39, -36, -41, -53, -34, -118, -34, -45, -41, -49, -104};
    }

    public static void A08() {
        A01 = new String[]{"XEo7ApDkixomJl", "UTo8fMhBtcAYVBkj97ZdrNE79DqyVdeE", "qjsfLXTzdQjFcrr1MQWDVCv1RezJVkpD", "uyyak5D0vLW0qS4el0H9V3NvWvs7WmEw", "dfkt", "aZ9WVO7oGzsQrfntNmAENBSB60kWMi8d", "vBzt6OuEytEA3fr2a70IMY3R4BM3PC0Z", "3Sjf17E3qVEfPkL5Ydo7ZoDPJxNqRPuV"};
    }

    public static long A00() {
        LO lo = A02;
        if (lo != null) {
            return lo.currentTimeMillis();
        }
        return System.currentTimeMillis();
    }

    public static long A01(long j) {
        if (j == -1) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArr = A01;
        if (strArr[1].charAt(28) != strArr[2].charAt(28)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[3] = "urCZ1k15svGSg9r6LMSBF5zX9epx6b4x";
        strArr2[3] = "urCZ1k15svGSg9r6LMSBF5zX9epx6b4x";
        return jCurrentTimeMillis - j;
    }

    public static String A02(double d2) {
        try {
            return String.format(Locale.US, A03(0, 4, 118), Double.valueOf(d2));
        } catch (Exception e2) {
            Log.e(LP.class.getSimpleName(), A03(9, 18, 81), e2);
            return A03(4, 5, 10);
        }
    }

    public static String A04(long j) {
        return String.valueOf(A01(j));
    }

    @Deprecated
    public static String A05(long j) {
        return A02(j / 1000.0d);
    }

    public static String A06(long j) {
        return Long.toString(j);
    }
}
