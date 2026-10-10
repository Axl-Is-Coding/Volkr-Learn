package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbki implements zzbpl {
    private zzbtp zzevb;
    private zzdog zzevd;
    private zzccw zzeve;
    private zzdmd zzevf;
    private zzdlf zzevg;
    private final /* synthetic */ zzbjv zzfbq;
    private zzbys zzfbr;
    private zzcyn zzfig;
    private zzbqh zzfih;
    private zzbol zzfii;

    private zzbki(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpl
    public final /* synthetic */ zzbpl zza(zzbqh zzbqhVar) {
        zzepe.checkNotNull(zzbqhVar);
        this.zzfih = zzbqhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    /* JADX INFO: renamed from: zzafw, reason: merged with bridge method [inline-methods] */
    public final zzbpm zzaey() {
        zzepe.zza(this.zzfbr, (Class<zzbys>) zzbys.class);
        zzepe.zza(this.zzevb, (Class<zzbtp>) zzbtp.class);
        zzepe.zza(this.zzfig, (Class<zzcyn>) zzcyn.class);
        zzepe.zza(this.zzfih, (Class<zzbqh>) zzbqh.class);
        zzepe.zza(this.zzfii, (Class<zzbol>) zzbol.class);
        zzepe.zza(this.zzeve, (Class<zzccw>) zzccw.class);
        return new zzbkl(this.zzfbq, this.zzfii, this.zzeve, new zzbrr(), new zzdph(), new zzbsz(), new zzcni(), this.zzfbr, this.zzevb, new zzdpp(), this.zzfig, this.zzfih, this.zzevd, this.zzevf, this.zzevg);
    }

    @Override // com.google.android.gms.internal.ads.zzbpl
    public final /* synthetic */ zzbpl zzb(zzccw zzccwVar) {
        zzepe.checkNotNull(zzccwVar);
        this.zzeve = zzccwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbpl
    public final /* synthetic */ zzbpl zzc(zzbol zzbolVar) {
        zzepe.checkNotNull(zzbolVar);
        this.zzfii = zzbolVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbpl
    public final /* synthetic */ zzbpl zzd(zzbtp zzbtpVar) {
        zzepe.checkNotNull(zzbtpVar);
        this.zzevb = zzbtpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbpl
    public final /* synthetic */ zzbpl zza(zzcyn zzcynVar) {
        zzepe.checkNotNull(zzcynVar);
        this.zzfig = zzcynVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbpl
    public final /* synthetic */ zzbpl zzd(zzbys zzbysVar) {
        zzepe.checkNotNull(zzbysVar);
        this.zzfbr = zzbysVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbpm> zza(zzdlf zzdlfVar) {
        this.zzevg = zzdlfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbpm> zza(zzdmd zzdmdVar) {
        this.zzevf = zzdmdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzbpm> zza(zzdog zzdogVar) {
        this.zzevd = zzdogVar;
        return this;
    }
}
