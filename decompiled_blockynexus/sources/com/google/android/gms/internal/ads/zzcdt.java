package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdt implements zzeoy<zzcab<zzbuz>> {
    private final zzeph<zzcgb> zzfpj;
    private final zzcdl zzfyp;

    public zzcdt(zzcdl zzcdlVar, zzeph<zzcgb> zzephVar) {
        this.zzfyp = zzcdlVar;
        this.zzfpj = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfpj.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
