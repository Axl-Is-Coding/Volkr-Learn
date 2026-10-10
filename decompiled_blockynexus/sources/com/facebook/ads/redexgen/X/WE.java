package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class WE implements C6Y {
    public final /* synthetic */ WH A00;

    public WE(WH wh) {
        this.A00 = wh;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        return this.A00.A07(C14136w.A02(TrafficStats.getMobileTxBytes()));
    }
}
