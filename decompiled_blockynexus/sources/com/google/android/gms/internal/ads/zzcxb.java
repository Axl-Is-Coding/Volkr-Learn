package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxb implements zzcta<zzcjg> {
    private final zzbbx zzbot;
    private final Executor zzfoc;
    private final zzdok zzfsk;
    private final zzcjt zzgbx;
    private final zzcjj zzgqi;
    private final Context zzvr;

    public zzcxb(Context context, zzbbx zzbbxVar, zzdok zzdokVar, Executor executor, zzcjj zzcjjVar, zzcjt zzcjtVar) {
        this.zzvr = context;
        this.zzfsk = zzdokVar;
        this.zzgqi = zzcjjVar;
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
    public final zzdzc<zzcjg> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        final zzckj zzckjVar = new zzckj();
        zzdzc<zzcjg> zzdzcVarZzb = zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this, zzdnvVar, zzdogVar, zzckjVar) { // from class: com.google.android.gms.internal.ads.zzcxe
            private final zzdnv zzgnz;
            private final zzdog zzgoa;
            private final zzckj zzgob;
            private final zzcxb zzgqm;

            {
                this.zzgqm = this;
                this.zzgnz = zzdnvVar;
                this.zzgoa = zzdogVar;
                this.zzgob = zzckjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgqm.zzc(this.zzgnz, this.zzgoa, this.zzgob, obj);
            }
        }, this.zzfoc);
        zzdzcVarZzb.addListener(zzcxd.zza(zzckjVar), this.zzfoc);
        return zzdzcVarZzb;
    }

    final /* synthetic */ zzdzc zzc(final zzdnv zzdnvVar, zzdog zzdogVar, zzckj zzckjVar, Object obj) throws Exception {
        zzdzc<?> zzdzcVarZza;
        final zzbgj zzbgjVarZza = this.zzgbx.zza(this.zzfsk.zzbpf, zzdnvVar, zzdogVar.zzhew.zzeou, zzdnvVar.zzeos);
        zzbgjVarZza.zzax(zzdnvVar.zzdtp);
        zzckjVar.zzc(this.zzvr, zzbgjVarZza.getView());
        zzbcg zzbcgVar = new zzbcg();
        final zzcji zzcjiVarZza = this.zzgqi.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzcjh(new zzcxh(this.zzvr, this.zzgbx, this.zzfsk, this.zzbot, zzdnvVar, zzbcgVar, zzbgjVarZza), zzbgjVarZza));
        zzbcgVar.set(zzcjiVarZza);
        zzahx.zza(zzbgjVarZza, zzcjiVarZza.zzagp());
        zzcjiVarZza.zzafc().zza(new zzbuz(zzbgjVarZza) { // from class: com.google.android.gms.internal.ads.zzcxg
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
        zzcjiVarZza.zzafq().zzb(zzbgjVarZza, true);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwp)).booleanValue() && zzdnvVar.zzeos) {
            zzdzcVarZza = zzdyq.zzaf(null);
        } else {
            zzcjiVarZza.zzafq();
            zzdny zzdnyVar = zzdnvVar.zzhdr;
            zzdzcVarZza = zzcjv.zza(zzbgjVarZza, zzdnyVar.zzdpn, zzdnyVar.zzdpp);
        }
        return zzdyq.zzb(zzdzcVarZza, new zzdvu(this, zzbgjVarZza, zzdnvVar, zzcjiVarZza) { // from class: com.google.android.gms.internal.ads.zzcxf
            private final zzdnv zzfqn;
            private final zzbgj zzgci;
            private final zzcxb zzgqm;
            private final zzcji zzgqn;

            {
                this.zzgqm = this;
                this.zzgci = zzbgjVarZza;
                this.zzfqn = zzdnvVar;
                this.zzgqn = zzcjiVarZza;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj2) {
                zzbgj zzbgjVar = this.zzgci;
                zzdnv zzdnvVar2 = this.zzfqn;
                zzcji zzcjiVar = this.zzgqn;
                if (zzdnvVar2.zzduj) {
                    zzbgjVar.zzacj();
                }
                zzbgjVar.zzabq();
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcoc)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzp.zzkt();
                    zzazd.zza(zzbgjVar);
                }
                return zzcjiVar.zzago();
            }
        }, this.zzfoc);
    }
}
