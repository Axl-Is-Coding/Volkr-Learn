package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgt implements zzeoy<zzcgs> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzcgw> zzgdc;
    private final zzeph<zzchg> zzgdd;

    public zzcgt(zzeph<zzdzb> zzephVar, zzeph<zzcgw> zzephVar2, zzeph<zzchg> zzephVar3) {
        this.zzesr = zzephVar;
        this.zzgdc = zzephVar2;
        this.zzgdd = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcgs(this.zzesr.get(), this.zzgdc.get(), this.zzgdd.get());
    }
}
