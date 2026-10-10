package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzanz implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzanh zzdlm;
    private final /* synthetic */ zzanx zzdln;

    zzanz(zzanx zzanxVar, zzanh zzanhVar) {
        this.zzdln = zzanxVar;
        this.zzdlm = zzanhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.zzdln.zzdlj = mediationRewardedAd;
            this.zzdlm.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
        return new zzavv(this.zzdlm);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzdln.zzdlf.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 31 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzbbq.zzef(sb.toString());
            this.zzdlm.zzc(0, str);
            this.zzdlm.onAdFailedToLoad(0);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzdln.zzdlf.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 87 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ErrorCode = ");
            sb.append(code);
            sb.append(". ErrorMessage = ");
            sb.append(message);
            sb.append(". ErrorDomain = ");
            sb.append(domain);
            zzbbq.zzef(sb.toString());
            this.zzdlm.zzc(adError.zzdo());
            this.zzdlm.zzc(adError.getCode(), adError.getMessage());
            this.zzdlm.onAdFailedToLoad(adError.getCode());
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
