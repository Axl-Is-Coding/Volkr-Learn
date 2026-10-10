package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjl implements zzeoy<zzbbx> {
    private final zzbja zzesn;

    public zzbjl(zzbja zzbjaVar) {
        this.zzesn = zzbjaVar;
    }

    public static zzbbx zzb(zzbja zzbjaVar) {
        zzbbx zzbbxVarZzaed = zzbjaVar.zzaed();
        zzepe.zza(zzbbxVarZzaed, "Cannot return null from a non-@Nullable @Provides method");
        return zzbbxVarZzaed;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzesn);
    }
}
