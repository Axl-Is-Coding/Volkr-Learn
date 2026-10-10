package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2138aE implements G6 {
    public static final C2138aE A01 = new C2138aE();
    public final List<G5> A00;

    public C2138aE() {
        this.A00 = Collections.emptyList();
    }

    public C2138aE(G5 g5) {
        this.A00 = Collections.singletonList(g5);
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final List<G5> A5w(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final long A6L(int i) {
        C1662Hr.A03(i == 0);
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6M() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6f(long j) {
        return j < 0 ? 0 : -1;
    }
}
