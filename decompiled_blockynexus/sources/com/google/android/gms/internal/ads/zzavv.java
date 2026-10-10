package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavv implements MediationRewardedAdCallback {
    private final zzanh zzdlq;

    public zzavv(zzanh zzanhVar) {
        this.zzdlq = zzanhVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdClosed.");
        try {
            this.zzdlq.onAdClosed();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdFailedToShow.");
        String strValueOf = String.valueOf(str);
        zzbbq.zzfe(strValueOf.length() != 0 ? "Mediation ad failed to show: ".concat(strValueOf) : new String("Mediation ad failed to show: "));
        try {
            this.zzdlq.zzdo(str);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdOpened.");
        try {
            this.zzdlq.onAdOpened();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onUserEarnedReward.");
        try {
            this.zzdlq.zza(new zzavu(rewardItem));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onVideoComplete.");
        try {
            this.zzdlq.zzud();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoStart() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onVideoStart.");
        try {
            this.zzdlq.zzuc();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called reportAdClicked.");
        try {
            this.zzdlq.onAdClicked();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called reportAdImpression.");
        try {
            this.zzdlq.onAdImpression();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onAdFailedToShow(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdFailedToShow.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 87 + String.valueOf(domain).length());
        sb.append("Mediation ad failed to show: Error Code = ");
        sb.append(code);
        sb.append(". Error Message = ");
        sb.append(message);
        sb.append(" Error Domain = ");
        sb.append(domain);
        zzbbq.zzfe(sb.toString());
        try {
            this.zzdlq.zze(adError.zzdo());
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
