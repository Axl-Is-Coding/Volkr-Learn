package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RG extends KT {
    public static byte[] A01;
    public final /* synthetic */ RH A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-20, -29, -8, -29, -11, -27, -12, -21, -14, -10, -68};
    }

    public RG(RH rh) {
        this.A00 = rh;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        this.A00.A02.A0A().AE5();
        this.A00.A04.loadUrl(A00(0, 11, 35) + this.A00.A00.A04());
    }
}
