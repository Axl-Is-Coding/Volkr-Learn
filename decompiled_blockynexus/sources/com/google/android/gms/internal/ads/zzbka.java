package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbka implements zzboe {
    private zzbtp zzevb;
    private zzdog zzevd;
    private zzdmd zzevf;
    private zzdlf zzevg;
    private final /* synthetic */ zzbjv zzfbq;
    private zzbys zzfbr;

    private zzbka(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    @Deprecated
    public final /* synthetic */ zzboe zza(zzbol zzbolVar) {
        zzepe.checkNotNull(zzbolVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbob zzaey() {
        zzepe.zza(this.zzfbr, (Class<zzbys>) zzbys.class);
        zzepe.zza(this.zzevb, (Class<zzbtp>) zzbtp.class);
        return new zzbkd(this.zzfbq, new zzbrr(), new zzdph(), new zzbsz(), new zzcni(), this.zzfbr, this.zzevb, new zzdpp(), this.zzevd, this.zzevf, this.zzevg);
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe zzb(zzbtp zzbtpVar) {
        zzepe.checkNotNull(zzbtpVar);
        this.zzevb = zzbtpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbob> zza(zzdlf zzdlfVar) {
        this.zzevg = zzdlfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzboe
    public final /* synthetic */ zzboe zzb(zzbys zzbysVar) {
        zzepe.checkNotNull(zzbysVar);
        this.zzfbr = zzbysVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbob> zza(zzdmd zzdmdVar) {
        this.zzevf = zzdmdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbob> zza(zzdog zzdogVar) {
        this.zzevd = zzdogVar;
        return this;
    }
}
