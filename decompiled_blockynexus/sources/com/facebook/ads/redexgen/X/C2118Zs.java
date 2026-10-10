package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2118Zs extends AZ {
    public static String[] A09;
    public static final Object A0A;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;

    @Nullable
    public final Object A06;
    public final boolean A07;
    public final boolean A08;

    public static void A00() {
        A09 = new String[]{"LiVpibqpJatuLGaZNpcVvLbqNHldnUzA", "bX5xO856XIcJE12GDRsOqh2", "ZVG", "hIvfEeguXT", "OzXlbx4H0xP2XpsF07euT", "fU7LOfxMrEgavyMWFPaWlv5y0089z6Uh", "tbzCzUNP5mUbYRUDq8rztMXXiQr3Ary2", "G8Ws4pPS3koy2aZpOP3X3qbhHPqHsp6i"};
    }

    static {
        A00();
        A0A = new Object();
    }

    public C2118Zs(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2, @Nullable Object obj) {
        this.A01 = j;
        this.A05 = j2;
        this.A00 = j3;
        this.A03 = j4;
        this.A04 = j5;
        this.A02 = j6;
        this.A08 = z;
        this.A07 = z2;
        this.A06 = obj;
    }

    public C2118Zs(long j, long j2, long j3, long j4, boolean z, boolean z2, @Nullable Object obj) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, obj);
    }

    public C2118Zs(long j, boolean z, boolean z2, @Nullable Object obj) {
        this(j, j, 0L, 0L, z, z2, obj);
    }

    @Override // com.facebook.ads.redexgen.X.AZ
    public final int A01() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.AZ
    public final int A02() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.AZ
    public final int A05(Object obj) {
        return A0A.equals(obj) ? 0 : -1;
    }

    @Override // com.facebook.ads.redexgen.X.AZ
    public final AX A0B(int i, AX ax, boolean z) {
        C1662Hr.A00(i, 0, 1);
        return ax.A0B(null, z ? A0A : null, 0, this.A00, -this.A04);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    @Override // com.facebook.ads.redexgen.X.AZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.AY A0E(int r22, com.facebook.ads.redexgen.X.AY r23, boolean r24, long r25) {
        /*
            r21 = this;
            r0 = r21
            r2 = 0
            r1 = 1
            r3 = r22
            com.facebook.ads.redexgen.X.C1662Hr.A00(r3, r2, r1)
            if (r24 == 0) goto L86
            java.lang.Object r6 = r0.A06
        Ld:
            long r13 = r0.A02
            boolean r4 = r0.A07
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2118Zs.A09
            r1 = 1
            r1 = r2[r1]
            int r2 = r1.length()
            r1 = 20
            if (r2 == r1) goto L88
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C2118Zs.A09
            java.lang.String r2 = "fKWrusBplbW"
            r1 = 1
            r3[r1] = r2
            java.lang.String r2 = "fKWrusBplbW"
            r1 = 1
            r3[r1] = r2
            if (r4 == 0) goto L42
            r2 = 0
            int r1 = (r25 > r2 ? 1 : (r25 == r2 ? 0 : -1))
            if (r1 == 0) goto L42
            long r2 = r0.A03
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 != 0) goto L5c
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L42:
            long r7 = r0.A01
            long r9 = r0.A05
            boolean r11 = r0.A08
            boolean r12 = r0.A07
            long r2 = r0.A03
            r17 = 0
            r18 = 0
            long r0 = r0.A04
            r5 = r23
            r15 = r2
            r19 = r0
            com.facebook.ads.redexgen.X.AY r0 = r5.A04(r6, r7, r9, r11, r12, r13, r15, r17, r18, r19)
            return r0
        L5c:
            long r13 = r13 + r25
            java.lang.String[] r4 = com.facebook.ads.redexgen.X.C2118Zs.A09
            r1 = 3
            r1 = r4[r1]
            int r4 = r1.length()
            r1 = 10
            if (r4 == r1) goto L75
            int r1 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r1 <= 0) goto L42
        L6f:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L42
        L75:
            java.lang.String[] r5 = com.facebook.ads.redexgen.X.C2118Zs.A09
            java.lang.String r4 = "wVi"
            r1 = 2
            r5[r1] = r4
            java.lang.String r4 = "2OdzkdLKms985VAdE1FhN"
            r1 = 4
            r5[r1] = r4
            int r1 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r1 <= 0) goto L42
            goto L6f
        L86:
            r6 = 0
            goto Ld
        L88:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2118Zs.A0E(int, com.facebook.ads.redexgen.X.AY, boolean, long):com.facebook.ads.redexgen.X.AY");
    }
}
