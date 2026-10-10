package com.facebook.ads.redexgen.X;

import com.facebook.ads.VideoAutoplayBehavior;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum JV {
    A03,
    A05,
    A04;

    public static byte[] A00;
    public static String[] A01;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-57, -56, -55, -60, -40, -49, -41, -11, -20, -20, 22, 21};
    }

    public static void A03() {
        A01 = new String[]{"Gjwy6cOcQ9K2s9TECvKSb1UBI6p92tWs", "MkJKTqDYMAzsSL3ogCclj8aQMOEn3Zaf", "eTpSOjZOB", "ux", "6lFNHDDwy35cZQ5ctUwn46ZPa5FkYtAF", "2ZxEJa2ax0wS4G", "Utm", "f4eG1TG9uZ10lRPR3hza"};
    }

    static {
        A03();
        A02();
    }

    public static VideoAutoplayBehavior A00(JV jv) {
        if (jv == null) {
            return VideoAutoplayBehavior.DEFAULT;
        }
        int i = JU.A00[jv.ordinal()];
        if (i == 1) {
            return VideoAutoplayBehavior.DEFAULT;
        }
        if (A01[1].charAt(9) == 'M') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "KWBYg9gUO";
        strArr[5] = "KWBYg9gUO";
        if (i == 2) {
            return VideoAutoplayBehavior.ON;
        }
        if (i != 3) {
            VideoAutoplayBehavior videoAutoplayBehavior = VideoAutoplayBehavior.DEFAULT;
            String[] strArr2 = A01;
            if (strArr2[0].charAt(5) != strArr2[4].charAt(5)) {
                String[] strArr3 = A01;
                strArr3[0] = "jNXTJSXFaHaCK7i5lqJo4GmnkgAhCocQ";
                strArr3[4] = "apiAoBnIaWOp8nG5E1dZaMbzfZqR1u59";
                return videoAutoplayBehavior;
            }
            String[] strArr4 = A01;
            strArr4[2] = "D4DDJWMfk";
            strArr4[2] = "D4DDJWMfk";
            return videoAutoplayBehavior;
        }
        return VideoAutoplayBehavior.OFF;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static JV[] valuesCustom() {
        JV[] jvArrValuesCustom = values();
        if (A01[1].charAt(9) == 'M') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "qrA";
        strArr[3] = "mB";
        return (JV[]) jvArrValuesCustom.clone();
    }
}
