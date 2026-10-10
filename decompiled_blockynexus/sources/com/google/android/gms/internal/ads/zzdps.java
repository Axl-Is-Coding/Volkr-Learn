package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdps implements zzeoy<zzayr> {
    private final zzdpp zzhgo;
    private final zzeph<zzdpn> zzhgq;

    private zzdps(zzdpp zzdppVar, zzeph<zzdpn> zzephVar) {
        this.zzhgo = zzdppVar;
        this.zzhgq = zzephVar;
    }

    public static zzdps zza(zzdpp zzdppVar, zzeph<zzdpn> zzephVar) {
        return new zzdps(zzdppVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzhgo, this.zzhgq.get());
    }

    public static zzayr zza(zzdpp zzdppVar, zzdpn zzdpnVar) {
        zzayr zzayrVar = zzdpnVar.zzdzr;
        zzepe.zza(zzayrVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzayrVar;
    }
}
