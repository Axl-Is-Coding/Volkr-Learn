package com.facebook.ads.redexgen.X;

import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2031Wg extends KT {
    public final /* synthetic */ NZ A00;

    public C2031Wg(NZ nz) {
        this.A00 = nz;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    @RequiresApi(api = 16)
    public final void A07() {
        if (this.A00.isPressed()) {
            this.A00.postDelayed(this, r2.A07);
        } else {
            this.A00.setPressed(true);
            NZ nz = this.A00;
            nz.postOnAnimationDelayed(nz.A0A, 250L);
        }
    }
}
