package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyb implements zzcta<zzboq> {
    private final zzdsi zzfsl;
    private final zzbpm zzgoj;
    private final zzdzb zzgrc;
    private final Context zzgri;
    private final zzaby zzgrj;

    public zzcyb(Context context, zzbpm zzbpmVar, zzdsi zzdsiVar, zzdzb zzdzbVar, zzaby zzabyVar) {
        this.zzgri = context;
        this.zzgoj = zzbpmVar;
        this.zzfsl = zzdsiVar;
        this.zzgrc = zzdzbVar;
        this.zzgrj = zzabyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdny zzdnyVar;
        return (this.zzgrj == null || (zzdnyVar = zzdnvVar.zzhdr) == null || zzdnyVar.zzdpp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<zzboq> zzb(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzbop zzbopVarZza = this.zzgoj.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzcyg(this, new View(this.zzgri), null, zzcye.zzgrn, zzdnvVar.zzhdt.get(0)));
        zzcyf zzcyfVarZzagc = zzbopVarZza.zzagc();
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        final zzabr zzabrVar = new zzabr(zzcyfVarZzagc, zzdnyVar.zzdpn, zzdnyVar.zzdpp);
        return this.zzfsl.zzu(zzdsf.CUSTOM_RENDER_SYN).zza(new zzdrs(this, zzabrVar) { // from class: com.google.android.gms.internal.ads.zzcyd
            private final zzcyb zzgrl;
            private final zzabr zzgrm;

            {
                this.zzgrl = this;
                this.zzgrm = zzabrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdrs
            public final void run() throws Exception {
                this.zzgrl.zza(this.zzgrm);
            }
        }, this.zzgrc).zzw(zzdsf.CUSTOM_RENDER_ACK).zze(zzdyq.zzaf(zzbopVarZza.zzaga())).zzavs();
    }

    final /* synthetic */ void zza(zzabr zzabrVar) throws Exception {
        this.zzgrj.zza(zzabrVar);
    }
}
