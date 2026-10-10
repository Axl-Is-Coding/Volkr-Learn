package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcth implements zzcta<zzboh> {
    private final zzbbx zzbot;
    private final Executor zzfoc;
    private final zzdok zzfsk;
    private final zzcjt zzgbx;
    private final zzbob zzgnw;
    private final Context zzvr;

    public zzcth(zzbob zzbobVar, Context context, Executor executor, zzcjt zzcjtVar, zzdok zzdokVar, zzbbx zzbbxVar) {
        this.zzvr = context;
        this.zzgnw = zzbobVar;
        this.zzfoc = executor;
        this.zzgbx = zzcjtVar;
        this.zzfsk = zzdokVar;
        this.zzbot = zzbbxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        return (zzdnyVar == null || zzdnyVar.zzdpp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<zzboh> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        final zzckj zzckjVar = new zzckj();
        zzdzc<zzboh> zzdzcVarZzb = zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this, zzdnvVar, zzdogVar, zzckjVar) { // from class: com.google.android.gms.internal.ads.zzctk
            private final zzcth zzgny;
            private final zzdnv zzgnz;
            private final zzdog zzgoa;
            private final zzckj zzgob;

            {
                this.zzgny = this;
                this.zzgnz = zzdnvVar;
                this.zzgoa = zzdogVar;
                this.zzgob = zzckjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgny.zza(this.zzgnz, this.zzgoa, this.zzgob, obj);
            }
        }, this.zzfoc);
        zzdzcVarZzb.addListener(zzctj.zza(zzckjVar), this.zzfoc);
        return zzdzcVarZzb;
    }

    final /* synthetic */ zzdzc zza(final zzdnv zzdnvVar, zzdog zzdogVar, zzckj zzckjVar, Object obj) throws Exception {
        zzdzc<?> zzdzcVarZza;
        zzdoq.zzb(this.zzvr, zzdnvVar.zzhdt);
        final zzbgj zzbgjVarZza = this.zzgbx.zza(this.zzfsk.zzbpf, zzdnvVar, zzdogVar.zzhew.zzeou, zzdnvVar.zzeos);
        zzbgjVarZza.zzax(zzdnvVar.zzdtp);
        zzckjVar.zzc(this.zzvr, zzbgjVarZza.getView());
        zzbcg zzbcgVar = new zzbcg();
        final zzbnx zzbnxVarZza = this.zzgnw.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzcbf(new zzctn(this.zzvr, this.zzbot, zzbcgVar, zzdnvVar, zzbgjVarZza, this.zzfsk), zzbgjVarZza), new zzboa(zzbgjVarZza.getView(), zzbgjVarZza, zzdnvVar.zzfpf, zzdnvVar.zzfpg, zzdnvVar.zzfph));
        zzbnxVarZza.zzafq().zzb(zzbgjVarZza, false);
        zzbcgVar.set(zzbnxVarZza);
        zzbnxVarZza.zzafc().zza(new zzbuz(zzbgjVarZza) { // from class: com.google.android.gms.internal.ads.zzctm
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
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwp)).booleanValue() && zzdnvVar.zzeos) {
            zzdzcVarZza = zzdyq.zzaf(null);
        } else {
            zzbnxVarZza.zzafq();
            zzdny zzdnyVar = zzdnvVar.zzhdr;
            zzdzcVarZza = zzcjv.zza(zzbgjVarZza, zzdnyVar.zzdpn, zzdnyVar.zzdpp);
        }
        return zzdyq.zzb(zzdzcVarZza, new zzdvu(this, zzbgjVarZza, zzdnvVar, zzbnxVarZza) { // from class: com.google.android.gms.internal.ads.zzctl
            private final zzdnv zzfqn;
            private final zzbgj zzgci;
            private final zzcth zzgny;
            private final zzbnx zzgoc;

            {
                this.zzgny = this;
                this.zzgci = zzbgjVarZza;
                this.zzfqn = zzdnvVar;
                this.zzgoc = zzbnxVarZza;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj2) {
                zzbgj zzbgjVar = this.zzgci;
                zzdnv zzdnvVar2 = this.zzfqn;
                zzbnx zzbnxVar = this.zzgoc;
                if (zzdnvVar2.zzduj) {
                    zzbgjVar.zzacj();
                }
                zzbgjVar.zzabq();
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcoc)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzp.zzkt();
                    zzazd.zza(zzbgjVar);
                }
                return zzbnxVar.zzafp();
            }
        }, this.zzfoc);
    }
}
