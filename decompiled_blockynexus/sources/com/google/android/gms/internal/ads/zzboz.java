package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzboz implements zzeoy<zzbql> {
    private final zzbot zzfqp;

    public zzboz(zzbot zzbotVar) {
        this.zzfqp = zzbotVar;
    }

    public static zzbql zzb(zzbot zzbotVar) {
        zzbql zzbqlVarZzaij = zzbotVar.zzaij();
        zzepe.zza(zzbqlVarZzaij, "Cannot return null from a non-@Nullable @Provides method");
        return zzbqlVarZzaij;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzfqp);
    }
}
