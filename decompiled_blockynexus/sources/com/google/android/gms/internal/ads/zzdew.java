package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdew implements zzeoy<zzdeu> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzdnt> zzgox;

    private zzdew(zzeph<zzdzb> zzephVar, zzeph<zzdnt> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzgox = zzephVar2;
    }

    public static zzdew zzbb(zzeph<zzdzb> zzephVar, zzeph<zzdnt> zzephVar2) {
        return new zzdew(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdeu(this.zzesr.get(), this.zzgox.get());
    }
}
