package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC12640z {
    A04(A00(37, 9, 87)),
    A06(A00(65, 9, 105)),
    A05(A00(46, 19, 116));

    public static byte[] A01;
    public static String[] A02;
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{99, 116, 99, 107, 110, 99, 96, 110, 103, 125, 124, 108, 125, 114, 103, 122, 101, 118, 108, 114, 119, 108, 127, 114, 106, 124, 102, 103, 105, 114, 114, 98, 110, 112, 124, 113, 113, 0, 23, 0, 8, ci.k, 0, 3, ci.k, 4, 44, 45, 29, 44, 35, 54, 43, 52, 39, 29, 35, 38, 29, 46, 35, 59, 45, 55, 54, 43, 48, 48, 0, 44, 50, 62, 51, 51};
        if (A02[3].charAt(28) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[6] = "yw";
        strArr[6] = "yw";
    }

    public static void A02() {
        A02 = new String[]{"YotGzB", "vsIS7NXYgiAbF4rLaahac", "Gskj2bStDtfNdzDdRe0hP24NDR2IpNEh", "oK8ItqR6UoxvIOFM7x85SOaiyNHULhPY", "o1G33SUpx5mnfpgWjDd1nYNG2RlEgzpj", "XWwbNlOGXItiEE2sGKxxfB9q5lH48KSv", "87nuLIKIZqBBcXVSFSOV", "vURZxB8V7SUFjdRy9aiCBcJV1"};
    }

    static {
        A02();
        A01();
    }

    EnumC12640z(String str) {
        this.A00 = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.A00;
    }
}
