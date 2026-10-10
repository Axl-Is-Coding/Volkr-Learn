package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class T3 extends KG {
    public final /* synthetic */ T6 A00;
    public final /* synthetic */ C1697Jd A01;

    public T3(T6 t6, C1697Jd c1697Jd) {
        this.A00 = t6;
        this.A01 = c1697Jd;
    }

    @Override // com.facebook.ads.redexgen.X.KG
    public final void A01() {
        if (this.A00.A00.A02() != null) {
            this.A00.A00.A02().onAdError(C1697Jd.A00(this.A01));
        }
    }
}
