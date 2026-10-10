package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaob extends zzank {
    private final zzaur zzdlh;
    private final Adapter zzdlp;

    zzaob(Adapter adapter, zzaur zzaurVar) {
        this.zzdlp = adapter;
        this.zzdlh = zzaurVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdClicked() throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zzak(ObjectWrapper.wrap(this.zzdlp));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdClosed() throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zzaj(ObjectWrapper.wrap(this.zzdlp));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zze(ObjectWrapper.wrap(this.zzdlp), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdImpression() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdLeftApplication() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdLoaded() throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zzag(ObjectWrapper.wrap(this.zzdlp));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdOpened() throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zzah(ObjectWrapper.wrap(this.zzdlp));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onVideoEnd() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onVideoPause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onVideoPlay() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzafa zzafaVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzanm zzanmVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzaux zzauxVar) throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zza(ObjectWrapper.wrap(this.zzdlp), new zzauv(zzauxVar.getType(), zzauxVar.getAmount()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzb(zzauv zzauvVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzc(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzc(zzva zzvaVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzdd(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzdn(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzdo(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zze(zzva zzvaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzuc() throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zzai(ObjectWrapper.wrap(this.zzdlp));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzud() throws RemoteException {
        zzaur zzaurVar = this.zzdlh;
        if (zzaurVar != null) {
            zzaurVar.zzam(ObjectWrapper.wrap(this.zzdlp));
        }
    }
}
