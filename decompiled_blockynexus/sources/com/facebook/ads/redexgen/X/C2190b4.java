package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2190b4 extends KT {
    public final /* synthetic */ C2191b5 A00;

    public C2190b4(C2191b5 c2191b5) {
        this.A00 = c2191b5;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        this.A00.A0C = false;
        if (!this.A00.A0B.getQueue().isEmpty()) {
            return;
        }
        this.A00.A0B.execute(this.A00.A0A);
    }
}
