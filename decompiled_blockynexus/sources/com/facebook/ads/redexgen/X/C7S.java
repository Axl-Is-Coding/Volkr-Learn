package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C7S extends I2 {
    public final /* synthetic */ HK A00;

    public C7S(HK hk) {
        this.A00 = hk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A04(I5 i5) {
        if (this.A00.A01 == null || i5.A00().getAction() != 0) {
            return;
        }
        this.A00.A04.removeCallbacksAndMessages(null);
        this.A00.A08(new C1844Oz(this));
    }
}
