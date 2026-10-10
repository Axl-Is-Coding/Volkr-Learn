package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class bM extends AbstractC12520n {
    public static byte[] A01;
    public final /* synthetic */ C2213bT A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 109);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{23, 42, 61, 50, Utf8.REPLACEMENT_BYTE, 46, -23, 42, 45, 60, -23, 54, 42, 55, 42, 48, 46, 59, -23, 61, 49, 46, 50, 59, -23, 56, 64, 55, -23, 50, 54, 57, 59, 46, 60, 60, 50, 56, 55, 60, -9};
    }

    public bM(C2213bT c2213bT) {
        this.A00 = c2213bT;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0A(RD rd) {
        this.A00.A0e(rd, true);
        if (this.A00.A0F != null && rd.A0V() != null) {
            C2206bL c2206bL = new C2206bL(this);
            Iterator<C2213bT> it = rd.A0V().iterator();
            while (it.hasNext()) {
                it.next().A0f(c2206bL);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0B() {
        if (this.A00.A0F == null) {
            return;
        }
        this.A00.A0F.A91();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0C() {
        throw new IllegalStateException(A00(0, 41, 92));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0E(InterfaceC12510m interfaceC12510m) {
        if (this.A00.A09 == null) {
            return;
        }
        this.A00.A09.A0K();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0F(C1697Jd c1697Jd) {
        this.A00.A0x().A0A().A2d(LP.A01(this.A00.A00), c1697Jd.A04().getErrorCode(), c1697Jd.A05());
        if (this.A00.A0F == null) {
            return;
        }
        this.A00.A0F.A9p(c1697Jd);
    }
}
