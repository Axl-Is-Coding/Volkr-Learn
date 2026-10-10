package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2097Yu implements DG {
    public static byte[] A0E;
    public static String[] A0F;
    public long A00;
    public long A01;
    public CM A02;
    public DK A03;
    public String A04;
    public boolean A05;
    public final DP A09;
    public final boolean A0B;
    public final boolean A0C;
    public final boolean[] A0D = new boolean[3];
    public final DM A08 = new DM(7, 128);
    public final DM A06 = new DM(8, 128);
    public final DM A07 = new DM(6, 128);
    public final IG A0A = new IG();

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0E = new byte[]{37, 58, 55, 54, 60, 124, 50, 37, 48};
    }

    public static void A02() {
        A0F = new String[]{"OaAtDjibDffMS", "aj2yyuicdEn8dhTDbWTrD1WtuleVGPEx", "a3NvGU2CXdpQvxvcysdReyA6yUgKGJjf", "4BBSavRiCGZis8TiCNo6nDJqjRzxnCkr", "3Isw3BGBXoN1VbjlJcagr5xDVNXHwLpI", "HfhncQp7sGaDAl", "zNtUp", "pzzsrx2QpEHePoyNV"};
    }

    public C2097Yu(DP dp, boolean z, boolean z2) {
        this.A09 = dp;
        this.A0B = z;
        this.A0C = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A03(long r25, int r27, int r28, long r29) {
        /*
            Method dump skipped, instruction units count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2097Yu.A03(long, int, int, long):void");
    }

    private void A04(long j, int i, long j2) {
        if (!this.A05 || this.A03.A08()) {
            this.A08.A02(i);
            this.A06.A02(i);
        }
        this.A07.A02(i);
        String[] strArr = A0F;
        if (strArr[4].charAt(8) != strArr[2].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[5] = "7DOfm1dA88ob89";
        strArr2[0] = "yqrgSqZS2XcB9";
        this.A03.A04(j, i, j2);
    }

    private void A05(byte[] bArr, int i, int i2) {
        if (!this.A05 || this.A03.A08()) {
            this.A08.A03(bArr, i, i2);
            this.A06.A03(bArr, i, i2);
        }
        this.A07.A03(bArr, i, i2);
        this.A03.A07(bArr, i, i2);
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A48(IG ig) {
        int iA07 = ig.A07();
        int iA08 = ig.A08();
        byte[] bArr = ig.A00;
        this.A01 += (long) ig.A05();
        this.A02.ACx(ig, ig.A05());
        while (true) {
            int iA04 = IC.A04(bArr, iA07, iA08, this.A0D);
            if (iA04 == iA08) {
                A05(bArr, iA07, iA08);
                return;
            }
            int iA01 = IC.A01(bArr, iA04);
            int nalUnitOffset = iA04 - iA07;
            if (nalUnitOffset > 0) {
                A05(bArr, iA07, iA04);
            }
            int i = iA08 - iA04;
            long j = this.A01 - ((long) i);
            int offset = nalUnitOffset < 0 ? -nalUnitOffset : 0;
            A03(j, i, offset, this.A00);
            A04(j, iA01, this.A00);
            iA07 = iA04 + 3;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A4U(CC cc, DU du) {
        du.A06();
        this.A04 = du.A05();
        this.A02 = cc.ADr(du.A04(), 2);
        this.A03 = new DK(this.A02, this.A0B, this.A0C);
        this.A09.A03(cc, du);
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABo() {
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void ABp(long j, boolean z) {
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void AD1() {
        IC.A0C(this.A0D);
        this.A08.A01();
        this.A06.A01();
        this.A07.A01();
        this.A03.A02();
        this.A01 = 0L;
    }
}
