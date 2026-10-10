package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class KM extends C9A<C14247i> {
    public final /* synthetic */ C7m A00;

    public KM(C7m c7m) {
        this.A00 = c7m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A04(C14247i c14247i) {
        int iA00 = c14247i.A00();
        if (this.A00.A00 > 0 && iA00 == this.A00.A0B.getDuration() && this.A00.A0B.getDuration() > this.A00.A00) {
            return;
        }
        this.A00.A0d(iA00);
    }

    @Override // com.facebook.ads.redexgen.X.C9A
    public final Class<C14247i> A01() {
        return C14247i.class;
    }
}
