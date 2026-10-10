package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtc implements zzeoy<zzcab<zzbws>> {
    private final zzeph<zzbsx> zzfop;
    private final zzbsz zzftj;

    private zzbtc(zzbsz zzbszVar, zzeph<zzbsx> zzephVar) {
        this.zzftj = zzbszVar;
        this.zzfop = zzephVar;
    }

    public static zzbtc zza(zzbsz zzbszVar, zzeph<zzbsx> zzephVar) {
        return new zzbtc(zzbszVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfop.get(), zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
