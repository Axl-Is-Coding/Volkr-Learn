package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbss implements zzeoy<zzcab<com.google.android.gms.ads.internal.overlay.zzp>> {
    private final zzeph<zzbrh> zzfpj;
    private final zzbsj zzftg;

    private zzbss(zzbsj zzbsjVar, zzeph<zzbrh> zzephVar) {
        this.zzftg = zzbsjVar;
        this.zzfpj = zzephVar;
    }

    public static zzbss zza(zzbsj zzbsjVar, zzeph<zzbrh> zzephVar) {
        return new zzbss(zzbsjVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
