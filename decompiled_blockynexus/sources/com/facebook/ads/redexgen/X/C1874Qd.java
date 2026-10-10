package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1874Qd implements OD {
    public static byte[] A01;
    public final /* synthetic */ C1872Qb A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-43, -56, -60, -42, -79, -60, -64, -61, -40, -77, -50, -78, -57, -50, -42, -121, -122, -124, -46, -122, -120, -102};
    }

    public C1874Qd(C1872Qb c1872Qb) {
        this.A00 = c1872Qb;
    }

    @Override // com.facebook.ads.redexgen.X.OD
    public final void AAC() {
        this.A00.A0A.A03(JB.A0M, null);
        this.A00.A08.A0A().A4s();
        C1872Qb c1872Qb = this.A00;
        c1872Qb.A0I(new O7(A00(0, 22, 72), new String[]{c1872Qb.A0J}, null));
    }
}
