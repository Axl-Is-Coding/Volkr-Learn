package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajn extends zzajj {
    private final InstreamAd.InstreamAdLoadCallback zzdgi;

    public zzajn(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdgi = instreamAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdgi.onInstreamAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zza(zzaje zzajeVar) {
        this.zzdgi.onInstreamAdLoaded(new zzajl(zzajeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zzd(zzva zzvaVar) {
        this.zzdgi.onInstreamAdFailedToLoad(zzvaVar.zzpi());
    }
}
