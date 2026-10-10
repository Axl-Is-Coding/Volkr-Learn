package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DX {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{10, 76, 69, 88, 10, 94, 83, 90, 79, 10, 66, 89, 30, 22, ci.k, 67, 89, 84, 127, 98, 121, 124, 55, 126, 100, 55, 99, 120, 120, 55, 123, 118, 101, 112, 114, 55, Utf8.REPLACEMENT_BYTE, 105, 37, 80, 85, 60, 62, 55, 99, 120, 55, 100, 124, 126, 103, 44, 55, 126, 115, 45, 55, 84, 105, 97, 116, 114, 101, 116, 117, 49, 115, 125, 126, 114, 122, 49, 112, 125, 120, 118, 127, 124, 116, 127, 101, 43, 49, 92, 114, 123, 122, 103, 124, 123, 114, 53, 96, 123, 126, 123, 122, 98, 123, 53, 66, 84, 67, 53, 118, 125, 96, 123, 126, 47, 53, 108, 119, 120, 120, 119, 76, 81, 87, 82, 82, 77, 80, 86, 71, 70, 2, 112, 107, 100, 100, 2, 68, 77, 80, 79, 67, 86, 24, 2, 109, 86, 75, 77, 72, 72, 87, 74, 76, 93, 92, 24, 111, 121, 110, 24, 90, 81, 76, 24, 92, 93, 72, 76, 80, 24, 106, 81, 76, 74, 79, 79, 80, 77, 75, 90, 91, 31, 104, 126, 105, 31, 89, 80, 77, 82, 94, 75, 31, 75, 70, 79, 90, 5, 31, 5, 19, 4, 23, 24, 46, 57, 7, 42, 46, 43, 42, 61, 29, 42, 46, 43, 42, 61, 102, 99, 118, 99, 19, 24, 1, 85};
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x007a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.ZA A00(com.facebook.ads.redexgen.X.CB r19) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DX.A00(com.facebook.ads.redexgen.X.CB):com.facebook.ads.redexgen.X.ZA");
    }

    public static void A03(CB cb, ZA za) throws InterruptedException, IOException {
        C1662Hr.A01(cb);
        C1662Hr.A01(za);
        cb.ACt();
        IG ig = new IG(8);
        DW dwA00 = DW.A00(cb, ig);
        while (dwA00.A00 != IW.A08(A01(214, 4, 50))) {
            Log.w(A01(199, 15, 127), A01(83, 28, 37) + dwA00.A00);
            long bytesToSkip = dwA00.A01 + 8;
            if (dwA00.A00 == IW.A08(A01(111, 4, 14))) {
                bytesToSkip = 12;
            }
            if (bytesToSkip <= 2147483647L) {
                cb.ADZ((int) bytesToSkip);
                dwA00 = DW.A00(cb, ig);
            } else {
                throw new AD(A01(17, 40, 39) + dwA00.A00);
            }
        }
        cb.ADZ(8);
        za.A06(cb.A6t(), dwA00.A01);
    }
}
