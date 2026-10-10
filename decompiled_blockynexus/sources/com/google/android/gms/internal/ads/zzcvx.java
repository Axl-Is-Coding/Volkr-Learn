package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcvx extends zzape {
    private zzctc<zzaph, zzcuu> zzgoq;
    private final /* synthetic */ zzcvv zzgps;

    private zzcvx(zzcvv zzcvvVar, zzctc<zzaph, zzcuu> zzctcVar) {
        this.zzgps = zzcvvVar;
        this.zzgoq = zzctcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapb
    public final void zza(zzanu zzanuVar) throws RemoteException {
        this.zzgps.zzgpr = zzanuVar;
        ((zzcuu) this.zzgoq.zzgns).onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzapb
    public final void zzdq(String str) throws RemoteException {
        ((zzcuu) this.zzgoq.zzgns).zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapb
    public final void zzf(zzva zzvaVar) throws RemoteException {
        ((zzcuu) this.zzgoq.zzgns).zzc(zzvaVar);
    }
}
