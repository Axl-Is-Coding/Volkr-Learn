package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class TL extends KT {
    public static byte[] A03;
    public final /* synthetic */ C13825q A00;
    public final /* synthetic */ C2027Wc A01;
    public final /* synthetic */ String A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{53, 55, 60, 55, 32, 59, 49};
    }

    public TL(C13825q c13825q, String str, C2027Wc c2027Wc) {
        this.A00 = c13825q;
        this.A02 = str;
        this.A01 = c2027Wc;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        try {
            this.A00.A07(this.A02);
        } catch (Throwable th) {
            this.A01.A04().A8H(A00(0, 7, 2), C8Y.A10, new C8Z(th));
        }
    }
}
