package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0A {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{71};
    }

    private String A01(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        int iLastIndexOf2 = str.lastIndexOf(47);
        if (iLastIndexOf != -1 && iLastIndexOf > iLastIndexOf2 && iLastIndexOf + 2 + 4 > str.length()) {
            return str.substring(iLastIndexOf + 1, str.length());
        }
        return A00(0, 0, 13);
    }

    public final String A03(String str) {
        String strA01 = A01(str);
        String strA02 = C0I.A02(str);
        if (TextUtils.isEmpty(strA01)) {
            return strA02;
        }
        return strA02 + A00(0, 1, 41) + strA01;
    }
}
