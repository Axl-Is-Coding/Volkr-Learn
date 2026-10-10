package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapt implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzanh zzdmh;
    private final /* synthetic */ zzapq zzdmn;
    private final /* synthetic */ zzapg zzdmo;

    zzapt(zzapq zzapqVar, zzapg zzapgVar, zzanh zzanhVar) {
        this.zzdmn = zzapqVar;
        this.zzdmo = zzapgVar;
        this.zzdmh = zzanhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd != null) {
            try {
                this.zzdmn.zzdlj = mediationRewardedAd;
                this.zzdmo.zzul();
            } catch (RemoteException e2) {
                zzbbq.zzc("", e2);
            }
            return new zzapw(this.zzdmh);
        }
        zzbbq.zzfe("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zzdmo.zzdq("Adapter returned null.");
            return null;
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdmo.zzdq(str);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdmo.zzf(adError.zzdo());
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
