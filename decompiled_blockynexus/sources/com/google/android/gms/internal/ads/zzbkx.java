package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkx implements zzdan {
    private zzbtp zzevb;
    private final /* synthetic */ zzbjv zzfbq;
    private zzdbd zzflx;

    private zzbkx(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final /* synthetic */ zzdan zza(zzdbd zzdbdVar) {
        zzepe.checkNotNull(zzdbdVar);
        this.zzflx = zzdbdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final zzdao zzagt() {
        zzepe.zza(this.zzevb, (Class<zzbtp>) zzbtp.class);
        zzepe.zza(this.zzflx, (Class<zzdbd>) zzdbd.class);
        return new zzbkw(this.zzfbq, this.zzflx, new zzbrr(), new zzcni(), this.zzevb, new zzdpp());
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    @Deprecated
    public final /* synthetic */ zzdan zzg(zzbys zzbysVar) {
        zzepe.checkNotNull(zzbysVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final /* synthetic */ zzdan zzg(zzbtp zzbtpVar) {
        zzepe.checkNotNull(zzbtpVar);
        this.zzevb = zzbtpVar;
        return this;
    }
}
