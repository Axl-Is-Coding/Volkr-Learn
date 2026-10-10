package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkp implements zzccd {
    private zzbtp zzevb;
    private zzdog zzevd;
    private zzdmd zzevf;
    private zzdlf zzevg;
    private final /* synthetic */ zzbjv zzfbq;
    private zzbys zzfbr;
    private zzcyn zzfig;

    private zzbkp(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzcce> zza(zzdlf zzdlfVar) {
        this.zzevg = zzdlfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    /* JADX INFO: renamed from: zzagh, reason: merged with bridge method [inline-methods] */
    public final zzcce zzaey() {
        zzepe.zza(this.zzfbr, (Class<zzbys>) zzbys.class);
        zzepe.zza(this.zzevb, (Class<zzbtp>) zzbtp.class);
        zzepe.zza(this.zzfig, (Class<zzcyn>) zzcyn.class);
        return new zzbko(this.zzfbq, new zzbrr(), new zzdph(), new zzbsz(), new zzcni(), this.zzfbr, this.zzevb, new zzdpp(), this.zzfig, this.zzevd, this.zzevf, this.zzevg);
    }

    @Override // com.google.android.gms.internal.ads.zzccd
    public final /* synthetic */ zzccd zzb(zzcyn zzcynVar) {
        zzepe.checkNotNull(zzcynVar);
        this.zzfig = zzcynVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzccd
    public final /* synthetic */ zzccd zze(zzbtp zzbtpVar) {
        zzepe.checkNotNull(zzbtpVar);
        this.zzevb = zzbtpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzcce> zza(zzdmd zzdmdVar) {
        this.zzevf = zzdmdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzccd
    public final /* synthetic */ zzccd zze(zzbys zzbysVar) {
        zzepe.checkNotNull(zzbysVar);
        this.zzfbr = zzbysVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzcce> zza(zzdog zzdogVar) {
        this.zzevd = zzdogVar;
        return this;
    }
}
