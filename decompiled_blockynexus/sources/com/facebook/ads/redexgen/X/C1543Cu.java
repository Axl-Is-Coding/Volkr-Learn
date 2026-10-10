package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1543Cu {
    public static byte[] A00;
    public static String[] A01;
    public static final int[] A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 63);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{75, 31, 74, 25, 123, 47, 122, 42, 111, 59, 57, 106, 17, 69, 69, 20, 58, 110, 121, 26, 78, 91, 31, 10, 94, 74, ci.m, 125, 4, 113, ci.n, 69, 60, 94, 40, 54, 79, 45, 43, 101, 123, 102, 126, 80, 71, 82, 0, 116, 38, 100, 50, 70, 75, 88, 31, 88, 70, 83, 1, 102, 124, 96, 61, 20, ci.l, 18, 78, Utf8.REPLACEMENT_BYTE, 37, 57, 98, 112, 106, 118, 44, 94, 68, 88, 1, 83, 73, 85, 87, 60, 51, 51, 62, 111, 114, 54, 51, 18, ci.m, 75, 77, 112, 117, 33, 33};
        if (A01[3].charAt(26) != 'I') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "d1bTlggiE4vYEwLxNU00WUvkcSIuSb2g";
        strArr[3] = "d1bTlggiE4vYEwLxNU00WUvkcSIuSb2g";
    }

    public static void A02() {
        A01 = new String[]{"3vAPqkZTJ1VSon", "QUTM7SdDWyFumvZa4ixbAFeRkcyJbQtu", "xie3JnTyZ8PkMdNBWExCsKsV5Mn", "WzqQT7JP0s6wyXASN6VfDx7AAKIr1zQR", "8xy", "R913nsbqijjrVtiNLSpVoV0rL8armwI", "xGv", "6Jbm"};
    }

    static {
        A02();
        A01();
        A02 = new int[]{IW.A08(A00(79, 4, 5)), IW.A08(A00(59, 4, 48)), IW.A08(A00(63, 4, 66)), IW.A08(A00(67, 4, 105)), IW.A08(A00(71, 4, 38)), IW.A08(A00(75, 4, 8)), IW.A08(A00(43, 4, 14)), IW.A08(A00(55, 4, 15)), IW.A08(A00(51, 4, 17)), IW.A08(A00(87, 4, 61)), IW.A08(A00(91, 4, 64)), IW.A08(A00(0, 4, 71)), IW.A08(A00(4, 4, 119)), IW.A08(A00(19, 4, 22)), IW.A08(A00(23, 4, 6)), IW.A08(A00(8, 4, 99)), IW.A08(A00(12, 4, 29)), IW.A08(A00(31, 4, 55)), IW.A08(A00(27, 4, 15)), IW.A08(A00(47, 4, 45)), IW.A08(A00(83, 4, 104)), IW.A08(A00(35, 4, 68)), IW.A08(A00(95, 4, 62)), IW.A08(A00(39, 4, 23))};
    }

    public static boolean A03(int i) {
        if ((i >>> 8) == IW.A08(A00(16, 3, 54))) {
            return true;
        }
        int[] iArr = A02;
        String[] strArr = A01;
        if (strArr[6].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "EPRlEFMBD24k0biyd";
        strArr2[5] = "EPRlEFMBD24k0biyd";
        for (int compatibleBrand : iArr) {
            if (compatibleBrand == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean A04(CB cb) throws InterruptedException, IOException {
        return A06(cb, true);
    }

    public static boolean A05(CB cb) throws InterruptedException, IOException {
        return A06(cb, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A06(com.facebook.ads.redexgen.X.CB r17, boolean r18) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1543Cu.A06(com.facebook.ads.redexgen.X.CB, boolean):boolean");
    }
}
