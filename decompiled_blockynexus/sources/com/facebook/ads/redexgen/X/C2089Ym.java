package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.sandboxol.center.config.VipSubscribeStatus;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ym, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2089Ym implements DG {
    public static String[] A0C;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public Format A05;
    public CM A06;
    public String A07;
    public boolean A08;
    public final IF A09;
    public final IG A0A;
    public final String A0B;

    static {
        A01();
    }

    public static void A01() {
        A0C = new String[]{"nJiMpwDCR7ZAmhQyp9AOHiC56UVcRx0k", "lCnqxh0y89Em7p481QheNATB6nErTPja", "EOgZonHCFyaPw1rQOdlgFposS9KMweND", "oVFhsCJtzutno5RzvIOwcHRYGNjJYB0M", VipSubscribeStatus.SUBSCRIPTION_PURCHASED, "S", "C7ZxqwSPJTae6vgKBRSPBAMVUD", "Gg5xSTo0LtnMpcaC7QBiBySoh1"};
    }

    public C2089Ym() {
        this(null);
    }

    public C2089Ym(String str) {
        this.A09 = new IF(new byte[128]);
        this.A0A = new IG(this.A09.A00);
        this.A02 = 0;
        this.A0B = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A00() {
        /*
            r13 = this;
            com.facebook.ads.redexgen.X.IF r1 = r13.A09
            r0 = 0
            r1.A08(r0)
            com.facebook.ads.redexgen.X.IF r0 = r13.A09
            com.facebook.ads.redexgen.X.Ah r1 = com.facebook.ads.redexgen.X.C1492Ai.A09(r0)
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            if (r0 == 0) goto L4c
            int r2 = r1.A00
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            int r0 = r0.A05
            if (r2 != r0) goto L4c
            int r4 = r1.A03
            com.facebook.ads.internal.exoplayer2.Format r5 = r13.A05
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C2089Ym.A0C
            r0 = 5
            r2 = r3[r0]
            r0 = 4
            r0 = r3[r0]
            int r2 = r2.length()
            int r0 = r0.length()
            if (r2 == r0) goto L34
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L34:
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C2089Ym.A0C
            java.lang.String r2 = "c77shWRMJ0xw1RnCUz3RaGOhMvVQh1Vq"
            r0 = 2
            r3[r0] = r2
            java.lang.String r2 = "c77shWRMJ0xw1RnCUz3RaGOhMvVQh1Vq"
            r0 = 2
            r3[r0] = r2
            int r0 = r5.A0C
            if (r4 != r0) goto L4c
            java.lang.String r2 = r1.A05
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            java.lang.String r0 = r0.A0O
            if (r2 == r0) goto L69
        L4c:
            java.lang.String r2 = r13.A07
            java.lang.String r3 = r1.A05
            r4 = 0
            r5 = -1
            r6 = -1
            int r7 = r1.A00
            int r8 = r1.A03
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r12 = r13.A0B
            com.facebook.ads.internal.exoplayer2.Format r0 = com.facebook.ads.internal.exoplayer2.Format.A07(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.A05 = r0
            com.facebook.ads.redexgen.X.CM r2 = r13.A06
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            r2.A5I(r0)
        L69:
            int r0 = r1.A01
            r13.A01 = r0
            r4 = 1000000(0xf4240, double:4.940656E-318)
            int r0 = r1.A02
            long r2 = (long) r0
            long r2 = r2 * r4
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            int r0 = r0.A0C
            long r0 = (long) r0
            long r2 = r2 / r0
            r13.A03 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2089Ym.A00():void");
    }

    private boolean A02(IG ig) {
        while (true) {
            if (ig.A05() <= 0) {
                return false;
            }
            if (!this.A08) {
                this.A08 = ig.A0F() == 11;
            } else {
                int iA0F = ig.A0F();
                if (iA0F == 119) {
                    this.A08 = false;
                    return true;
                }
                this.A08 = iA0F == 11;
            }
        }
    }

    private boolean A03(IG ig, byte[] bArr, int i) {
        int iMin = Math.min(ig.A05(), i - this.A00);
        ig.A0d(bArr, this.A00, iMin);
        this.A00 += iMin;
        return this.A00 == i;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) {
        while (ig.A05() > 0) {
            int i = this.A02;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(ig.A05(), this.A01 - this.A00);
                        this.A06.ACx(ig, iMin);
                        this.A00 += iMin;
                        int i2 = this.A00;
                        int i3 = this.A01;
                        if (i2 == i3) {
                            this.A06.ACy(this.A04, 1, i3, 0, null);
                            this.A04 += this.A03;
                            this.A02 = 0;
                        }
                    }
                } else if (A03(ig, this.A0A.A00, 128)) {
                    A00();
                    this.A0A.A0Z(0);
                    this.A06.ACx(this.A0A, 128);
                    this.A02 = 2;
                }
            } else if (A02(ig)) {
                this.A02 = 1;
                this.A0A.A00[0] = 11;
                this.A0A.A00[1] = 119;
                this.A00 = 2;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        du.A06();
        this.A07 = du.A05();
        this.A06 = cc.ADr(du.A04(), 1);
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABo() {
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABp(long j, boolean z) {
        this.A04 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void AD1() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
    }
}
