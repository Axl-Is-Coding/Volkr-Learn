package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvi implements zzcti<zzcbe, zzaph, zzcuu> {
    private final zzcce zzgos;
    private final Context zzvr;

    public zzcvi(Context context, zzcce zzcceVar) {
        this.zzvr = context;
        this.zzgos = zzcceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzaph, zzcuu> zzctcVar) throws zzdos {
        try {
            zzctcVar.zzdlf.zzdr(zzdnvVar.zzdmk);
            zzctcVar.zzdlf.zza(zzdnvVar.zzera, zzdnvVar.zzhdu.toString(), zzdogVar.zzhev.zzfsk.zzhfa, ObjectWrapper.wrap(this.zzvr), new zzcvk(this, zzctcVar), (zzanh) zzctcVar.zzgns);
        } catch (RemoteException e2) {
            throw new zzdos(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzcbe zzb(zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar) throws zzcwn, zzdos {
        zzcve zzcveVar = new zzcve(zzdnvVar, (zzaph) zzctcVar.zzdlf, false);
        zzcbg zzcbgVarZza = this.zzgos.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzcbf(zzcveVar));
        zzcveVar.zza(zzcbgVarZza.zzafc());
        ((zzcuu) zzctcVar.zzgns).zzb(zzcbgVarZza.zzaff());
        return zzcbgVarZza.zzagj();
    }
}
