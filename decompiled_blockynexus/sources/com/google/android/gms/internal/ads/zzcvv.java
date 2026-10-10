package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvv implements zzcti<zzcdx, zzaph, zzcuu> {
    private final zzcda zzgpj;
    private zzanu zzgpr;
    private final Context zzvr;

    public zzcvv(Context context, zzcda zzcdaVar) {
        this.zzvr = context;
        this.zzgpj = zzcdaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzaph, zzcuu> zzctcVar) throws zzdos {
        try {
            zzctcVar.zzdlf.zzdr(zzdnvVar.zzdmk);
            zzctcVar.zzdlf.zza(zzdnvVar.zzera, zzdnvVar.zzhdu.toString(), zzdogVar.zzhev.zzfsk.zzhfa, ObjectWrapper.wrap(this.zzvr), new zzcvx(this, zzctcVar), (zzanh) zzctcVar.zzgns);
        } catch (RemoteException e2) {
            throw new zzdos(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzcdx zzb(zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar) throws zzcwn, zzdos {
        if (!zzdogVar.zzhev.zzfsk.zzhfc.contains(Integer.toString(6))) {
            throw new zzcwn(zzdpg.INVALID_REQUEST, "Unified must be used for RTB.");
        }
        zzcei zzceiVarZzb = zzcei.zzb(this.zzgpr);
        if (!zzdogVar.zzhev.zzfsk.zzhfc.contains(Integer.toString(zzceiVarZzb.zzama()))) {
            throw new zzcwn(zzdpg.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        zzcej zzcejVarZza = this.zzgpj.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzceu(zzceiVarZzb), new zzcgf(null, null, this.zzgpr));
        ((zzcuu) zzctcVar.zzgns).zzb(zzcejVarZza.zzaff());
        return zzcejVarZza.zzafg();
    }
}
