package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpa implements zzeoy<zzdnu> {
    private final zzbot zzfqp;

    public zzbpa(zzbot zzbotVar) {
        this.zzfqp = zzbotVar;
    }

    public static zzdnu zzc(zzbot zzbotVar) {
        zzdnu zzdnuVarZzaik = zzbotVar.zzaik();
        zzepe.zza(zzdnuVarZzaik, "Cannot return null from a non-@Nullable @Provides method");
        return zzdnuVarZzaik;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzc(this.zzfqp);
    }
}
