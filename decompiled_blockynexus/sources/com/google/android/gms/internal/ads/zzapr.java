package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapr implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzanh zzdmh;
    private final /* synthetic */ zzapb zzdml;

    zzapr(zzapq zzapqVar, zzapb zzapbVar, zzanh zzanhVar) {
        this.zzdml = zzapbVar;
        this.zzdmh = zzanhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper != null) {
            try {
                this.zzdml.zza(new zzaow(unifiedNativeAdMapper));
            } catch (RemoteException e2) {
                zzbbq.zzc("", e2);
            }
            return new zzapw(this.zzdmh);
        }
        zzbbq.zzfe("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zzdml.zzdq("Adapter returned null.");
            return null;
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdml.zzdq(str);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdml.zzf(adError.zzdo());
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
