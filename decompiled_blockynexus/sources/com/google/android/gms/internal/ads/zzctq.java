package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzctq implements zzcta<zzbnv> {
    private final Executor zzfoc;
    private final zzcjt zzgbx;
    private final zzbnq zzgoh;
    private final Context zzvr;

    public zzctq(zzbnq zzbnqVar, Context context, Executor executor, zzcjt zzcjtVar) {
        this.zzvr = context;
        this.zzgoh = zzbnqVar;
        this.zzfoc = executor;
        this.zzgbx = zzcjtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        return (zzdnyVar == null || zzdnyVar.zzdpp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<zzbnv> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        return zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this, zzdogVar, zzdnvVar) { // from class: com.google.android.gms.internal.ads.zzctp
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzctq zzgog;

            {
                this.zzgog = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgog.zza(this.zzgcx, this.zzfqn, obj);
            }
        }, this.zzfoc);
    }

    final /* synthetic */ zzdzc zza(zzdog zzdogVar, zzdnv zzdnvVar, Object obj) throws Exception {
        zzvn zzvnVarZzb = zzdoq.zzb(this.zzvr, zzdnvVar.zzhdt);
        final zzbgj zzbgjVarZza = this.zzgbx.zza(zzvnVarZzb, zzdnvVar, zzdogVar.zzhew.zzeou, zzdnvVar.zzeos);
        final zzbnk zzbnkVarZza = this.zzgoh.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzbnj(zzbgjVarZza.getView(), zzbgjVarZza, zzdoq.zzf(zzvnVarZzb), zzdnvVar.zzfpf, zzdnvVar.zzfpg, zzdnvVar.zzfph));
        zzbnkVarZza.zzafq().zzb(zzbgjVarZza, false);
        zzbnkVarZza.zzafc().zza(new zzbuz(zzbgjVarZza) { // from class: com.google.android.gms.internal.ads.zzcts
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
        zzbnkVarZza.zzafq();
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        return zzdyq.zzb(zzcjv.zza(zzbgjVarZza, zzdnyVar.zzdpn, zzdnyVar.zzdpp), new zzdvu(zzbnkVarZza) { // from class: com.google.android.gms.internal.ads.zzctr
            private final zzbnk zzgoi;

            {
                this.zzgoi = zzbnkVarZza;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj2) {
                return this.zzgoi.zzafv();
            }
        }, zzbbz.zzeeu);
    }
}
