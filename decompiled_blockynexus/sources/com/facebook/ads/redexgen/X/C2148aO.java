package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2148aO implements KZ {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {119, 115, 114, -90, -107, -102, -106, -97, -108, -106, 127, -106, -91, -88, -96, -93, -100, -42, -17, -20, -17, -16, -8, -17, -95, -26, -7, -28, -26, -15, -11, -22, -16, -17, -81};
        if (A01[5].length() != 4) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "MK2VCqgBd9SNnNeGly9LCo5Q0MZYLIwM";
        strArr[1] = "MK2VCqgBd9SNnNeGly9LCo5Q0MZYLIwM";
        A00 = bArr;
    }

    public static void A02() {
        A01 = new String[]{"8dTs7O5twSBYJQLkIxmvSEVrFVEvVCci", "69NA9D5Z6BuLX3eP6NdAfQAgnNKJrDbv", "acKGpr4PBH5WFf0tOIi0bMoNuU2uM3j", "PyBLhH8YgyLL4rtY0CuV5vjOqs5FO6aV", "QGo0VGIKP6OUkgre", "Fn5N", "qAtdKl9ehcjQMJLKj9xOFxL36VJ6lS2D", "CGei2tUyEESFCVHjI0JHW7BbjnmVvUdx"};
    }

    @Override // com.facebook.ads.redexgen.X.KZ
    public final void A87(int i, Throwable th) {
        Log.e(A00(0, 17, 10), A00(17, 18, 90), th);
    }
}
