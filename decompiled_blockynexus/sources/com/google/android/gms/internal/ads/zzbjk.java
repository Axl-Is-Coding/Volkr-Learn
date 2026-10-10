package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjk implements zzeoy<zzdoz<zzcil>> {
    private final zzeph<zzciy> zzesq;
    private final zzeph<zzdzb> zzesr;

    public zzbjk(zzeph<zzciy> zzephVar, zzeph<zzdzb> zzephVar2) {
        this.zzesq = zzephVar;
        this.zzesr = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdoz zzdozVar = new zzdoz(this.zzesq.get(), this.zzesr.get());
        zzepe.zza(zzdozVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdozVar;
    }
}
