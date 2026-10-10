package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvd implements zzcti<zzcbe, zzdpa, zzcuu> {
    private final zzbbx zzbot;
    private final Executor zzfoc;
    private final zzcce zzgos;
    private final Context zzvr;

    public zzcvd(Context context, zzbbx zzbbxVar, zzcce zzcceVar, Executor executor) {
        this.zzvr = context;
        this.zzbot = zzbbxVar;
        this.zzgos = zzcceVar;
        this.zzfoc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzdpa, zzcuu> zzctcVar) throws zzdos {
        if (this.zzbot.zzeem < 4100000) {
            zzctcVar.zzdlf.zza(this.zzvr, zzdogVar.zzhev.zzfsk.zzhfa, zzdnvVar.zzhdu.toString(), (zzanh) zzctcVar.zzgns);
        } else {
            zzctcVar.zzdlf.zza(this.zzvr, zzdogVar.zzhev.zzfsk.zzhfa, zzdnvVar.zzhdu.toString(), zzbao.zza(zzdnvVar.zzhdr), (zzanh) zzctcVar.zzgns);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzcbe zzb(zzdog zzdogVar, zzdnv zzdnvVar, final zzctc zzctcVar) throws zzcwn, zzdos {
        zzcbg zzcbgVarZza = this.zzgos.zza(new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib), new zzcbf(new zzccm(zzctcVar) { // from class: com.google.android.gms.internal.ads.zzcvg
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
                    ((zzdpa) zzctcVar2.zzdlf).showInterstitial();
                } catch (zzdos e2) {
                    zzbbq.zzfd("Cannot show interstitial.");
                    throw new zzccl(e2.getCause());
                }
            }
        }));
        zzcbgVarZza.zzaez().zza(new zzbmf((zzdpa) zzctcVar.zzdlf), this.zzfoc);
        ((zzcuu) zzctcVar.zzgns).zzb(zzcbgVarZza.zzafe());
        return zzcbgVarZza.zzagj();
    }
}
