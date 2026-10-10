package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2139aF implements G6 {
    public final List<G5> A00;

    public C2139aF(List<G5> list) {
        this.A00 = Collections.unmodifiableList(list);
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
