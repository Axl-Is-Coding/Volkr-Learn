package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Bl extends Exception {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 119);
            if (A01[6].charAt(20) != 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "o3d2o9ikgoxA5z1";
            strArr[3] = "o3d2o9ikgoxA5z1";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-15, 9, 8, ci.k, 5, -60, 8, 19, 9, 23, -60, 18, 19, 24, -60, 23, 25, 20, 20, 19, 22, 24, -60, 25, 25, ci.k, 8, -34, -60};
    }

    public static void A02() {
        A01 = new String[]{"jybu9AmlZPNYJFO5CETURgZbL9", "roja0bhL1B9gUBQhWiTEX", "WMiIg6bDBi41NZoApBFo0", "", "oT4iuMPk3LT2VVBhdE9cDO7Myr", "ruzB4PX8Fu4D5Uvu", "vAhBirgpsYGDvsbxec1VAyH2PJeSZTTh", "yf8hg5uJFg3VA494hRWQ5mGXrAA"};
    }

    public Bl(UUID uuid) {
        super(A00(0, 29, 45) + uuid);
    }
}
