package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblc implements zzeoy<zzams> {
    private final zzbky zzflz;

    public zzblc(zzbky zzbkyVar) {
        this.zzflz = zzbkyVar;
    }

    public static zzams zzb(zzbky zzbkyVar) {
        zzams zzamsVarZzaen = zzbkyVar.zzaen();
        zzepe.zza(zzamsVarZzaen, "Cannot return null from a non-@Nullable @Provides method");
        return zzamsVarZzaen;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzflz);
    }
}
