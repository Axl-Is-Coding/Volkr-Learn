package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1871Qa extends AbstractC1848Pd {
    public final /* synthetic */ QW A00;

    public C1871Qa(QW qw) {
        this.A00 = qw;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1848Pd
    public final void A04() {
        if (!this.A00.A06.A08()) {
            this.A00.A06.A06();
            if (!TextUtils.isEmpty(this.A00.A01.A0Q())) {
                this.A00.A04.A8M(this.A00.A01.A0Q(), new NQ().A04(this.A00.A0A).A03(this.A00.A06).A05(this.A00.A01.A0S()).A06());
                this.A00.A03.A0A().A2a();
                this.A00.A08.A3s(this.A00.A09.A6U());
            }
        }
    }
}
