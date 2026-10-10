package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjh implements zzeoy<zzctb<zzdpa, zzcut>> {
    private final zzbja zzesn;
    private final zzeph<zzcku> zzeso;

    public zzbjh(zzbja zzbjaVar, zzeph<zzcku> zzephVar) {
        this.zzesn = zzbjaVar;
        this.zzeso = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcxc zzcxcVar = new zzcxc(this.zzeso.get());
        zzepe.zza(zzcxcVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcxcVar;
    }
}
