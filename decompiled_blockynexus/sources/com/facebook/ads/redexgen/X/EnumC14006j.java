package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC14006j {
    A08(0),
    A06(1),
    A07(2),
    A05(3),
    A04(4);

    public static byte[] A01;
    public static String[] A02;
    public int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        if (A02[6].charAt(17) == 'X') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "pgudaYbRqTPjGMZ4ZZfMqbLkPBqXKu6s";
        strArr[4] = "pgudaYbRqTPjGMZ4ZZfMqbLkPBqXKu6s";
        A01 = new byte[]{-79, -78, -73, -62, -84, -80, -77, -81, -88, -80, -88, -79, -73, -88, -89, -42, -41, -36, -25, -37, -35, -40, -40, -41, -38, -36, -51, -52, 23, 24, 40, 25, ci.l, 27, 22, 18, 28, 28, 18, 24, 23, -70, -63, -72, -72, -67, -74, -77, -74, -73, -65, -74};
    }

    public static void A02() {
        A02 = new String[]{"hSeSDY0of3XMKYBSawTW6", "sohFiklnBFgr2LMW5unaYXIdoh7LpqJ4", "J1GkrQhOQSKZr22Vk671BdQ9PLpp91zg", "xQM0SIi3n9Poy2F", "WAUXlS76Mh78MuMCacZeL0Bf36KHKL6J", "Ow19vI2XbPOH", "viGaH6ErnKztM5tSpUcz87FTndzVVCSd", "WNqW8CjWCVSKFZCXl6PMQeKqqDuJb9Ju"};
    }

    static {
        A02();
        A01();
    }

    EnumC14006j(int i) {
        this.A00 = i;
    }

    public final int A03() {
        return this.A00;
    }
}
