package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxl implements zzcti<zzcjg, zzdpa, zzcut> {
    private final Executor zzfoc;
    private final zzcjj zzgqi;
    private final Context zzvr;

    public zzcxl(Context context, Executor executor, zzcjj zzcjjVar) {
        this.zzvr = context;
        this.zzfoc = executor;
        this.zzgqi = zzcjjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzdpa, zzcut> zzctcVar) {
        try {
            zzctcVar.zzdlf.zza(zzdogVar.zzhev.zzfsk.zzhfa, zzdnvVar.zzhdu.toString());
        } catch (Exception e2) {
            String strValueOf = String.valueOf(zzctcVar.zzcib);
            zzbbq.zzd(strValueOf.length() != 0 ? "Fail to load ad from adapter ".concat(strValueOf) : new String("Fail to load ad from adapter "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzdpa, zzcut> zzctcVar) throws zzdos {
        if (zzctcVar.zzdlf.isInitialized()) {
            zzc(zzdogVar, zzdnvVar, zzctcVar);
            return;
        }
        ((zzcut) zzctcVar.zzgns).zza(new zzcxn(this, zzdogVar, zzdnvVar, zzctcVar));
        zzctcVar.zzdlf.zza(this.zzvr, zzdogVar.zzhev.zzfsk.zzhfa, (String) null, (zzaur) zzctcVar.zzgns, zzdnvVar.zzhdu.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzcjg zzb(zzdog zzdogVar, zzdnv zzdnvVar, final zzctc zzctcVar) throws zzcwn, zzdos {
        zzcji zzcjiVarZza = this.zzgqi.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzcjh(new zzccm(zzctcVar) { // from class: com.google.android.gms.internal.ads.zzcxo
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
                    ((zzdpa) zzctcVar2.zzdlf).showVideo();
                } catch (zzdos e2) {
                    zzbbq.zzd("Cannot show rewarded video.", e2);
                    throw new zzccl(e2.getCause());
                }
            }
        }));
        zzcjiVarZza.zzaez().zza(new zzbmf((zzdpa) zzctcVar.zzdlf), this.zzfoc);
        zzbvh zzbvhVarZzafa = zzcjiVarZza.zzafa();
        zzbuc zzbucVarZzafb = zzcjiVarZza.zzafb();
        ((zzcut) zzctcVar.zzgns).zza(new zzcxp(this, zzcjiVarZza.zzagk(), zzbucVarZzafb, zzbvhVarZzafa, zzcjiVarZza.zzagp()));
        return zzcjiVarZza.zzago();
    }
}
