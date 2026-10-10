package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyk<AdT> implements zzcta<AdT> {
    private final zzdsi zzfsl;
    private final zzdzb zzgrc;
    private final zzaby zzgrj;
    private final zzcyl<AdT> zzgrs;

    public zzcyk(zzdsi zzdsiVar, zzdzb zzdzbVar, zzaby zzabyVar, zzcyl<AdT> zzcylVar) {
        this.zzfsl = zzdsiVar;
        this.zzgrc = zzdzbVar;
        this.zzgrj = zzabyVar;
        this.zzgrs = zzcylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdny zzdnyVar;
        return (this.zzgrj == null || (zzdnyVar = zzdnvVar.zzhdr) == null || zzdnyVar.zzdpp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<AdT> zzb(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzbcg zzbcgVar = new zzbcg();
        zzcys zzcysVar = new zzcys();
        zzcysVar.zza(new zzcym(this, zzbcgVar, zzdogVar, zzdnvVar, zzcysVar));
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        final zzabr zzabrVar = new zzabr(zzcysVar, zzdnyVar.zzdpn, zzdnyVar.zzdpp);
        return this.zzfsl.zzu(zzdsf.CUSTOM_RENDER_SYN).zza(new zzdrs(this, zzabrVar) { // from class: com.google.android.gms.internal.ads.zzcyj
            private final zzabr zzgrm;
            private final zzcyk zzgrr;

            {
                this.zzgrr = this;
                this.zzgrm = zzabrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdrs
            public final void run() throws Exception {
                this.zzgrr.zzb(this.zzgrm);
            }
        }, this.zzgrc).zzw(zzdsf.CUSTOM_RENDER_ACK).zze(zzbcgVar).zzavs();
    }

    final /* synthetic */ void zzb(zzabr zzabrVar) throws Exception {
        this.zzgrj.zza(zzabrVar);
    }
}
