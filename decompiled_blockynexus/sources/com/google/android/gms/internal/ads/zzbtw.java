package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtw implements zzeoy<zzdok> {
    private final zzbtp zzfuk;

    private zzbtw(zzbtp zzbtpVar) {
        this.zzfuk = zzbtpVar;
    }

    public static zzbtw zzl(zzbtp zzbtpVar) {
        return new zzbtw(zzbtpVar);
    }

    public static zzdok zzm(zzbtp zzbtpVar) {
        zzdok zzdokVarZzajr = zzbtpVar.zzajr();
        zzepe.zza(zzdokVarZzajr, "Cannot return null from a non-@Nullable @Provides method");
        return zzdokVarZzajr;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzm(this.zzfuk);
    }
}
