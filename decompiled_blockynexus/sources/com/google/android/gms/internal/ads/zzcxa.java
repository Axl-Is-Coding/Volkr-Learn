package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzcxa extends zzcyc {
    private zzcal zzgqk;

    public zzcxa(zzbuc zzbucVar, zzbuu zzbuuVar, zzbvh zzbvhVar, zzbvr zzbvrVar, zzbuk zzbukVar, zzbyf zzbyfVar, zzcau zzcauVar, zzbwa zzbwaVar, zzcal zzcalVar, zzbxy zzbxyVar) {
        super(zzbucVar, zzbuuVar, zzbvhVar, zzbvrVar, zzbyfVar, zzbwaVar, zzcauVar, zzbxyVar, zzbukVar);
        this.zzgqk = zzcalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyc, com.google.android.gms.internal.ads.zzanh
    public final void onVideoEnd() {
        this.zzgqk.zztb();
    }

    @Override // com.google.android.gms.internal.ads.zzcyc, com.google.android.gms.internal.ads.zzanh
    public final void zza(zzaux zzauxVar) throws RemoteException {
        super.zza(zzauxVar);
        this.zzgqk.zza(new zzauv(zzauxVar.getType(), zzauxVar.getAmount()));
    }

    @Override // com.google.android.gms.internal.ads.zzcyc, com.google.android.gms.internal.ads.zzanh
    public final void zzb(zzauv zzauvVar) {
        super.zzb(zzauvVar);
        this.zzgqk.zza(zzauvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcyc, com.google.android.gms.internal.ads.zzanh
    public final void zzuc() {
        this.zzgqk.zzta();
    }

    @Override // com.google.android.gms.internal.ads.zzcyc, com.google.android.gms.internal.ads.zzanh
    public final void zzud() throws RemoteException {
        this.zzgqk.zztb();
    }
}
