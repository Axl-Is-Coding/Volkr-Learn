package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class Y4 extends KT {
    public static byte[] A01;
    public final /* synthetic */ C2071Xu A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{100, 91, 86, 87, 93, 18, 92, 87, 68, 87, 64, 18, 65, 70, 83, 64, 70, 87, 86, 18, 66, 94, 83, 75, 91, 92, 85};
    }

    public Y4(C2071Xu c2071Xu) {
        this.A00 = c2071Xu;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (!this.A00.A0J) {
            this.A00.A0e(A00(0, 27, 112));
        }
    }
}
