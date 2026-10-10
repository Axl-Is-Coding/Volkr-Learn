package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JG implements AdView.AdViewLoadConfigBuilder, AdView.AdViewLoadConfig {

    @Nullable
    public String A00;
    public final C13554p A01;

    public JG(C13554p c13554p) {
        this.A01 = c13554p;
    }

    @Nullable
    public final String A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.Ad.LoadConfigBuilder
    public final AdView.AdViewLoadConfig build() {
        return this;
    }

    @Override // com.facebook.ads.AdView.AdViewLoadConfigBuilder
    public final AdView.AdViewLoadConfigBuilder withAdListener(AdListener adListener) {
        this.A01.A0D(adListener);
        return this;
    }

    @Override // com.facebook.ads.Ad.LoadConfigBuilder
    public final AdView.AdViewLoadConfigBuilder withBid(String str) {
        this.A00 = str;
        return this;
    }
}
