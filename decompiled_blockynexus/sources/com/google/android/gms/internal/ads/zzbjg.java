package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjg implements zzeoy<zzbly> {
    private final zzbja zzesn;
    private final zzeph<zzbix> zzesp;

    public zzbjg(zzbja zzbjaVar, zzeph<zzbix> zzephVar) {
        this.zzesn = zzbjaVar;
        this.zzesp = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbix zzbixVar = this.zzesp.get();
        zzepe.zza(zzbixVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbixVar;
    }
}
