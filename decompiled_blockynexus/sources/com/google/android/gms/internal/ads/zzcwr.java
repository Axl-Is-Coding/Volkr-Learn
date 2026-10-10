package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwr implements zzcti<zzcjg, zzdpa, zzcuu> {
    private final Executor zzfoc;
    private final zzcjj zzgqi;
    private final Context zzvr;

    public zzcwr(Context context, Executor executor, zzcjj zzcjjVar) {
        this.zzvr = context;
        this.zzfoc = executor;
        this.zzgqi = zzcjjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzdpa, zzcuu> zzctcVar) throws zzdos {
        try {
            zzdok zzdokVar = zzdogVar.zzhev.zzfsk;
            if (zzdokVar.zzhfh.zzheo == zzdoc.zzher) {
                zzctcVar.zzdlf.zzc(this.zzvr, zzdokVar.zzhfa, zzdnvVar.zzhdu.toString(), (zzanh) zzctcVar.zzgns);
            } else {
                zzctcVar.zzdlf.zzb(this.zzvr, zzdokVar.zzhfa, zzdnvVar.zzhdu.toString(), (zzanh) zzctcVar.zzgns);
            }
        } catch (Exception e2) {
            String strValueOf = String.valueOf(zzctcVar.zzcib);
            zzbbq.zzd(strValueOf.length() != 0 ? "Fail to load ad from adapter ".concat(strValueOf) : new String("Fail to load ad from adapter "), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzcjg zzb(zzdog zzdogVar, zzdnv zzdnvVar, final zzctc zzctcVar) throws zzcwn, zzdos {
        zzcji zzcjiVarZza = this.zzgqi.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzcjh(new zzccm(zzctcVar) { // from class: com.google.android.gms.internal.ads.zzcwu
            private final zzctc zzgop;

            {
                this.zzgop = zzctcVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.internal.ads.zzccm
            public final void zza(boolean z, Context context) throws zzccl {
                zzctc zzctcVar2 = this.zzgop;
                try {
                    ((zzdpa) zzctcVar2.zzdlf).setImmersiveMode(z);
                    ((zzdpa) zzctcVar2.zzdlf).zzci(context);
                } catch (zzdos e2) {
                    throw new zzccl(e2.getCause());
                }
            }
        }));
        zzcjiVarZza.zzaez().zza(new zzbmf((zzdpa) zzctcVar.zzdlf), this.zzfoc);
        ((zzcuu) zzctcVar.zzgns).zzb(zzcjiVarZza.zzagq());
        return zzcjiVarZza.zzago();
    }
}
