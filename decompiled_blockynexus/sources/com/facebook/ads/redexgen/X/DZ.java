package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class DZ extends AbstractC1696Jb {
    public final /* synthetic */ AnonymousClass55 A00;

    public DZ(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A04(C1703Jk c1703Jk) {
        if (this.A00.A08 != null) {
            C2213bT.A0J(this.A00.A08.getInternalNativeAd()).A1U(true, true);
        }
        this.A00.A00.onPlayed();
    }
}
