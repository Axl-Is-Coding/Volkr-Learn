package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2076Xz extends AbstractC1848Pd {
    public final /* synthetic */ C2071Xu A00;

    public C2076Xz(C2071Xu c2071Xu) {
        this.A00 = c2071Xu;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1848Pd
    public final void A04() {
        if (!this.A00.A0V.A08()) {
            this.A00.A0V.A06();
            if (!TextUtils.isEmpty(this.A00.A0P.A0Q())) {
                this.A00.A0S.A8M(this.A00.A0P.A0Q(), new NQ().A04(this.A00.A0f).A03(this.A00.A0V).A05(this.A00.A0P.A0S()).A06());
                this.A00.A0R.A0A().A2a();
            }
            if (this.A00.A05 != null) {
                this.A00.A05.A3s(EnumC1836Or.A0A.A02());
            }
        }
    }
}
