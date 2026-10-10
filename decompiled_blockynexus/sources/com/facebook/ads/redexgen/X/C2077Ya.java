package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2077Ya implements CJ {
    public final /* synthetic */ C2078Yb A00;

    public C2077Ya(C2078Yb c2078Yb) {
        this.A00 = c2078Yb;
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final long A6C() {
        return this.A00.A0B.A04(this.A00.A07);
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final CI A6z(long j) {
        if (j == 0) {
            return new CI(new CK(0L, this.A00.A09));
        }
        long jA05 = this.A00.A0B.A05(j);
        C2078Yb c2078Yb = this.A00;
        return new CI(new CK(j, c2078Yb.A00(c2078Yb.A09, jA05, com.tendcloud.tenddata.ab.R)));
    }

    @Override // com.facebook.ads.redexgen.X.CJ
    public final boolean A80() {
        return true;
    }
}
