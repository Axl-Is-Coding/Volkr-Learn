package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Aq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1500Aq implements InterfaceC2114Zo, InterfaceC2113Zn {
    public static String[] A06;
    public long A00;
    public long A01;
    public long A02;
    public InterfaceC2113Zn A03;
    public C2104Zb[] A04 = new C2104Zb[0];
    public final InterfaceC2114Zo A05;

    static {
        A01();
    }

    public static void A01() {
        A06 = new String[]{"xZ98n6jXZ", "w0wM6S1AW5kwd8mBaLXb8IJFUPLi1ZSY", "", "5GeP1Ey0MjdLLaKEOlMigJbDmIHcG3Ps", "Q5WYazqpabUa99ZYxsI", "Gm0HQrfOciURdkrLDtJ", "cUS8ttxVNiquYZeS", "9hpvQN9G3pxye3p4YcQpNMMd2GK"};
    }

    public C1500Aq(InterfaceC2114Zo interfaceC2114Zo, boolean z, long j, long j2) {
        this.A05 = interfaceC2114Zo;
        this.A02 = z ? j : -9223372036854775807L;
        this.A01 = j;
        this.A00 = j2;
    }

    private AV A00(long j, AV av) {
        long jA0E = IW.A0E(av.A01, 0L, j - this.A01);
        long j2 = av.A00;
        long j3 = this.A00;
        long jA0E2 = IW.A0E(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        if (jA0E == av.A01 && jA0E2 == av.A00) {
            return av;
        }
        return new AV(jA0E, jA0E2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.FU
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A9X(InterfaceC2114Zo interfaceC2114Zo) {
        this.A03.A9X(this);
    }

    public static boolean A03(long j, InterfaceC1643Gy[] interfaceC1643GyArr) {
        if (j != 0) {
            for (InterfaceC1643Gy interfaceC1643Gy : interfaceC1643GyArr) {
                if (interfaceC1643Gy != null && !I9.A0A(interfaceC1643Gy.A70().A0O)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean A04() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final boolean A4A(long j) {
        return this.A05.A4A(j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void A4m(long j, boolean z) {
        this.A05.A4m(j, z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long A5Q(long j, AV av) {
        long j2 = this.A01;
        if (j == j2) {
            return j2;
        }
        return this.A05.A5Q(j, A00(j, av));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long A5f() {
        long jA5f = this.A05.A5f();
        if (jA5f != Long.MIN_VALUE) {
            long j = this.A00;
            if (j == Long.MIN_VALUE || jA5f < j) {
                return jA5f;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long A6g() {
        long jA6g = this.A05.A6g();
        if (jA6g != Long.MIN_VALUE) {
            long j = this.A00;
            if (j == Long.MIN_VALUE || jA6g < j) {
                return jA6g;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final TrackGroupArray A7G() {
        return this.A05.A7G();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void A8m() throws IOException {
        this.A05.A8m();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2113Zn
    public final void AAu(InterfaceC2114Zo interfaceC2114Zo) {
        this.A03.AAu(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void AC1(InterfaceC2113Zn interfaceC2113Zn, long j) {
        this.A03 = interfaceC2113Zn;
        this.A05.AC1(this, j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final long ACK() {
        if (A04()) {
            long j = this.A02;
            this.A02 = -9223372036854775807L;
            long jACK = ACK();
            return jACK != -9223372036854775807L ? jACK : j;
        }
        long jACK2 = this.A05.ACK();
        String[] strArr = A06;
        if (strArr[7].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[5] = "JN4lYhgdVtJugUzGLO1";
        strArr2[4] = "V7PIoeFvQi5pkabjQnk";
        if (jACK2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        C1662Hr.A04(jACK2 >= this.A01);
        long discontinuityUs = this.A00;
        if (discontinuityUs != Long.MIN_VALUE && jACK2 > discontinuityUs) {
            z = false;
        }
        C1662Hr.A04(z);
        return jACK2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    public final void ACS(long j) {
        this.A05.ACS(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long AD6(long r9) {
        /*
            r8 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.A02 = r0
            com.facebook.ads.redexgen.X.Zb[] r3 = r8.A04
            int r2 = r3.length
            r7 = 0
            r1 = 0
        Lc:
            if (r1 >= r2) goto L18
            r0 = r3[r1]
            if (r0 == 0) goto L15
            r0.A01()
        L15:
            int r1 = r1 + 1
            goto Lc
        L18:
            com.facebook.ads.redexgen.X.Zo r0 = r8.A05
            long r5 = r0.AD6(r9)
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L34
            long r1 = r8.A01
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 < 0) goto L35
            long r3 = r8.A00
            r1 = -9223372036854775808
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L34
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 > 0) goto L35
        L34:
            r7 = 1
        L35:
            com.facebook.ads.redexgen.X.C1662Hr.A04(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1500Aq.AD6(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC2114Zo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long AD7(com.facebook.ads.redexgen.X.InterfaceC1643Gy[] r16, boolean[] r17, com.facebook.ads.redexgen.X.FT[] r18, boolean[] r19, long r20) {
        /*
            r15 = this;
            r4 = r18
            int r0 = r4.length
            com.facebook.ads.redexgen.X.Zb[] r0 = new com.facebook.ads.redexgen.X.C2104Zb[r0]
            r15.A04 = r0
            int r0 = r4.length
            com.facebook.ads.redexgen.X.FT[] r11 = new com.facebook.ads.redexgen.X.FT[r0]
            r2 = 0
        Lb:
            int r0 = r4.length
            r3 = 0
            if (r2 >= r0) goto L24
            com.facebook.ads.redexgen.X.Zb[] r1 = r15.A04
            r0 = r4[r2]
            com.facebook.ads.redexgen.X.Zb r0 = (com.facebook.ads.redexgen.X.C2104Zb) r0
            r1[r2] = r0
            r0 = r1[r2]
            if (r0 == 0) goto L1f
            r0 = r1[r2]
            com.facebook.ads.redexgen.X.FT r3 = r0.A01
        L1f:
            r11[r2] = r3
            int r2 = r2 + 1
            goto Lb
        L24:
            com.facebook.ads.redexgen.X.Zo r8 = r15.A05
            r10 = r17
            r9 = r16
            r13 = r20
            r12 = r19
            long r7 = r8.AD7(r9, r10, r11, r12, r13)
            boolean r0 = r15.A04()
            if (r0 == 0) goto L92
            long r0 = r15.A01
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 != 0) goto L92
            boolean r0 = A03(r0, r9)
            if (r0 == 0) goto L92
            r0 = r7
        L45:
            r15.A02 = r0
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 == 0) goto L5d
            long r1 = r15.A01
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 < 0) goto L90
            long r1 = r15.A00
            r5 = -9223372036854775808
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 == 0) goto L5d
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 > 0) goto L90
        L5d:
            r0 = 1
        L5e:
            com.facebook.ads.redexgen.X.C1662Hr.A04(r0)
            r5 = 0
        L62:
            int r0 = r4.length
            if (r5 >= r0) goto L98
            r0 = r11[r5]
            if (r0 != 0) goto L76
            com.facebook.ads.redexgen.X.Zb[] r0 = r15.A04
            r0[r5] = r3
        L6d:
            com.facebook.ads.redexgen.X.Zb[] r0 = r15.A04
            r0 = r0[r5]
            r4[r5] = r0
            int r5 = r5 + 1
            goto L62
        L76:
            r0 = r4[r5]
            if (r0 == 0) goto L84
            com.facebook.ads.redexgen.X.Zb[] r0 = r15.A04
            r0 = r0[r5]
            com.facebook.ads.redexgen.X.FT r1 = r0.A01
            r0 = r11[r5]
            if (r1 == r0) goto L6d
        L84:
            com.facebook.ads.redexgen.X.Zb[] r2 = r15.A04
            com.facebook.ads.redexgen.X.Zb r1 = new com.facebook.ads.redexgen.X.Zb
            r0 = r11[r5]
            r1.<init>(r15, r0)
            r2[r5] = r1
            goto L6d
        L90:
            r0 = 0
            goto L5e
        L92:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L45
        L98:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1500Aq.AD7(com.facebook.ads.redexgen.X.Gy[], boolean[], com.facebook.ads.redexgen.X.FT[], boolean[], long):long");
    }
}
