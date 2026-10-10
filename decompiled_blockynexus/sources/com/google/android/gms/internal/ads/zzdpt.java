package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpt implements zzeoy<zzayi> {
    private final zzdpp zzhgo;
    private final zzeph<zzdpn> zzhgq;

    private zzdpt(zzdpp zzdppVar, zzeph<zzdpn> zzephVar) {
        this.zzhgo = zzdppVar;
        this.zzhgq = zzephVar;
    }

    public static zzdpt zzb(zzdpp zzdppVar, zzeph<zzdpn> zzephVar) {
        return new zzdpt(zzdppVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzayi zzayiVar = this.zzhgq.get().zzdyh;
        zzepe.zza(zzayiVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzayiVar;
    }
}
