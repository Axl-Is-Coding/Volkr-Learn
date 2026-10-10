package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcuw implements zzcta<zzcbe> {
    private final zzbbx zzbot;
    private final Executor zzfoc;
    private final zzdok zzfsk;
    private final zzcjt zzgbx;
    private final zzcce zzgos;
    private final Context zzvr;

    public zzcuw(Context context, zzbbx zzbbxVar, zzdok zzdokVar, Executor executor, zzcce zzcceVar, zzcjt zzcjtVar) {
        this.zzvr = context;
        this.zzfsk = zzdokVar;
        this.zzgos = zzcceVar;
        this.zzfoc = executor;
        this.zzbot = zzbbxVar;
        this.zzgbx = zzcjtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        return (zzdnyVar == null || zzdnyVar.zzdpp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<zzcbe> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        final zzckj zzckjVar = new zzckj();
        zzdzc<zzcbe> zzdzcVarZzb = zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this, zzdnvVar, zzdogVar, zzckjVar) { // from class: com.google.android.gms.internal.ads.zzcuv
            private final zzdnv zzgnz;
            private final zzdog zzgoa;
            private final zzckj zzgob;
            private final zzcuw zzgpe;

            {
                this.zzgpe = this;
                this.zzgnz = zzdnvVar;
                this.zzgoa = zzdogVar;
                this.zzgob = zzckjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgpe.zzb(this.zzgnz, this.zzgoa, this.zzgob, obj);
            }
        }, this.zzfoc);
        zzdzcVarZzb.addListener(zzcuy.zza(zzckjVar), this.zzfoc);
        return zzdzcVarZzb;
    }

    final /* synthetic */ zzdzc zzb(final zzdnv zzdnvVar, zzdog zzdogVar, zzckj zzckjVar, Object obj) throws Exception {
        zzdzc<?> zzdzcVarZza;
        final zzbgj zzbgjVarZza = this.zzgbx.zza(this.zzfsk.zzbpf, zzdnvVar, zzdogVar.zzhew.zzeou, zzdnvVar.zzeos);
        zzbgjVarZza.zzax(zzdnvVar.zzdtp);
        zzckjVar.zzc(this.zzvr, zzbgjVarZza.getView());
        zzbcg zzbcgVar = new zzbcg();
        final zzcbg zzcbgVarZza = this.zzgos.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzcbf(new zzcvc(this.zzvr, this.zzbot, zzbcgVar, zzdnvVar, zzbgjVarZza), zzbgjVarZza));
        zzbcgVar.set(zzcbgVarZza);
        zzcbgVarZza.zzafc().zza(new zzbuz(zzbgjVarZza) { // from class: com.google.android.gms.internal.ads.zzcux
            private final zzbgj zzeqk;

            {
                this.zzeqk = zzbgjVarZza;
            }

            @Override // com.google.android.gms.internal.ads.zzbuz
            public final void onAdImpression() {
                zzbgj zzbgjVar = this.zzeqk;
                if (zzbgjVar.zzabw() != null) {
                    zzbgjVar.zzabw().zzabi();
                }
            }
        }, zzbbz.zzeeu);
        zzcbgVarZza.zzafq().zzb(zzbgjVarZza, true);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwp)).booleanValue() && zzdnvVar.zzeos) {
            zzdzcVarZza = zzdyq.zzaf(null);
        } else {
            zzcbgVarZza.zzafq();
            zzdny zzdnyVar = zzdnvVar.zzhdr;
            zzdzcVarZza = zzcjv.zza(zzbgjVarZza, zzdnyVar.zzdpn, zzdnyVar.zzdpp);
        }
        return zzdyq.zzb(zzdzcVarZza, new zzdvu(this, zzbgjVarZza, zzdnvVar, zzcbgVarZza) { // from class: com.google.android.gms.internal.ads.zzcva
            private final zzdnv zzfqn;
            private final zzbgj zzgci;
            private final zzcuw zzgpe;
            private final zzcbg zzgpf;

            {
                this.zzgpe = this;
                this.zzgci = zzbgjVarZza;
                this.zzfqn = zzdnvVar;
                this.zzgpf = zzcbgVarZza;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj2) {
                zzbgj zzbgjVar = this.zzgci;
                zzdnv zzdnvVar2 = this.zzfqn;
                zzcbg zzcbgVar = this.zzgpf;
                if (zzdnvVar2.zzduj) {
                    zzbgjVar.zzacj();
                }
                zzbgjVar.zzabq();
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcoc)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzp.zzkt();
                    zzazd.zza(zzbgjVar);
                }
                return zzcbgVar.zzagj();
            }
        }, this.zzfoc);
    }
}
