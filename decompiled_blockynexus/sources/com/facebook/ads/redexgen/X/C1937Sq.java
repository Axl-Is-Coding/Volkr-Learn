package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1937Sq extends KG {
    public final /* synthetic */ C1939Ss A00;

    public C1937Sq(C1939Ss c1939Ss) {
        this.A00 = c1939Ss;
    }

    @Override // com.facebook.ads.redexgen.X.KG
    public final void A01() {
        if (this.A00.A01.A07() == null) {
            return;
        }
        this.A00.A01.A07().onAdClicked(this.A00.A01.A08());
    }
}
