package com.facebook.ads.redexgen.X;

import android.util.Pair;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AZ {
    public static String[] A00;
    public static final AZ A01;

    public static void A00() {
        A00 = new String[]{"jU13W9NSebta1ZmimveRwiImSwvynw8G", "bR9yhpeYgYLfxjGn405sIF1CLUaNKRNv", "y6GS60dgSiOKDJGhj3wt9T6pcdF3KRzS", "kAdv6lw0fV2hZ8Ef8nLl5eDcrpXJ", "gDoO0sRHxUPo6SrSL989dqr7yWBZykVP", "xoqdGlgoaRmw7wZuwViSR5WxyeJjGGpo", "tn8QhSSQsmhaZqBgPW05rXLjjsf9pF2E", "LT5aPkpwV7"};
    }

    public abstract int A01();

    public abstract int A02();

    public abstract int A05(Object obj);

    public abstract AX A0B(int i, AX ax, boolean z);

    public abstract AY A0E(int i, AY ay, boolean z, long j);

    static {
        A00();
        A01 = new C2053Xc();
    }

    public int A03(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == A07(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            if (i == A07(z)) {
                return A06(z);
            }
            return i + 1;
        }
        throw new IllegalStateException();
    }

    public final int A04(int nextWindowIndex, AX ax, AY ay, int i, boolean z) {
        int i2 = A0A(nextWindowIndex, ax).A00;
        if (A0C(i2, ay).A01 == nextWindowIndex) {
            int iA03 = A03(i2, i, z);
            if (iA03 == -1) {
                return -1;
            }
            return A0C(iA03, ay).A00;
        }
        return nextWindowIndex + 1;
    }

    public int A06(boolean z) {
        return A0F() ? -1 : 0;
    }

    public int A07(boolean z) {
        if (A0F()) {
            return -1;
        }
        return A02() - 1;
    }

    public final Pair<Integer, Long> A08(AY ay, AX ax, int i, long j) {
        return A09(ay, ax, i, j, 0L);
    }

    public final Pair<Integer, Long> A09(AY ay, AX ax, int i, long j, long j2) {
        C1662Hr.A00(i, 0, A02());
        A0E(i, ay, false, j2);
        if (j == -9223372036854775807L) {
            j = ay.A01();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = ay.A00;
        long jA03 = ay.A03() + j;
        long jA07 = A0A(i2, ax).A07();
        while (jA07 != -9223372036854775807L) {
            if (A00[7].length() == 24) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[7] = "t4u2YUU8OEdoMFYJ2jQWzxX4wha";
            strArr[7] = "t4u2YUU8OEdoMFYJ2jQWzxX4wha";
            if (jA03 < jA07 || i2 >= ay.A01) {
                break;
            }
            jA03 -= jA07;
            i2++;
            jA07 = A0A(i2, ax).A07();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(jA03));
    }

    public final AX A0A(int i, AX ax) {
        return A0B(i, ax, false);
    }

    public final AY A0C(int i, AY ay) {
        return A0D(i, ay, false);
    }

    public final AY A0D(int i, AY ay, boolean z) {
        return A0E(i, ay, z, 0L);
    }

    public final boolean A0F() {
        return A02() == 0;
    }

    public final boolean A0G(int i, AX ax, AY ay, int i2, boolean z) {
        return A04(i, ax, ay, i2, z) == -1;
    }
}
