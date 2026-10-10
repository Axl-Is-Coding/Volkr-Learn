package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2H {
    public static final int[] A00 = new int[0];
    public static final long[] A01 = new long[0];
    public static final Object[] A02 = new Object[0];

    public static int A00(int i) {
        return A01(i * 8) / 8;
    }

    public static int A01(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    public static int A02(int[] iArr, int i, int mid) {
        int midVal = 0;
        int i2 = i - 1;
        while (midVal <= i2) {
            int i3 = (midVal + i2) >>> 1;
            int i4 = iArr[i3];
            if (i4 < mid) {
                midVal = i3 + 1;
            } else if (i4 > mid) {
                i2 = i3 - 1;
            } else {
                return i3;
            }
        }
        return midVal ^ (-1);
    }

    public static int A03(long[] jArr, int i, long j) {
        int i2 = 0;
        int i3 = i - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i2 = i4 + 1;
            } else if (j2 > j) {
                i3 = i4 - 1;
            } else {
                return i4;
            }
        }
        return i2 ^ (-1);
    }

    public static boolean A04(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
