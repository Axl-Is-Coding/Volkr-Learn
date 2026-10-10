package com.facebook.ads.redexgen.X;

import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2030Wf extends KT {
    public final /* synthetic */ NZ A00;

    public C2030Wf(NZ nz) {
        this.A00 = nz;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    @RequiresApi(api = 16)
    public final void A07() {
        this.A00.setPressed(false);
        NZ nz = this.A00;
        nz.postOnAnimationDelayed(nz.A08, this.A00.A07);
    }
}
