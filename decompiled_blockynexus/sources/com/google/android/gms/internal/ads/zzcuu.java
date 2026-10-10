package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcuu extends zzank implements zzbvp {
    private zzanh zzdmr;
    private zzbvo zzgpc;

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAdClicked() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAdClosed() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAdFailedToLoad(i);
        }
        if (this.zzgpc != null) {
            this.zzgpc.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAdImpression() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAdLoaded();
        }
        if (this.zzgpc != null) {
            this.zzgpc.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAdOpened() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onVideoEnd() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onVideoEnd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onVideoPause() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvp
    public final synchronized void zza(zzbvo zzbvoVar) {
        this.zzgpc = zzbvoVar;
    }

    public final synchronized void zzb(zzanh zzanhVar) {
        this.zzdmr = zzanhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzc(int i, String str) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzc(i, str);
        }
        if (this.zzgpc != null) {
            this.zzgpc.zzf(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzdd(int i) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzdd(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzdn(String str) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzdn(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzdo(String str) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzdo(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zze(zzva zzvaVar) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zze(zzvaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzuc() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzuc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzud() throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzud();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zza(zzanm zzanmVar) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zza(zzanmVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzb(zzauv zzauvVar) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzb(zzauvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zza(zzafa zzafaVar, String str) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zza(zzafaVar, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zzc(zzva zzvaVar) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zzc(zzvaVar);
        }
        if (this.zzgpc != null) {
            this.zzgpc.zzk(zzvaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final synchronized void zza(zzaux zzauxVar) throws RemoteException {
        if (this.zzdmr != null) {
            this.zzdmr.zza(zzauxVar);
        }
    }
}
