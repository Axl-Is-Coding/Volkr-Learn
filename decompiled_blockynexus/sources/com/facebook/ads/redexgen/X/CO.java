package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class CO {
    public final CM A00;

    public abstract void A0C(IG ig, long j) throws AD;

    public abstract boolean A0D(IG ig) throws AD;

    public CO(CM cm) {
        this.A00 = cm;
    }

    public final void A00(IG ig, long j) throws AD {
        if (A0D(ig)) {
            A0C(ig, j);
        }
    }
}
