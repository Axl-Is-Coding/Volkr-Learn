package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC13875v {
    A05(A00(21, 4, 26)),
    A04(A00(16, 5, 36)),
    A06(A00(25, 7, 53));

    public static byte[] A01;
    public static String[] A02;
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[2].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "yOKNzT6s9VzW4yFkLY6PsNahhjQJ505W";
            strArr2[1] = "q1cNaQJhP7NVWr6bUrjGcn2AVkCmliVi";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 80);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{0, ci.k, ci.k, 10, ci.k, -98, -93, -101, -92, -66, -88, -71, -75, -80, -75, -82, -39, -26, -26, -29, -26, -45, -40, -48, -39, -4, -26, -9, -13, -18, -13, -20};
    }

    public static void A02() {
        A02 = new String[]{"0RRWKfJdKrui2m4MHTFQsMJyHOf8C8w9", "8LZ64BEP3t8fC1ORxLDriZfpukd2eG7I", "CwE1gmU02QGgATNS", "IbR7bXcqKLpLj", "qam4zJzNIQZnne6rIhaeaYE3gj58AOpU", "Hd0V98lR5CAMSu3WjOLj94lF2tQwUAfl", "RGEAyvOYfNtgiUZah7VCMfRDLY5FaLk0", "3n2TsZ0kv6VM0Knc"};
    }

    static {
        A02();
        A01();
    }

    EnumC13875v(String str) {
        this.A00 = str;
    }

    public final String A03() {
        return this.A00;
    }
}
