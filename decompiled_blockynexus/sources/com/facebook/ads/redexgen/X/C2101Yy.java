package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2101Yy implements DG {
    public static String[] A0C;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public CM A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public final CG A09;
    public final IG A0A;
    public final String A0B;

    static {
        A00();
    }

    public static void A00() {
        A0C = new String[]{"KDszHDzXfqF59CRVRWftd3HVsRnCigSQ", "mt1wJ32vNuSPyEC341LvOqJuOPF0PUkp", "WrM", "XaAyFYRGYfBBBZw7eK", "eDOzUgm8HT4q1AQmalgqs20fTFsFJUGd", "BoW68Cbgp4ULkXl8fLSwM62hHrGuEs23", "bWE7L7mx05VAedoWHIxzCG4hfzqVFa", "OpD2t2SPaq7VaFKSNzknI6aN9MYETC"};
    }

    public C2101Yy() {
        this(null);
    }

    public C2101Yy(String str) {
        this.A02 = 0;
        this.A0A = new IG(4);
        this.A0A.A00[0] = -1;
        this.A09 = new CG();
        this.A0B = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01(com.facebook.ads.redexgen.X.IG r11) {
        /*
            r10 = this;
            byte[] r5 = r11.A00
            int r4 = r11.A07()
            int r7 = r11.A08()
        La:
            if (r4 >= r7) goto L89
            r1 = r5[r4]
            r0 = 255(0xff, float:3.57E-43)
            r1 = r1 & r0
            r6 = 0
            r3 = 1
            if (r1 != r0) goto L87
            r9 = 1
        L16:
            boolean r0 = r10.A08
            if (r0 == 0) goto L47
            r8 = r5[r4]
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2101Yy.A0C
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L34
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L34:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2101Yy.A0C
            java.lang.String r1 = "UcL2wMN6HBGwWkWL4B"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "jB5"
            r0 = 2
            r2[r0] = r1
            r0 = 224(0xe0, float:3.14E-43)
            r8 = r8 & r0
            if (r8 != r0) goto L47
            r8 = 1
            goto L48
        L47:
            r8 = 0
        L48:
            r10.A08 = r9
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2101Yy.A0C
            r0 = 1
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 29
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L75
            if (r8 == 0) goto L84
        L60:
            int r0 = r4 + 1
            r11.A0Z(r0)
            r10.A08 = r6
            com.facebook.ads.redexgen.X.IG r0 = r10.A0A
            byte[] r1 = r0.A00
            r0 = r5[r4]
            r1[r3] = r0
            r0 = 2
            r10.A00 = r0
            r10.A02 = r3
            return
        L75:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2101Yy.A0C
            java.lang.String r1 = "AyJ6e7KDyRqb1r0P1KBKVEJakZlKMKHZ"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "2ThmXJimQn9uK6mMidfBhWUlfDYnBKkO"
            r0 = 0
            r2[r0] = r1
            if (r8 == 0) goto L84
            goto L60
        L84:
            int r4 = r4 + 1
            goto La
        L87:
            r9 = 0
            goto L16
        L89:
            r11.A0Z(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2101Yy.A01(com.facebook.ads.redexgen.X.IG):void");
    }

    private void A02(IG ig) {
        int iMin = Math.min(ig.A05(), this.A01 - this.A00);
        this.A05.ACx(ig, iMin);
        this.A00 += iMin;
        int i = this.A00;
        int i2 = this.A01;
        if (i < i2) {
            return;
        }
        this.A05.ACy(this.A04, 1, i2, 0, null);
        this.A04 += this.A03;
        this.A00 = 0;
        String[] strArr = A0C;
        if (strArr[5].charAt(10) == strArr[0].charAt(10)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[1] = "ScjCWzDsMvlE6C4iVMEuFqkFuKCicUAb";
        strArr2[4] = "udpHDrUjrNQxaJr25pS4UodeWrrvfUFS";
        this.A02 = 0;
    }

    private void A03(IG ig) {
        int iMin = Math.min(ig.A05(), 4 - this.A00);
        ig.A0d(this.A0A.A00, this.A00, iMin);
        this.A00 += iMin;
        if (this.A00 < 4) {
            return;
        }
        this.A0A.A0Z(0);
        if (CG.A05(this.A0A.A09(), this.A09)) {
            this.A01 = this.A09.A02;
            if (!this.A07) {
                this.A03 = (((long) this.A09.A04) * 1000000) / ((long) this.A09.A03);
                this.A05.A5I(Format.A07(this.A06, this.A09.A06, null, -1, 4096, this.A09.A01, this.A09.A03, null, null, 0, this.A0B));
                this.A07 = true;
            }
            this.A0A.A0Z(0);
            this.A05.ACx(this.A0A, 4);
            this.A02 = 2;
            return;
        }
        this.A00 = 0;
        this.A02 = 1;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) {
        while (ig.A05() > 0) {
            int i = this.A02;
            if (i == 0) {
                A01(ig);
            } else if (i != 1) {
                String[] strArr = A0C;
                if (strArr[1].charAt(29) != strArr[4].charAt(29)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0C;
                strArr2[1] = "DlgSkZ7kUmj97mVCMXW7YS18xBC70U7G";
                strArr2[4] = "tybkSaN9ICkxBJ48s31m7V5Ixzqz2U6M";
                if (i == 2) {
                    A02(ig);
                }
            } else {
                A03(ig);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        du.A06();
        this.A06 = du.A05();
        this.A05 = cc.ADr(du.A04(), 1);
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
