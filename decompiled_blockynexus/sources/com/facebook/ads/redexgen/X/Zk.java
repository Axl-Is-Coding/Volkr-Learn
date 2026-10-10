package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Zk implements FT {
    public final int A00;
    public final /* synthetic */ C1499Ap A01;

    public Zk(C1499Ap c1499Ap, int i) {
        this.A01 = c1499Ap;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final boolean A7w() {
        return this.A01.A0T(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final void A8l() throws IOException {
        this.A01.A0R();
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final int ACJ(A7 a7, C2067Xq c2067Xq, boolean z) {
        return this.A01.A0Q(this.A00, a7, c2067Xq, z);
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final int ADY(long j) {
        return this.A01.A0P(this.A00, j);
    }
}
