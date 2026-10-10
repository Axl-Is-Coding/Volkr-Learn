package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import java.util.EnumSet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.53, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass53 implements InterstitialAd.InterstitialAdLoadConfigBuilder, InterstitialAd.InterstitialLoadAdConfig {
    public AnonymousClass52 A00;

    @Nullable
    public String A01;
    public EnumSet<CacheFlag> A02;

    public AnonymousClass53(AnonymousClass52 anonymousClass52) {
        this.A00 = anonymousClass52;
    }

    public final void A00() {
        if (this.A02 == null) {
            this.A02 = CacheFlag.ALL;
        }
        this.A00.A06(this.A02, this.A01);
    }

    @Override // com.facebook.ads.Ad.LoadConfigBuilder
    public final InterstitialAd.InterstitialLoadAdConfig build() {
        return this;
    }

    @Override // com.facebook.ads.InterstitialAd.InterstitialAdLoadConfigBuilder
    public final InterstitialAd.InterstitialAdLoadConfigBuilder withAdListener(InterstitialAdListener interstitialAdListener) {
        this.A00.A03(interstitialAdListener);
        if (interstitialAdListener instanceof InterstitialAdExtendedListener) {
            this.A00.A05((InterstitialAdExtendedListener) interstitialAdListener);
        }
        return this;
    }

    @Override // com.facebook.ads.Ad.LoadConfigBuilder
    public final InterstitialAd.InterstitialAdLoadConfigBuilder withBid(String str) {
        this.A01 = str;
        return this;
    }

    @Override // com.facebook.ads.InterstitialAd.InterstitialAdLoadConfigBuilder
    public final InterstitialAd.InterstitialAdLoadConfigBuilder withCacheFlags(EnumSet<CacheFlag> cacheFlags) {
        this.A02 = cacheFlags;
        return this;
    }

    @Override // com.facebook.ads.InterstitialAd.InterstitialAdLoadConfigBuilder
    public final InterstitialAd.InterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData) {
        this.A00.A04(rewardData);
        return this;
    }

    @Override // com.facebook.ads.InterstitialAd.InterstitialAdLoadConfigBuilder
    public final InterstitialAd.InterstitialAdLoadConfigBuilder withRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.A00.A05(rewardedAdListener);
        return this;
    }
}
