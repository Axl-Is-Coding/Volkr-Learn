package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.81, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum AnonymousClass81 {
    A04,
    A05,
    A0J,
    A0C,
    A0E,
    A06,
    A0B,
    A08,
    A0M,
    A0F,
    A0G,
    A03,
    A07,
    A09,
    A0K,
    A0N,
    A0I,
    A0A,
    A0H,
    A0L,
    A0D;

    public static byte[] A00;
    public static String[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].charAt(11) == strArr[7].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "W4gBMubxKiZM5LLivtLPs396PBqN8ReM";
            strArr2[0] = "lPif8zo0BCGymIa9nsJJXRn9Vdfcrwfz";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 99);
            i4++;
        }
    }

    public static void A01() {
        byte[] bArr = {103, 116, 116, 103, 127, 20, 25, 25, 26, 19, 23, 24, 64, 91, 86, 71, 122, 113, 120, 107, 84, 85, 83, 92, 81, 66, 85, 84, 48, 59, 33, 54, 56, 49, 21, 2, 2, 31, 2, ci.m, 18, ci.m, 9, 31, 30, 11, 8, 6, ci.m, 73, 67, 64, 78, 91, 11, 12, 22, 100, 99, 121, 104, 127, 126, 104, 110, 121, 100, 98, 99, 102, 101, 100, 109, 78, 79, 78, 69, 84, 79, 86, 86, 95, 68, 88, 85, 66, 28, ci.k, ci.m, 7, ci.k, 11, 9, 55, 44, 43, 54, 48, 20, 25, ci.n, 5, 22, 1, 18, 97, 122, 125, 123, 122, 64, 89, 95, 82, 90, 68, 65, 73, 78, 76, 95, 73};
        String[] strArr = A01;
        if (strArr[4].charAt(5) == strArr[0].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "Uq";
        strArr2[6] = "Uq";
        A00 = bArr;
    }

    public static void A02() {
        A01 = new String[]{"SXlbL1CY1HnlFue4Epuvc3q4430g41ka", "Q7EHaqXEYxiQEOiIyqjopxzkHRhZVKtw", "xNF", "uYQgnyI7xn5N5GOR4jmA1ry4yxIflSMQ", "rwtSlkdLuH5KaJR0oY6wYi8G8Rc4X5Yb", "KhrHqa8env5LHobs7dTfjp4HGZPf1i5f", "07o3NElFbIdfTqORF47AUY47", "YWtiaLPvBkX5SyS9ALyLBNGqlxgBLMMn"};
    }

    static {
        A02();
        A01();
    }
}
