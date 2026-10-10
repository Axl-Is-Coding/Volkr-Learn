package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcww implements zzcti<zzcjg, zzaph, zzcuu> {
    private final zzcjj zzgqi;
    private final Context zzvr;

    public zzcww(Context context, zzcjj zzcjjVar) {
        this.zzvr = context;
        this.zzgqi = zzcjjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzaph, zzcuu> zzctcVar) throws zzdos {
        try {
            zzctcVar.zzdlf.zzdr(zzdnvVar.zzdmk);
            if (zzdogVar.zzhev.zzfsk.zzhfh.zzheo == zzdoc.zzher) {
                zzctcVar.zzdlf.zzb(zzdnvVar.zzera, zzdnvVar.zzhdu.toString(), zzdogVar.zzhev.zzfsk.zzhfa, ObjectWrapper.wrap(this.zzvr), new zzcwy(this, zzctcVar), (zzanh) zzctcVar.zzgns);
            } else {
                zzctcVar.zzdlf.zza(zzdnvVar.zzera, zzdnvVar.zzhdu.toString(), zzdogVar.zzhev.zzfsk.zzhfa, ObjectWrapper.wrap(this.zzvr), new zzcwy(this, zzctcVar), (zzanh) zzctcVar.zzgns);
            }
        } catch (RemoteException e2) {
            zzayp.zza("Remote exception loading a rewarded RTB ad", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzcjg zzb(zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar) throws zzcwn, zzdos {
        zzcve zzcveVar = new zzcve(zzdnvVar, (zzaph) zzctcVar.zzdlf, true);
        zzcji zzcjiVarZza = this.zzgqi.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzcjh(zzcveVar));
        zzcveVar.zza(zzcjiVarZza.zzafc());
        ((zzcuu) zzctcVar.zzgns).zzb(zzcjiVarZza.zzagr());
        return zzcjiVarZza.zzago();
    }
}
