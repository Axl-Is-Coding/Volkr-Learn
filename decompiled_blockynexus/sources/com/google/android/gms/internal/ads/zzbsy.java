package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbsy implements zzeoy<zzcab<zzbvs>> {
    private final zzeph<zzbtk> zzfop;
    private final zzbsj zzftg;

    private zzbsy(zzbsj zzbsjVar, zzeph<zzbtk> zzephVar) {
        this.zzftg = zzbsjVar;
        this.zzfop = zzephVar;
    }

    public static zzbsy zzc(zzbsj zzbsjVar, zzeph<zzbtk> zzephVar) {
        return new zzbsy(zzbsjVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfop.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
