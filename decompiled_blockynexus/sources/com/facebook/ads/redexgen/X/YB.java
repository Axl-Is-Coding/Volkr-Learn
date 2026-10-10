package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YB implements CJ {
    public final long A00;
    public final CI A01;

    public YB(long j) {
        this(j, 0L);
    }

    public YB(long j, long j2) {
        this.A00 = j;
        this.A01 = new CI(j2 == 0 ? CK.A04 : new CK(0L, j2));
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long j) {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return false;
    }
}
