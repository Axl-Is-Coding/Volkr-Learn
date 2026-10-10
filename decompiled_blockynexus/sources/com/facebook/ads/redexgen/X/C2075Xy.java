package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2075Xy extends KT {
    public static byte[] A01;
    public final /* synthetic */ C2071Xu A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-29, -10, -15, -14, -4, -83, 4, -18, 0, -83, -5, -14, 3, -14, -1, -83, -3, -1, -14, -3, -18, -1, -14, -15};
    }

    public C2075Xy(C2071Xu c2071Xu) {
        this.A00 = c2071Xu;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (!this.A00.A0G) {
            this.A00.A0e(A00(0, 24, 64));
        }
    }
}
