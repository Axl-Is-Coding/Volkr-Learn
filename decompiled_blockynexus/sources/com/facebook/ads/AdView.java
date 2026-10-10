package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AdView extends RelativeLayout implements Ad {
    private final AdViewApi mAdViewApi;
    private final AdViewParentApi mAdViewParentApi;

    @Keep
    public interface AdViewLoadConfig extends Ad.LoadAdConfig {
    }

    @Keep
    public interface AdViewLoadConfigBuilder extends Ad.LoadConfigBuilder {
        @Override // com.facebook.ads.Ad.LoadConfigBuilder
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withAdListener(AdListener adListener);

        @Override // com.facebook.ads.Ad.LoadConfigBuilder
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withBid(String str);
    }

    @Benchmark
    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        this.mAdViewParentApi = new AdViewParentApi() { // from class: com.facebook.ads.AdView.1
            @Override // com.facebook.ads.internal.api.AdViewParentApi
            @Benchmark
            public void onConfigurationChanged(Configuration configuration) {
                AdView.super.onConfigurationChanged(configuration);
            }
        };
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, adSize, this.mAdViewParentApi, this);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public AdViewLoadConfigBuilder buildLoadAdConfig() {
        return this.mAdViewApi.buildLoadAdConfig();
    }

    @Override // com.facebook.ads.Ad
    public void destroy() {
        this.mAdViewApi.destroy();
    }

    @Override // com.facebook.ads.Ad
    public String getPlacementId() {
        return this.mAdViewApi.getPlacementId();
    }

    @Override // com.facebook.ads.Ad
    public boolean isAdInvalidated() {
        return this.mAdViewApi.isAdInvalidated();
    }

    @Override // com.facebook.ads.Ad
    @Benchmark
    public void loadAd() {
        this.mAdViewApi.loadAd();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        this.mAdViewApi.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.Ad
    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mAdViewApi.setExtraHints(extraHints);
    }

    @Benchmark
    public void loadAd(AdViewLoadConfig adViewLoadConfig) {
        this.mAdViewApi.loadAd(adViewLoadConfig);
    }

    @Benchmark
    public AdView(Context context, String str, String str2) throws Exception {
        super(context);
        this.mAdViewParentApi = new AdViewParentApi() { // from class: com.facebook.ads.AdView.1
            @Override // com.facebook.ads.internal.api.AdViewParentApi
            @Benchmark
            public void onConfigurationChanged(Configuration configuration) {
                AdView.super.onConfigurationChanged(configuration);
            }
        };
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, str2, this.mAdViewParentApi, this);
    }
}
