package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcwy extends zzapf {
    private zzctc<zzaph, zzcuu> zzgoq;

    private zzcwy(zzcww zzcwwVar, zzctc<zzaph, zzcuu> zzctcVar) {
        this.zzgoq = zzctcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void zzdq(String str) throws RemoteException {
        ((zzcuu) this.zzgoq.zzgns).zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void zzf(zzva zzvaVar) throws RemoteException {
        ((zzcuu) this.zzgoq.zzgns).zzc(zzvaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void zzul() throws RemoteException {
        ((zzcuu) this.zzgoq.zzgns).onAdLoaded();
    }
}
