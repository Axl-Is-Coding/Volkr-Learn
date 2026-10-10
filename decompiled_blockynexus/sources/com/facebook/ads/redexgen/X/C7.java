package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7 implements YP {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final long A04;

    public C7(long j, long j2, CG cg) {
        this.A04 = j2;
        this.A01 = cg.A02;
        this.A00 = cg.A00;
        if (j == -1) {
            this.A02 = -1L;
            this.A03 = -9223372036854775807L;
        } else {
            this.A02 = j - j2;
            this.A03 = A7D(j);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long positionOffset) {
        long j = this.A02;
        if (j == -1) {
            return new CI(new CK(0L, this.A04));
        }
        long j2 = (((long) this.A00) * positionOffset) / 8000000;
        int i = this.A01;
        long jA0E = IW.A0E((j2 / ((long) i)) * ((long) i), 0L, j - ((long) i));
        long j3 = this.A04 + jA0E;
        long jA7D = A7D(j3);
        CK seekPoint = new CK(jA7D, j3);
        if (jA7D < positionOffset) {
            long j4 = this.A02;
            int i2 = this.A01;
            if (jA0E != j4 - ((long) i2)) {
                long secondSeekTimeUs = ((long) i2) + j3;
                return new CI(seekPoint, new CK(A7D(secondSeekTimeUs), secondSeekTimeUs));
            }
        }
        return new CI(seekPoint);
    }

    @Override // com.facebook.ads.redexgen.X.YP
    public final long A7D(long j) {
        return ((Math.max(0L, j - this.A04) * 1000000) * 8) / ((long) this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return this.A02 != -1;
    }
}
