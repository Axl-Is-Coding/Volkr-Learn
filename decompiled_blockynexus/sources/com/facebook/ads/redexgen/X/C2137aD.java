package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2137aD implements G6 {
    public final GT A00;
    public final Map<String, GZ> A01;
    public final Map<String, GU> A02;
    public final long[] A03;

    public C2137aD(GT gt, Map<String, GZ> map, Map<String, GU> map2) {
        Map<String, GZ> mapEmptyMap;
        this.A00 = gt;
        this.A02 = map2;
        if (map != null) {
            mapEmptyMap = Collections.unmodifiableMap(map);
        } else {
            mapEmptyMap = Collections.emptyMap();
        }
        this.A01 = mapEmptyMap;
        this.A03 = gt.A0G();
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final List<G5> A5w(long j) {
        return this.A00.A0E(j, this.A01, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final long A6L(int i) {
        return this.A03[i];
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6M() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.X.G6
    public final int A6f(long j) {
        int iA0A = IW.A0A(this.A03, j, false, false);
        if (iA0A < this.A03.length) {
            return iA0A;
        }
        return -1;
    }
}
