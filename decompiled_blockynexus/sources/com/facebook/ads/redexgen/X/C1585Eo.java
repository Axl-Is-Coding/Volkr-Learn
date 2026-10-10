package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1585Eo extends RV {
    public final /* synthetic */ C1584En A00;
    public final /* synthetic */ RJ A01;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1585Eo(C1584En c1584En, boolean z, RJ rj) {
        super(z);
        this.A00 = c1584En;
        this.A01 = rj;
    }

    @Override // com.facebook.ads.redexgen.X.RV
    public final void A00() {
        this.A00.A01.ABB(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.RV
    public final void A01(boolean z) {
        this.A00.A0B.set(true);
        this.A00.A01.AB8(this.A01);
    }
}
