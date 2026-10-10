package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum C5R {
    A04(A01(16, 5, 50)),
    A06(A01(27, 5, 29)),
    A05(A01(21, 6, 93));

    public static byte[] A01;
    public static String[] A02;
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[3].charAt(7) != 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[4] = "tSWii36WTWypzTcQeixtwPDDv3BIvAiF";
            strArr[4] = "tSWii36WTWypzTcQeixtwPDDv3BIvAiF";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 119);
            i4++;
        }
    }

    public static void A02() {
        A01 = new byte[]{-51, -47, -59, -53, -55, 11, -1, ci.n, 9, 19, ci.l, 25, 12, 7, 8, 18, 18, 22, 10, ci.n, ci.l, 65, 53, 70, Utf8.REPLACEMENT_BYTE, 73, 68, 10, -3, -8, -7, 3};
    }

    public static void A03() {
        A02 = new String[]{"k9IbPcfog7a2vud71ZD1yiSptuKC", "7LgXLJxVBX0dpNGH2cpdo2FqGbwHr2dh", "LRipwKypnEKMqg6PamR7G8YuQckBwe", "JMyIsM6N3mQ5xBBSQQoIEfTakpln9APf", "n5EonvV2d0ynVphuWIfrU3PhJk0DBM6W", "TLMtZWSWcMyBHKhNGVy3rrDPFywR", "JEnYl3ig6b1G3QZnd7pVPdvbWtuLiuax", "SOFQxOre1ZQqrgpFIrPfi6IMKTKD0s"};
    }

    static {
        A03();
        A02();
    }

    C5R(String str) {
        this.A00 = str;
    }

    @Nullable
    public static C5R A00(@Nullable String str) {
        for (C5R c5r : values()) {
            if (c5r.A00.equals(str)) {
                return c5r;
            }
        }
        return null;
    }
}
