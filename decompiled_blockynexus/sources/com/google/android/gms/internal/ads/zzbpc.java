package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpc implements zzeoy<zzboq> {
    private final zzeph<zzbos> zzfjd;
    private final zzbot zzfqp;

    public zzbpc(zzbot zzbotVar, zzeph<zzbos> zzephVar) {
        this.zzfqp = zzbotVar;
        this.zzfjd = zzephVar;
    }

    public static zzboq zza(zzbot zzbotVar, Object obj) {
        zzbos zzbosVar = (zzbos) obj;
        zzepe.zza(zzbosVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbosVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfqp, this.zzfjd.get());
    }
}
