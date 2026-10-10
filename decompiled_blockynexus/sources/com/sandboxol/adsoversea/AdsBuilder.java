package com.sandboxol.adsoversea;

/* JADX INFO: loaded from: classes2.dex */
public class AdsBuilder implements AdsInitInterface {
    private String adsKey;
    private String interstitialKey;
    private boolean isDebug;
    private String source;
    private String videoKey;

    public String getAdsKey() {
        return this.adsKey;
    }

    public String getInterstitialKey() {
        return this.interstitialKey;
    }

    public String getSource() {
        return this.source;
    }

    public String getVideoKey() {
        return this.videoKey;
    }

    @Override // com.sandboxol.adsoversea.AdsInitInterface
    public AdsBuilder isDebug(boolean z) {
        this.isDebug = z;
        return this;
    }

    @Override // com.sandboxol.adsoversea.AdsInitInterface
    public AdsBuilder setAdsKey(String str) {
        this.adsKey = str;
        return this;
    }

    @Override // com.sandboxol.adsoversea.AdsInitInterface
    public AdsBuilder setAdsSource(String str) {
        this.source = str;
        return this;
    }

    @Override // com.sandboxol.adsoversea.AdsInitInterface
    public AdsBuilder setInterstitialKey(String str) {
        this.interstitialKey = str;
        return this;
    }

    @Override // com.sandboxol.adsoversea.AdsInitInterface
    public AdsBuilder setVideoKey(String str) {
        this.videoKey = str;
        return this;
    }

    public boolean isDebug() {
        return this.isDebug;
    }
}
