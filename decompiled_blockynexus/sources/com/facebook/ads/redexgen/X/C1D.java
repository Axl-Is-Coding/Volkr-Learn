package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1D, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum C1D {
    A04(A01(23, 14, 75)),
    A05(A01(37, 9, 104));

    public static byte[] A01;
    public static String[] A02;
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] - i3;
            String[] strArr = A02;
            if (strArr[2].charAt(20) != strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "UwpbEbRNl9IMKeiJ6uSiSZky6ATbVFhh";
            strArr2[5] = "UwpbEbRNl9IMKeiJ6uSiSZky6ATbVFhh";
            bArrCopyOfRange[i4] = (byte) (i5 - 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-9, 3, 2, 8, -7, 12, 8, 9, -11, 0, 19, -11, 4, 4, -68, -83, -77, -79, -53, -68, -69, -65, -64, -8, 4, 3, 9, -6, ci.k, 9, 10, -10, 1, -12, -10, 5, 5, 34, 19, 25, 23, 17, 34, 33, 37, 38};
    }

    public static void A03() {
        A02 = new String[]{"v4tKPq3EceuOa5aRsmEiNo1tTprRM6C7", "qa", "1kYj9up9VehuFRcMC7DoHBWV3d6qFcAR", "n4EmHEljxnoAajVVWWaJOomXezwQRR5a", "Whp7rDnlG0MZIiYb9hz51Us4d", "ClcFd5qXD5uybBDL74sHW5rS4sS0N915", "9cSwTyNVqh919HIV87XGH350eC38CJiy", "s6hJEW9RZJJCohfrBHr3vXwOzcsb3wCa"};
    }

    static {
        A03();
        A02();
    }

    C1D(String str) {
        this.A00 = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C1D A00(java.lang.String r3) {
        /*
            int r1 = r3.hashCode()
            r0 = 883765328(0x34ad3050, float:3.2258913E-7)
            if (r1 == r0) goto L26
            r0 = 1434358835(0x557e9433, float:1.7494529E13)
            if (r1 == r0) goto L14
        Le:
            r0 = -1
        Lf:
            if (r0 == 0) goto L38
            com.facebook.ads.redexgen.X.1D r0 = com.facebook.ads.redexgen.X.C1D.A05
            return r0
        L14:
            r2 = 23
            r1 = 14
            r0 = 75
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Le
            r0 = 0
            goto Lf
        L26:
            r2 = 37
            r1 = 9
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Le
            r0 = 1
            goto Lf
        L38:
            com.facebook.ads.redexgen.X.1D r0 = com.facebook.ads.redexgen.X.C1D.A04
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1D.A00(java.lang.String):com.facebook.ads.redexgen.X.1D");
    }
}
