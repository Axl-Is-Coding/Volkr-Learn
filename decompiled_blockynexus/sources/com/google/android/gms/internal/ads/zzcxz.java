package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbvp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxz<AdT, AdapterT, ListenerT extends zzbvp> implements zzeoy<zzcxv<AdT, AdapterT, ListenerT>> {
    private final zzeph<zzctb<AdapterT, ListenerT>> zzfmi;
    private final zzeph<zzdzb> zzfqk;
    private final zzeph<zzdsi> zzfqv;
    private final zzeph<zzcti<AdT, AdapterT, ListenerT>> zzgre;

    private zzcxz(zzeph<zzdsi> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzctb<AdapterT, ListenerT>> zzephVar3, zzeph<zzcti<AdT, AdapterT, ListenerT>> zzephVar4) {
        this.zzfqv = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzfmi = zzephVar3;
        this.zzgre = zzephVar4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbvp> zzcxz<AdT, AdapterT, ListenerT> zzf(zzeph<zzdsi> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzctb<AdapterT, ListenerT>> zzephVar3, zzeph<zzcti<AdT, AdapterT, ListenerT>> zzephVar4) {
        return new zzcxz<>(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcxv(this.zzfqv.get(), this.zzfqk.get(), this.zzfmi.get(), this.zzgre.get());
    }
}
