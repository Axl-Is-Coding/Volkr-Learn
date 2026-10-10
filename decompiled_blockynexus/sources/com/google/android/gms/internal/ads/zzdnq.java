package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnq implements zzeoy<zzdnp> {
    private final zzeph<zzdoj> zzfkv;
    private final zzeph<zzdnb> zzhaf;
    private final zzeph<zzdmc> zzhag;

    public zzdnq(zzeph<zzdnb> zzephVar, zzeph<zzdmc> zzephVar2, zzeph<zzdoj> zzephVar3) {
        this.zzhaf = zzephVar;
        this.zzhag = zzephVar2;
        this.zzfkv = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdnp(this.zzhaf.get(), this.zzhag.get(), this.zzfkv.get());
    }
}
