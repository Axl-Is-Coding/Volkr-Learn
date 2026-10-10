package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvc extends zzws {
    private final AdListener zzcha;

    public zzvc(AdListener adListener) {
        this.zzcha = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzcha;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void onAdClicked() {
        this.zzcha.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void onAdClosed() {
        this.zzcha.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void onAdFailedToLoad(int i) {
        this.zzcha.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void onAdImpression() {
        this.zzcha.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void onAdLeftApplication() {
        this.zzcha.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void onAdLoaded() {
        this.zzcha.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void onAdOpened() {
        this.zzcha.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void zzc(zzva zzvaVar) {
        this.zzcha.onAdFailedToLoad(zzvaVar.zzpi());
    }
}
