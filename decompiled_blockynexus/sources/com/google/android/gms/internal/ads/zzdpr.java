package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpr implements zzeoy<zzdpn> {
    private final zzeph<zzdpl> zzfoh;
    private final zzdpp zzhgo;
    private final zzeph<String> zzhgp;

    private zzdpr(zzdpp zzdppVar, zzeph<zzdpl> zzephVar, zzeph<String> zzephVar2) {
        this.zzhgo = zzdppVar;
        this.zzfoh = zzephVar;
        this.zzhgp = zzephVar2;
    }

    public static zzdpr zza(zzdpp zzdppVar, zzeph<zzdpl> zzephVar, zzeph<String> zzephVar2) {
        return new zzdpr(zzdppVar, zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdpn zzdpnVarZzgv = this.zzfoh.get().zzgv(this.zzhgp.get());
        zzepe.zza(zzdpnVarZzgv, "Cannot return null from a non-@Nullable @Provides method");
        return zzdpnVarZzgv;
    }
}
