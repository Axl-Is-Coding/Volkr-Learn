package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpk implements zzeoy<zzcab<zzbxz>> {
    private final zzbot zzfqp;
    private final zzeph<zzbwk> zzfqs;

    public zzbpk(zzbot zzbotVar, zzeph<zzbwk> zzephVar) {
        this.zzfqp = zzbotVar;
        this.zzfqs = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        final zzbwk zzbwkVar = this.zzfqs.get();
        zzcab zzcabVar = new zzcab(new zzbxz(zzbwkVar) { // from class: com.google.android.gms.internal.ads.zzbov
            private final zzbwk zzfql;

            {
                this.zzfql = zzbwkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxz
            public final void zzail() {
                this.zzfql.zzajz();
            }
        }, zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
