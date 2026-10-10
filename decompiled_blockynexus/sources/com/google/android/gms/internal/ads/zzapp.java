package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapp implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzaov zzdmg;
    private final /* synthetic */ zzanh zzdmh;

    zzapp(zzapq zzapqVar, zzaov zzaovVar, zzanh zzanhVar) {
        this.zzdmg = zzaovVar;
        this.zzdmh = zzanhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        if (mediationBannerAd != null) {
            try {
                this.zzdmg.zzx(ObjectWrapper.wrap(mediationBannerAd.getView()));
            } catch (RemoteException e2) {
                zzbbq.zzc("", e2);
            }
            return new zzapw(this.zzdmh);
        }
        zzbbq.zzfe("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zzdmg.zzdq("Adapter returned null.");
            return null;
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdmg.zzdq(str);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdmg.zzf(adError.zzdo());
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
