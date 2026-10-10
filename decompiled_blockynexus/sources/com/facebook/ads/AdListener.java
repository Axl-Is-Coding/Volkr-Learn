package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.internal.bench.Benchmark;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface AdListener {
    @Benchmark
    void onAdClicked(Ad ad);

    @Benchmark
    void onAdLoaded(Ad ad);

    @Benchmark
    void onError(Ad ad, AdError adError);

    @Benchmark
    void onLoggingImpression(Ad ad);
}
