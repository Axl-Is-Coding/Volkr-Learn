package com.facebook.ads.redexgen.X;

import android.os.Build;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum C6I {
    A04(1),
    A08(4),
    A0A(2),
    A07(Build.VERSION.SDK_INT >= 19 ? 20 : -1),
    A0B(0),
    A0C(8),
    A0E(Build.VERSION.SDK_INT >= 19 ? 18 : -1),
    A09(5),
    A06(6),
    A05(13),
    A0D(12);

    public static byte[] A01;
    public static String[] A02;
    public int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
            String[] strArr = A02;
            if (strArr[0].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "Nmo5M96rPCfUDrZsYva5XI4ZsWtaAuQf";
            strArr2[3] = "Nmo5M96rPCfUDrZsYva5XI4ZsWtaAuQf";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-57, -55, -55, -53, -46, -53, -40, -43, -45, -53, -38, -53, -40, -27, -39, -53, -44, -39, -43, -40, -66, -54, -65, -58, -62, -53, -47, -36, -47, -62, -54, -51, -62, -49, -66, -47, -46, -49, -62, -36, -48, -62, -53, -48, -52, -49, -52, -53, -36, -39, -41, -49, -34, -49, -36, -23, -35, -49, -40, -35, -39, -36, 18, ci.n, 26, 24, 12, 18, 25, ci.n, 31, 20, ci.l, 42, 29, 26, 31, 12, 31, 20, 26, 25, 42, 30, ci.n, 25, 30, 26, 29, 44, 62, 55, 52, 56, 40, 52, 53, 42, 68, 56, 42, 51, 56, 52, 55, ci.k, 10, 8, 9, 21, 32, 20, 6, ci.m, 20, ci.n, 19, -53, -65, -59, -52, -61, -46, -51, -53, -61, -46, -61, -48, -35, -47, -61, -52, -47, -51, -48, 70, 73, 64, 60, 69, 75, 56, 75, 64, 70, 69, 86, 74, 60, 69, 74, 70, 73, -17, -15, -18, -9, -24, -20, -24, -13, -8, -2, -14, -28, -19, -14, -18, -15, 54, 41, 48, 37, 56, 45, 58, 41, 67, 44, 57, 49, 45, 40, 45, 56, 61, 67, 55, 41, 50, 55, 51, 54, 6, 7, -8, 3, 18, -9, -8, 7, -8, -10, 7, 2, 5, 18, 6, -8, 1, 6, 2, 5};
    }

    public static void A02() {
        A02 = new String[]{"Q9z0ZbrjVYihKEpPZo", "nHeBQw", "ufhBztUadH", "XQstpsz58GIAm7RXEZkDYWBkGRBRqqVa", "vkoIrw2eH1SjUMjyxylQQX8SriJ39jtP", "twWVBvXll74W3M8pa6", "XnmvrLeMI93IRtZgUGg2fGmgShQWmbLW", "5DNdaWhzklLDGcFmvcoxBU5JueDBtSej"};
    }

    static {
        A02();
        A01();
    }

    C6I(int i) {
        this.A00 = i;
    }

    public final int A03() {
        return this.A00;
    }
}
