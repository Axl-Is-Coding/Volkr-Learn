package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2207bN implements InterfaceC14166z {
    public static byte[] A03;
    public static String[] A04;
    public final /* synthetic */ RD A00;
    public final /* synthetic */ C2213bT A01;
    public final /* synthetic */ boolean A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-41, -14, -6, -3, -10, -11, -79, 5, 0, -79, -11, 0, 8, -1, -3, 0, -14, -11, -79, -14, -79, -2, -10, -11, -6, -14, -65};
    }

    public static void A02() {
        A04 = new String[]{"8KjqebZv60QJkTDxRMgw9", "thfRn5pDzJN70UFYfVIlaB6cN7Gudk2R", "C9BVpw9UV8RgNssPir2gScGxH", "7AiIJI7TwWfHsESFux14U5S4ACJbRhuU", "Q7zUSmRtSU1V7fItr4R7SI8x29M95mvp", "Azfz", "38Oiuq4LYjnMY2HJpsmmy", "sSYHnhmgAc6ueqp"};
    }

    public C2207bN(C2213bT c2213bT, RD rd, boolean z) {
        this.A01 = c2213bT;
        this.A00 = rd;
        this.A02 = z;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9P() {
        if (this.A01.A0W != null) {
            this.A01.A0W.A0W();
            this.A01.A0W = null;
        }
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String strA00 = A00(0, 27, 49);
        this.A01.A0Y.A0A().A2d(LP.A01(this.A01.A00), adErrorType.getErrorCode(), strA00);
        if (this.A01.A0F == null) {
            return;
        }
        this.A01.A0F.A9p(C1697Jd.A02(adErrorType, strA00));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A9W() {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.bT r1 = r4.A01
            com.facebook.ads.redexgen.X.RD r0 = r4.A00
            r1.A0W = r0
            boolean r0 = r4.A02
            if (r0 == 0) goto L39
            com.facebook.ads.redexgen.X.Ei r0 = com.facebook.ads.redexgen.X.C2213bT.A0F(r1)
            if (r0 == 0) goto L39
            com.facebook.ads.redexgen.X.bT r0 = r4.A01
            com.facebook.ads.redexgen.X.Ei r3 = com.facebook.ads.redexgen.X.C2213bT.A0F(r0)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2207bN.A04
            r0 = 4
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La7
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2207bN.A04
            java.lang.String r1 = "VPn7Tjnl2g2ZoGzxCsTNTuvzL6QbPFmz"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "YMqnQw7eyVGctn758ocTTHmAed4stf5y"
            r0 = 1
            r2[r0] = r1
            r3.A0J()
        L39:
            com.facebook.ads.redexgen.X.bT r0 = r4.A01
            com.facebook.ads.redexgen.X.bU r0 = com.facebook.ads.redexgen.X.C2213bT.A0L(r0)
            if (r0 == 0) goto L8d
            com.facebook.ads.redexgen.X.bT r3 = r4.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2207bN.A04
            r0 = 4
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L8e
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2207bN.A04
            java.lang.String r1 = "6qlMxmRDBvH4L6kOfkSoYm3n5"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "yt5qGGbrsd8TRcD"
            r0 = 7
            r2[r0] = r1
            com.facebook.ads.redexgen.X.JL r1 = com.facebook.ads.redexgen.X.C2213bT.A0H(r3)
            com.facebook.ads.redexgen.X.JL r0 = com.facebook.ads.redexgen.X.JL.A04
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L80
        L6f:
            com.facebook.ads.redexgen.X.bT r0 = r4.A01
            boolean r0 = com.facebook.ads.redexgen.X.C2213bT.A0t(r0)
            if (r0 != 0) goto L80
            com.facebook.ads.redexgen.X.bT r0 = r4.A01
            com.facebook.ads.redexgen.X.bU r0 = com.facebook.ads.redexgen.X.C2213bT.A0L(r0)
            r0.AAS()
        L80:
            boolean r0 = r4.A02
            if (r0 == 0) goto L8d
            com.facebook.ads.redexgen.X.bT r0 = r4.A01
            com.facebook.ads.redexgen.X.bU r0 = com.facebook.ads.redexgen.X.C2213bT.A0L(r0)
            r0.A94()
        L8d:
            return
        L8e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2207bN.A04
            java.lang.String r1 = "NqrZxTPTxSSE484geuNhnuVXrlMqLfJJ"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "nXt660y1rE1HMRNPODglVba6eKGAZLBD"
            r0 = 1
            r2[r0] = r1
            com.facebook.ads.redexgen.X.JL r1 = com.facebook.ads.redexgen.X.C2213bT.A0H(r3)
            com.facebook.ads.redexgen.X.JL r0 = com.facebook.ads.redexgen.X.JL.A04
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L80
            goto L6f
        La7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2207bN.A9W():void");
    }
}
