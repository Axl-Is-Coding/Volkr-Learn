package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class K2 {
    public static Map<String, Long> A00;
    public static Map<String, Long> A01;
    public static Map<String, String> A02;

    @SuppressLint({"NotWrittenPrivateField"})
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{-35, 43, -14, -35, 43, -14, -35, 43, -14, -35, 28, -14, -35, 28, -14, -35, 28, -26, 25, 25, -19, -20, 24, 25, -20, 10, 0, 5, -2, -73, 3, -8, 10, 11, -73, -8, -5, -73, 9, -4, 10, 7, 6, 5, 10, -4, 5, 3, 18, -22, -1, 17, 18, -16, 3, 17, ci.l, ci.k, 12, 17, 3};
    }

    public static void A05() {
        A05 = new String[]{"WcKxqk7L6BbuUQ1o7qmtmX6WSmYBceUW", "BgR1wHMut0LLHWxcn1vNnqjOmnDpA7yk", "nofrFHfyJT7pmG0QketyEOeNZ4PDBNqx", "tJ6rTzDc1vJYhzSuFM6hiX1fKi0tAXSV", "zeDIr51bIn8XcOdXOM6dVjfvh9EOKJZZ", "x4ZdmXYSSnH60B6WOaypztUTceO04NF4", "XXJyOaEVU", "eLFDRkAKNxNhqN4Dib4JBju5Hz9f2MYZ"};
    }

    static {
        A05();
        A04();
        A01 = new ConcurrentHashMap();
        A00 = new ConcurrentHashMap();
        A02 = new ConcurrentHashMap();
        A03 = false;
    }

    public static long A00(String str, EnumC1700Jg enumC1700Jg) {
        if (A01.containsKey(str)) {
            return A01.get(str).longValue();
        }
        int i = K1.A00[enumC1700Jg.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? -1000L : -1000L;
        }
        if (A05[6].length() == 32) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[4] = "PcZmlfQcdFNZlzEkEhUxMjsAcGnkg3Oc";
        strArr[7] = "bp21WTLlcRSzBiFixYai9jfTwoum3UGv";
        return 15000L;
    }

    public static String A02(K3 k3) {
        C1710Jr.A05(A01(46, 15, 94), A01(24, 22, 87), A01(17, 7, 116));
        return A02.get(A03(k3));
    }

    public static String A03(K3 k3) {
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        objArr[0] = k3.A08();
        objArr[1] = k3.A05();
        objArr[2] = k3.A06();
        objArr[3] = Integer.valueOf(k3.A07() == null ? 0 : k3.A07().A00());
        objArr[4] = Integer.valueOf(k3.A07() != null ? k3.A07().A01() : 0);
        objArr[5] = Integer.valueOf(k3.A04());
        return String.format(locale, A01(0, 17, 120), objArr);
    }

    public static void A06(long j, K3 k3) {
        A01.put(A03(k3), Long.valueOf(j));
    }

    public static void A07(K3 k3) {
        A00.put(A03(k3), Long.valueOf(System.currentTimeMillis()));
    }

    public static void A08(String str, K3 k3) {
        A02.put(A03(k3), str);
    }

    public static boolean A09(K3 k3) {
        if (A03) {
            return false;
        }
        String strA03 = A03(k3);
        if (!A00.containsKey(strA03)) {
            return false;
        }
        Long l = A00.get(strA03);
        if (A05[3].charAt(17) != 'M') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[6] = "HNdF4hlEpt9Mz";
        strArr[6] = "HNdF4hlEpt9Mz";
        return System.currentTimeMillis() - l.longValue() < A00(strA03, k3.A05());
    }
}
