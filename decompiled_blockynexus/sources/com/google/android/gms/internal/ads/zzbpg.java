package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpg implements zzeoy<zzcab<zzbvs>> {
    private final zzeph<zzbqd> zzfpj;
    private final zzbot zzfqp;

    public zzbpg(zzbot zzbotVar, zzeph<zzbqd> zzephVar) {
        this.zzfqp = zzbotVar;
        this.zzfpj = zzephVar;
    }

    public static zzcab<zzbvs> zza(zzbot zzbotVar, zzbqd zzbqdVar) {
        zzcab<zzbvs> zzcabVar = new zzcab<>(zzbqdVar, zzbbz.zzeet);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfqp, this.zzfpj.get());
    }
}
