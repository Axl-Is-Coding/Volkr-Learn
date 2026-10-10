package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjb implements zzeoy<zzayb> {
    private final zzbja zzesn;

    public zzbjb(zzbja zzbjaVar) {
        this.zzesn = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzayb zzaybVarZzkv = com.google.android.gms.ads.internal.zzp.zzkv();
        zzepe.zza(zzaybVarZzkv, "Cannot return null from a non-@Nullable @Provides method");
        return zzaybVarZzkv;
    }
}
