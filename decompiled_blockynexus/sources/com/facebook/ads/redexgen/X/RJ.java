package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class RJ implements InterfaceC12510m {
    public int A00;
    public RewardData A01;

    public abstract int A0B();

    public abstract boolean A0C();

    public final void A00(int i) {
        this.A00 = i;
    }

    public final void A01(RewardData rewardData) {
        this.A01 = rewardData;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final AdPlacementType A6p() {
        return AdPlacementType.REWARDED_VIDEO;
    }
}
