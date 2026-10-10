package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzctt implements zzcta<zzboq> {
    private final Executor zzfoc;
    private final zzdok zzfsk;
    private final zzcjt zzgbx;
    private final zzbpm zzgoj;
    private final zzdvu<zzdnv, zzazp> zzgok;
    private final Context zzvr;

    public zzctt(zzbpm zzbpmVar, Context context, Executor executor, zzcjt zzcjtVar, zzdok zzdokVar, zzdvu<zzdnv, zzazp> zzdvuVar) {
        this.zzvr = context;
        this.zzgoj = zzbpmVar;
        this.zzfoc = executor;
        this.zzgbx = zzcjtVar;
        this.zzfsk = zzdokVar;
        this.zzgok = zzdvuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        return (zzdnyVar == null || zzdnyVar.zzdpp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<zzboq> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        return zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this, zzdogVar, zzdnvVar) { // from class: com.google.android.gms.internal.ads.zzctw
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzctt zzgol;

            {
                this.zzgol = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgol.zzb(this.zzgcx, this.zzfqn, obj);
            }
        }, this.zzfoc);
    }

    final /* synthetic */ void zzo(zzbgj zzbgjVar) {
        zzbgjVar.zzabq();
        zzbhd zzbhdVarZzzs = zzbgjVar.zzzs();
        zzaak zzaakVar = this.zzfsk.zzhez;
        if (zzaakVar == null || zzbhdVarZzzs == null) {
            return;
        }
        zzbhdVarZzzs.zzb(zzaakVar);
    }

    final /* synthetic */ zzdzc zzb(zzdog zzdogVar, zzdnv zzdnvVar, Object obj) throws Exception {
        View zzckkVar;
        zzvn zzvnVarZzb = zzdoq.zzb(this.zzvr, zzdnvVar.zzhdt);
        final zzbgj zzbgjVarZza = this.zzgbx.zza(zzvnVarZzb, zzdnvVar, zzdogVar.zzhew.zzeou, zzdnvVar.zzeos);
        zzbgjVarZza.zzax(zzdnvVar.zzdtp);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxu)).booleanValue() && zzdnvVar.zzhei) {
            zzckkVar = zzbqe.zza(this.zzvr, zzbgjVarZza.getView(), zzdnvVar);
        } else {
            zzckkVar = new zzckk(this.zzvr, zzbgjVarZza.getView(), this.zzgok.apply(zzdnvVar));
        }
        zzbpm zzbpmVar = this.zzgoj;
        zzbre zzbreVar = new zzbre(zzdogVar, zzdnvVar, null);
        zzbgjVarZza.getClass();
        final zzbop zzbopVarZza = zzbpmVar.zza(zzbreVar, new zzbot(zzckkVar, zzbgjVarZza, zzctv.zzp(zzbgjVarZza), zzdoq.zzf(zzvnVarZzb)));
        zzbopVarZza.zzafq().zzb(zzbgjVarZza, false);
        zzbopVarZza.zzafc().zza(new zzbuz(zzbgjVarZza) { // from class: com.google.android.gms.internal.ads.zzcty
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
        zzbopVarZza.zzafq();
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        zzdzc<?> zzdzcVarZza = zzcjv.zza(zzbgjVarZza, zzdnyVar.zzdpn, zzdnyVar.zzdpp);
        if (zzdnvVar.zzduj) {
            zzbgjVarZza.getClass();
            zzdzcVarZza.addListener(zzctx.zzh(zzbgjVarZza), this.zzfoc);
        }
        zzdzcVarZza.addListener(new Runnable(this, zzbgjVarZza) { // from class: com.google.android.gms.internal.ads.zzcua
            private final zzbgj zzgci;
            private final zzctt zzgol;

            {
                this.zzgol = this;
                this.zzgci = zzbgjVarZza;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgol.zzo(this.zzgci);
            }
        }, this.zzfoc);
        return zzdyq.zzb(zzdzcVarZza, new zzdvu(zzbopVarZza) { // from class: com.google.android.gms.internal.ads.zzctz
            private final zzbop zzgom;

            {
                this.zzgom = zzbopVarZza;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj2) {
                return this.zzgom.zzaga();
            }
        }, zzbbz.zzeeu);
    }
}
