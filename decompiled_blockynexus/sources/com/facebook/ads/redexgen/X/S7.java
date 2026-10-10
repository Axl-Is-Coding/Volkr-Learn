package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class S7<T> implements C2P<T> {
    public static byte[] A02;
    public static String[] A03;
    public int A00;
    public final Object[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = bArrCopyOfRange[i4];
            String[] strArr = A03;
            if (strArr[4].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "P1E265Ge3cQ";
            strArr2[5] = "P1E265Ge3cQ";
            bArrCopyOfRange[i4] = (byte) ((b2 ^ i3) ^ 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{44, 1, 31, 8, 12, 9, 20, 77, 4, 3, 77, 25, 5, 8, 77, 29, 2, 2, 1, 76, 76, 112, 125, 56, 117, 121, 96, 56, 104, 119, 119, 116, 56, 107, 113, 98, 125, 56, 117, 109, 107, 108, 56, 122, 125, 56, 38, 56, 40};
    }

    public static void A02() {
        A03 = new String[]{"pRcBA4OWefysSNzvRxIkpBVTVwfc3AVE", "RPn4qv0f1UarsEXGS1XogTnrbpEJEmnV", "xmsaI0t9E", "ZcBN", "DIlRoYRb", "oKMZSswBXiC", "UEhtJ1eDnORTZ2wzgc9obnj9WqOhgFHK", "4xQT2X5Ea9Pr"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S7 != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    public S7(int i) {
        if (i > 0) {
            this.A01 = new Object[i];
            return;
        }
        throw new IllegalArgumentException(A00(20, 29, 114));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S7 != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    private boolean A03(T t) {
        for (int i = 0; i < this.A00; i++) {
            Object obj = this.A01[i];
            String[] strArr = A03;
            if (strArr[2].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[4] = "IsiBXNP8";
            strArr2[7] = "yZIlFrLQCuaZ";
            if (obj == t) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S7 != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    @Override // com.facebook.ads.redexgen.X.C2P
    public T A2P() {
        int i = this.A00;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.A01;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.A00 = i - 1;
        return t;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S7 != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    @Override // com.facebook.ads.redexgen.X.C2P
    public boolean ACZ(T t) {
        if (!A03(t)) {
            int i = this.A00;
            Object[] objArr = this.A01;
            if (i < objArr.length) {
                objArr[i] = t;
                this.A00 = i + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException(A00(0, 20, 7));
    }
}
