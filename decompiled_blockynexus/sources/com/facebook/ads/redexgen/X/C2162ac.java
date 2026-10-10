package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ac, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2162ac extends HL {
    public static byte[] A01;
    public static String[] A02;
    public final String A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 63);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{ci.k, 42, 50, 37, 40, 45, 32, 100, 39, 43, 42, 48, 33, 42, 48, 100, 48, 61, 52, 33, 126, 100};
        if (A02[2].charAt(21) == 'I') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "yWaeILMTRyNjMdlGgdEDrDI";
        strArr[0] = "cj1077EILRdS6ZzLpoMmpdb";
    }

    public static void A02() {
        A02 = new String[]{"ZQ8PuEpoE8gyS3Znd74chKs", "SMR6jCgSs1OLi9k", "9TpefdXfhJ1bgovOujDvo0cycPvHTNeY", "fSCcvv9mQcAxaPQjtTD5J0fX4AU6qoUi", "pC4MzMAjE35JrXvA7GEGwLl", "N4W5wz59KJRM86L2MxAv0qAi54qP6RPf", "ZjburCSFctaP2yxaKgKjejXQTrv5uqRP", "7nU1e349RKnqDnE0EBs6XskGT5MTKO6z"};
    }

    public C2162ac(String str, HG hg) {
        super(A00(0, 22, 123) + str, hg, 1);
        this.A00 = str;
    }
}
