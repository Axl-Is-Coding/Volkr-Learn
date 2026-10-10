package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvt implements zzcti<zzcdx, zzdpa, zzcuu> {
    private final Executor zzfoc;
    private final zzcda zzgpj;
    private final Context zzvr;

    public zzcvt(Context context, zzcda zzcdaVar, Executor executor) {
        this.zzvr = context;
        this.zzgpj = zzcdaVar;
        this.zzfoc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzdpa, zzcuu> zzctcVar) throws zzdos {
        zzdpa zzdpaVar = zzctcVar.zzdlf;
        Context context = this.zzvr;
        zzvg zzvgVar = zzdogVar.zzhev.zzfsk.zzhfa;
        String string = zzdnvVar.zzhdu.toString();
        String strZza = zzbao.zza(zzdnvVar.zzhdr);
        zzanh zzanhVar = (zzanh) zzctcVar.zzgns;
        zzdok zzdokVar = zzdogVar.zzhev.zzfsk;
        zzdpaVar.zza(context, zzvgVar, string, strZza, zzanhVar, zzdokVar.zzdly, zzdokVar.zzhfc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzcdx zzb(zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar) throws zzcwn, zzdos {
        zzcei zzceiVarZza;
        zzano zzanoVarZztt = ((zzdpa) zzctcVar.zzdlf).zztt();
        zzanp zzanpVarZztu = ((zzdpa) zzctcVar.zzdlf).zztu();
        zzanu zzanuVarZztz = ((zzdpa) zzctcVar.zzdlf).zztz();
        if (zzanuVarZztz != null && zza(zzdogVar, 6)) {
            zzceiVarZza = zzcei.zzb(zzanuVarZztz);
        } else if (zzanoVarZztt != null && zza(zzdogVar, 6)) {
            zzceiVarZza = zzcei.zzb(zzanoVarZztt);
        } else if (zzanoVarZztt != null && zza(zzdogVar, 2)) {
            zzceiVarZza = zzcei.zza(zzanoVarZztt);
        } else if (zzanpVarZztu != null && zza(zzdogVar, 6)) {
            zzceiVarZza = zzcei.zzb(zzanpVarZztu);
        } else {
            if (zzanpVarZztu == null || !zza(zzdogVar, 1)) {
                throw new zzcwn(zzdpg.INTERNAL_ERROR, "No native ad mappers");
            }
            zzceiVarZza = zzcei.zza(zzanpVarZztu);
        }
        if (!zzdogVar.zzhev.zzfsk.zzhfc.contains(Integer.toString(zzceiVarZza.zzama()))) {
            throw new zzcwn(zzdpg.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        zzcej zzcejVarZza = this.zzgpj.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzceu(zzceiVarZza), new zzcgf(zzanpVarZztu, zzanoVarZztt, zzanuVarZztz));
        ((zzcuu) zzctcVar.zzgns).zzb(zzcejVarZza.zzafe());
        zzcejVarZza.zzaez().zza(new zzbmf((zzdpa) zzctcVar.zzdlf), this.zzfoc);
        return zzcejVarZza.zzafg();
    }

    private static boolean zza(zzdog zzdogVar, int i) {
        return zzdogVar.zzhev.zzfsk.zzhfc.contains(Integer.toString(i));
    }
}
