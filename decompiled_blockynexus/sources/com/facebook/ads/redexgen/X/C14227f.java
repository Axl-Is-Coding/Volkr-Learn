package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7f, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C14227f extends AbstractC1696Jb {
    public final /* synthetic */ HY A00;

    public C14227f(HY hy) {
        this.A00 = hy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A04(C1703Jk c1703Jk) {
        if (!this.A00.A03 || !this.A00.A02) {
            return;
        }
        this.A00.A03 = false;
        if (!this.A00.A0E(PA.A04) && !this.A00.A04) {
            if (!this.A00.A0E(PA.A03)) {
                return;
            }
            this.A00.A03();
            this.A00.A07(true, true);
            return;
        }
        this.A00.A04 = false;
        this.A00.A05.postDelayed(new C1649He(this), this.A00.A00);
    }
}
