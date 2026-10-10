package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardedVideoAd;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5J, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5J implements RewardedVideoAd.RewardedVideoAdShowConfigBuilder, RewardedVideoAd.RewardedVideoShowAdConfig {
    public int A00 = -1;

    public final int A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.FullScreenAd.ShowConfigBuilder
    public final RewardedVideoAd.RewardedVideoShowAdConfig build() {
        return this;
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdShowConfigBuilder
    public final RewardedVideoAd.RewardedVideoAdShowConfigBuilder withAppOrientation(int i) {
        this.A00 = i;
        return this;
    }
}
