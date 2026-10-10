package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class P5 extends KT {
    public static byte[] A02;
    public final /* synthetic */ C7v A00;
    public final /* synthetic */ C14247i A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-126, -75, -90, -90, -91, -78, -87, -82, -89, 96, -87, -82, -92, -91, -90, -87, -82, -87, -76, -91, -84, -71};
    }

    public P5(C7v c7v, C14247i c14247i) {
        this.A00 = c7v;
        this.A01 = c14247i;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (this.A00.A0A.getState() == EnumC1846Pb.A02 && this.A00.A0A.getCurrentPositionInMillis() == A00()) {
            this.A00.A0H(A00(0, 22, 11));
        }
    }
}
