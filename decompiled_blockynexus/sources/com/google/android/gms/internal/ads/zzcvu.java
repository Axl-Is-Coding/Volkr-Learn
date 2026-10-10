package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvu implements zzeoy<zzcvo> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzcgs> zzezx;
    private final zzeph<zzcda> zzgof;
    private final zzeph<zzdoz<zzcil>> zzgpq;

    public zzcvu(zzeph<zzcda> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzcgs> zzephVar3, zzeph<zzdoz<zzcil>> zzephVar4) {
        this.zzgof = zzephVar;
        this.zzesr = zzephVar2;
        this.zzezx = zzephVar3;
        this.zzgpq = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcvo(this.zzgof.get(), this.zzesr.get(), this.zzezx.get(), this.zzgpq.get());
    }
}
