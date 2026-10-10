package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RZ extends KT {
    public static byte[] A01;
    public final /* synthetic */ AbstractC1898Rb A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 34);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-113, -98, -105};
    }

    public RZ(AbstractC1898Rb abstractC1898Rb) {
        this.A00 = abstractC1898Rb;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        try {
            this.A00.A09();
        } catch (Exception e2) {
            this.A00.A0C.A04().A8H(A00(0, 3, 12), C8Y.A0I, new C8Z(e2));
        }
    }
}
