package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2136aC implements G6 {
    public final long[] A00;
    public final G5[] A01;

    public C2136aC(G5[] g5Arr, long[] jArr) {
        this.A01 = g5Arr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final List<G5> A5w(long j) {
        int iA0B = IW.A0B(this.A00, j, true, false);
        if (iA0B != -1) {
            G5[] g5Arr = this.A01;
            if (g5Arr[iA0B] != null) {
                return Collections.singletonList(g5Arr[iA0B]);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final long A6L(int i) {
        boolean z = true;
        C1662Hr.A03(i >= 0);
        if (i >= this.A00.length) {
            z = false;
        }
        C1662Hr.A03(z);
        return this.A00[i];
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6M() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6f(long j) {
        int iA0A = IW.A0A(this.A00, j, false, false);
        if (iA0A < this.A00.length) {
            return iA0A;
        }
        return -1;
    }
}
