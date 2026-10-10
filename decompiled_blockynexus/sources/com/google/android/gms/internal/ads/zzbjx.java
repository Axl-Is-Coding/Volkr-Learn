package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbjx implements zzccz {
    private zzbtp zzevb;
    private zzdog zzevd;
    private zzccw zzeve;
    private zzdmd zzevf;
    private zzdlf zzevg;
    private final /* synthetic */ zzbjv zzfbq;
    private zzbys zzfbr;

    private zzbjx(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccz
    public final /* synthetic */ zzccz zza(zzccw zzccwVar) {
        zzepe.checkNotNull(zzccwVar);
        this.zzeve = zzccwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    /* JADX INFO: renamed from: zzaex, reason: merged with bridge method [inline-methods] */
    public final zzcda zzaey() {
        zzepe.zza(this.zzfbr, (Class<zzbys>) zzbys.class);
        zzepe.zza(this.zzevb, (Class<zzbtp>) zzbtp.class);
        zzepe.zza(this.zzeve, (Class<zzccw>) zzccw.class);
        return new zzbjw(this.zzfbq, this.zzeve, new zzbrr(), new zzdph(), new zzbsz(), new zzcni(), this.zzfbr, this.zzevb, new zzdpp(), this.zzevd, this.zzevf, this.zzevg);
    }

    @Override // com.google.android.gms.internal.ads.zzccz
    public final /* synthetic */ zzccz zza(zzbtp zzbtpVar) {
        zzepe.checkNotNull(zzbtpVar);
        this.zzevb = zzbtpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzccz
    public final /* synthetic */ zzccz zza(zzbys zzbysVar) {
        zzepe.checkNotNull(zzbysVar);
        this.zzfbr = zzbysVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzcda> zza(zzdlf zzdlfVar) {
        this.zzevg = zzdlfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzcda> zza(zzdmd zzdmdVar) {
        this.zzevf = zzdmdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final /* synthetic */ zzbtq<zzcda> zza(zzdog zzdogVar) {
        this.zzevd = zzdogVar;
        return this;
    }
}
