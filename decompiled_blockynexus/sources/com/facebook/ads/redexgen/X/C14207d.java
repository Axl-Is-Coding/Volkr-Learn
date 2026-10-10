package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C14207d extends I2 {
    public final /* synthetic */ HY A00;

    public C14207d(HY hy) {
        this.A00 = hy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A04(I5 i5) {
        if (this.A00.A01 == null || this.A00.A03 || i5.A00().getAction() != 0) {
            return;
        }
        this.A00.A05.removeCallbacksAndMessages(null);
        if (this.A00.A0E(PA.A05)) {
            this.A00.A03();
            this.A00.A07(true, false);
        }
        if (this.A00.A02) {
            this.A00.A05.postDelayed(new C1647Hc(this), this.A00.A00);
        }
    }
}
