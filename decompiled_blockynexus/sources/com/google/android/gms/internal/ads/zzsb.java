package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzsb extends zzsk {
    private final WeakReference<AppOpenAd.AppOpenAdLoadCallback> zzbup;

    public zzsb(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzbup = new WeakReference<>(appOpenAdLoadCallback);
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbup.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void zza(zzsg zzsgVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbup.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdLoaded(new zzsn(zzsgVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void zza(zzva zzvaVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbup.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(zzvaVar.zzpi());
        }
    }
}
