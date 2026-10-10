package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.So, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1935So extends KG {
    public final /* synthetic */ C1939Ss A00;
    public final /* synthetic */ C1697Jd A01;

    public C1935So(C1939Ss c1939Ss, C1697Jd c1697Jd) {
        this.A00 = c1939Ss;
        this.A01 = c1697Jd;
    }

    @Override // com.facebook.ads.redexgen.X.KG
    public final void A01() {
        if (this.A00.A01.A07() == null) {
            return;
        }
        this.A00.A01.A07().onError(this.A00.A01.A08(), C1697Jd.A00(this.A01));
    }
}
