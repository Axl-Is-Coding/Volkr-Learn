package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfa implements zzeoy<zzcei> {
    private final zzceu zzgar;

    private zzcfa(zzceu zzceuVar) {
        this.zzgar = zzceuVar;
    }

    public static zzcfa zzb(zzceu zzceuVar) {
        return new zzcfa(zzceuVar);
    }

    public static zzcei zzc(zzceu zzceuVar) {
        zzcei zzceiVarZzamy = zzceuVar.zzamy();
        zzepe.zza(zzceiVarZzamy, "Cannot return null from a non-@Nullable @Provides method");
        return zzceiVarZzamy;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzc(this.zzgar);
    }
}
