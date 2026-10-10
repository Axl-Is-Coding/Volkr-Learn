package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ki, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1726Ki implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C2026Wb A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{97, 122, 125, 98, 97, 99, 104, 99, 116, 111, 101};
    }

    public RunnableC1726Ki(C2026Wb c2026Wb) {
        this.A00 = c2026Wb;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            C8Z c8z = new C8Z(A00(0, 4, 88));
            c8z.A03(1);
            c8z.A04(1);
            c8z.A08(false);
            this.A00.A04().A8I(A00(4, 7, 112), C8Y.A1G, c8z);
        } catch (Throwable otsl) {
            KL.A00(otsl, this);
        }
    }
}
