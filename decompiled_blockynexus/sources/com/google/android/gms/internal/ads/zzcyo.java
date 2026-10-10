package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyo<AdT> implements zzeoy<zzcyk<AdT>> {
    private final zzeph<zzdzb> zzfqk;
    private final zzeph<zzdsi> zzfqv;
    private final zzeph<zzaby> zzgrq;
    private final zzeph<zzcyl<AdT>> zzgrx;

    public zzcyo(zzeph<zzdsi> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzaby> zzephVar3, zzeph<zzcyl<AdT>> zzephVar4) {
        this.zzfqv = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzgrq = zzephVar3;
        this.zzgrx = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcyk(this.zzfqv.get(), this.zzfqk.get(), this.zzgrq.get(), this.zzgrx.get());
    }
}
