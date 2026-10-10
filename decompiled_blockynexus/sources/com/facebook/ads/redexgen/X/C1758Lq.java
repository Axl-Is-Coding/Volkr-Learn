package com.facebook.ads.redexgen.X;

import android.app.Activity;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1758Lq {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[4].length() == 15) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "rGVas5AoEaq3cBsrCvDeMYMBThCVzhB5";
            strArr[5] = "o0fRmV5yhDY9KCH9v50URkZ7Eg4hKean";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 117);
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{43, 41, 50, 41, 54, 45, 39};
    }

    public static void A02() {
        A01 = new String[]{"hdV441LwjlNtZv1709qxF0pnny4fVUPp", "ei12BejVo1CHpgyzoQPUfc", "Ngx5CnSLKehr5gInaBo3fbR58cj0cWuD", "KjX1pG4Uk1LfU8Dcrr9VX", "a0G5nH", "Lj0Juqqdj67gjngfjpTqdTQ77lTPdRGa", "RNVdSSMaTLUgDkR28FbRvDpDNW12NXcx", "b5BIPohyMmnUdzrQJ3rYHZFdjlu3USou"};
    }

    public static void A03(Activity activity, int i, C2026Wb c2026Wb) {
        try {
            activity.setRequestedOrientation(i);
        } catch (IllegalStateException e2) {
            c2026Wb.A04().A8X(A00(0, 7, 79), C8Y.A08, new C8Z(e2));
        }
    }
}
