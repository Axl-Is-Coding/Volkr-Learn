package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkf implements zzbnp {
    private zzbtp zzevb;
    private zzdog zzevd;
    private zzdmd zzevf;
    private zzdlf zzevg;
    private final /* synthetic */ zzbjv zzfbq;
    private zzbys zzfbr;

    private zzbkf(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbnq> zza(zzdlf zzdlfVar) {
        this.zzevg = zzdlfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbnq zzaey() {
        zzepe.zza(this.zzfbr, (Class<zzbys>) zzbys.class);
        zzepe.zza(this.zzevb, (Class<zzbtp>) zzbtp.class);
        return new zzbke(this.zzfbq, new zzbrr(), new zzdph(), new zzbsz(), new zzcni(), this.zzfbr, this.zzevb, new zzdpp(), this.zzevd, this.zzevf, this.zzevg);
    }

    @Override // com.google.android.gms.internal.ads.zzbnp
    @Deprecated
    public final /* synthetic */ zzbnp zzb(zzbol zzbolVar) {
        zzepe.checkNotNull(zzbolVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbnp
    public final /* synthetic */ zzbnp zzc(zzbtp zzbtpVar) {
        zzepe.checkNotNull(zzbtpVar);
        this.zzevb = zzbtpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbnq> zza(zzdmd zzdmdVar) {
        this.zzevf = zzdmdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbnp
    public final /* synthetic */ zzbnp zzc(zzbys zzbysVar) {
        zzepe.checkNotNull(zzbysVar);
        this.zzfbr = zzbysVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbnq> zza(zzdog zzdogVar) {
        this.zzevd = zzdogVar;
        return this;
    }
}
