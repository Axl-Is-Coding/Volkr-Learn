package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AB {
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final F6 A04;
    public final boolean A05;
    public final boolean A06;

    public AB(F6 f6, long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.A04 = f6;
        this.A03 = j;
        this.A02 = j2;
        this.A00 = j3;
        this.A01 = j4;
        this.A06 = z;
        this.A05 = z2;
    }

    public final AB A00(int i) {
        return new AB(this.A04.A01(i), this.A03, this.A02, this.A00, this.A01, this.A06, this.A05);
    }

    public final AB A01(long j) {
        return new AB(this.A04, j, this.A02, this.A00, this.A01, this.A06, this.A05);
    }
}
