package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZA implements CJ {
    public long A00;
    public long A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;

    public ZA(int i, int i2, int i3, int i4, int i5, int i6) {
        this.A06 = i;
        this.A07 = i2;
        this.A02 = i3;
        this.A04 = i4;
        this.A03 = i5;
        this.A05 = i6;
    }

    public final int A00() {
        return this.A07 * this.A03 * this.A06;
    }

    public final int A01() {
        return this.A04;
    }

    public final int A02() {
        return this.A05;
    }

    public final int A03() {
        return this.A06;
    }

    public final int A04() {
        return this.A07;
    }

    public final long A05(long j) {
        return (1000000 * Math.max(0L, j - this.A01)) / ((long) this.A02);
    }

    public final void A06(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public final boolean A07() {
        return (this.A01 == 0 || this.A00 == 0) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return (1000000 * (this.A00 / ((long) this.A04))) / ((long) this.A07);
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long j) {
        long j2 = (((long) this.A02) * j) / 1000000;
        int i = this.A04;
        long jA0E = IW.A0E((j2 / ((long) i)) * ((long) i), 0L, this.A00 - ((long) i));
        long j3 = this.A01 + jA0E;
        long seekTimeUs = A05(j3);
        CK ck = new CK(seekTimeUs, j3);
        if (seekTimeUs < j) {
            long j4 = this.A00;
            int i2 = this.A04;
            if (jA0E != j4 - ((long) i2)) {
                long j5 = ((long) i2) + j3;
                long seekPosition = A05(j5);
                return new CI(ck, new CK(seekPosition, j5));
            }
        }
        return new CI(ck);
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return true;
    }
}
