package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class T4 extends KG {
    public final /* synthetic */ T5 A00;

    public T4(T5 t5) {
        this.A00 = t5;
    }

    @Override // com.facebook.ads.redexgen.X.KG
    public final void A01() {
        if (this.A00.A01.A00.A02() == null) {
            return;
        }
        this.A00.A01.A00.A02().onAdsLoaded();
    }
}
