package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F2 {
    public static byte[] A03;
    public static String[] A04;
    public CA A00;
    public final CC A01;
    public final CA[] A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 114);
            String[] strArr = A04;
            if (strArr[1].charAt(6) == strArr[3].charAt(6)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "mNEvNMISV2TsjErCZLDNSt4mIeKbSMWU";
            strArr2[2] = "pkwADRIgEHU8NI8rqtSVQew0tEayD06s";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{94, 87, 20, 24, 2, 27, 19, 87, 5, 18, 22, 19, 87, 3, 31, 18, 87, 4, 3, 5, 18, 22, 26, 89, 65, 96, 97, 106, 47, 96, 105, 47, 123, 103, 106, 47, 110, 121, 110, 102, 99, 110, 109, 99, 106, 47, 106, 119, 123, 125, 110, 108, 123, 96, 125, 124, 47, 39};
    }

    public static void A02() {
        A04 = new String[]{"bxXiKI", "1uDei3qzNnKNtNYr8Y2Djp0HGajvtEV5", "mOXymc7srnaPPj6rkYKERyI3NxuvjHfL", "eLJeQSRGsG8qXjpz5HdRmaYCfpHE06ps", "tIHnpnFG5Gy9TDLwgByCKCMlkPhTptnY", "feqrkYPgdz0GJjq4", "3AbGJoGZCQZs42EqNNbBdZ7jf", "CWkuEW"};
    }

    public F2(CA[] caArr, CC cc) {
        this.A02 = caArr;
        this.A01 = cc;
    }

    public final CA A03(CB cb, Uri uri) throws InterruptedException, IOException {
        CA ca = this.A00;
        if (ca != null) {
            return ca;
        }
        CA[] caArr = this.A02;
        int length = caArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            CA ca2 = caArr[i];
            try {
                if (ca2.ADa(cb)) {
                    this.A00 = ca2;
                    cb.ACt();
                    break;
                }
                continue;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                cb.ACt();
                throw th;
            }
            cb.ACt();
            i++;
        }
        CA ca3 = this.A00;
        if (A04[6].length() == 13) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[0] = "fQ5Ua6";
        strArr[7] = "HZXGBz";
        if (ca3 != null) {
            ca3.A7e(this.A01);
            return this.A00;
        }
        throw new C2121Zv(A00(24, 34, 125) + IW.A0S(this.A02) + A00(0, 24, 5), uri);
    }

    public final void A04() {
        if (this.A00 != null) {
            this.A00 = null;
        }
    }
}
