package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class FG extends R0<C0Q> {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 53);
            String[] strArr = A01;
            if (strArr[6].charAt(28) == strArr[4].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "RdAktgh8TRx4T7uGZoOvXD5Nm8OQ26SP";
            strArr2[4] = "NAulEfMGB5fp7nDMqJdUUmABB5JXpKUM";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{17, 10, 19, 19};
    }

    public static void A02() {
        A01 = new String[]{"jR7SgdIzlKHk76CXDj7yskV4BbEyGCpu", "dz14xHNKN2eKa", "osoaj0nOm4U0DksUsx9ydi6yveTqdDmo", "CW4NBbEoC8f", "oKML8tkCm175rZI2zBYjmvrxKy9flX2h", "0JuTJ32H1trbcwgA0tUu0T5MtnfghwR4", "xx3SSYxbJNPIpDYr1BHpXDm7lAtLM5T8", "wtTCE0DbZnhIRkOUKlXj85m9jjBjTzDL"};
    }

    public FG(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.X.R0
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final C0W A06(@Nullable C0Q c0q) {
        String strA00;
        if (c0q == null) {
            strA00 = A00(0, 4, 74);
        } else {
            strA00 = A00(0, 0, 56) + c0q.A03();
        }
        C0W c0w = new C0W(this, strA00);
        if (A01[7].length() == 29) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "ciTvicHW32i";
        strArr[1] = "sW1NMqe52ANNy";
        return c0w;
    }
}
