package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1879Qi implements NP {
    public final WeakReference<AbstractC1878Qh> A00;

    public C1879Qi(AbstractC1878Qh abstractC1878Qh) {
        this.A00 = new WeakReference<>(abstractC1878Qh);
    }

    @Override // com.facebook.ads.redexgen.X.NP
    public final void A9z(boolean z) {
        AbstractC1878Qh abstractC1878Qh = this.A00.get();
        if (abstractC1878Qh != null) {
            abstractC1878Qh.A06 = z;
            abstractC1878Qh.A01();
        }
    }
}
