package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcom implements zzeoy<zzcoi> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzdzb> zzgjg;
    private final zzeph<zzcpt> zzgjh;
    private final zzeph<zzcqv> zzgji;

    private zzcom(zzeph<zzdzb> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzcpt> zzephVar3, zzeph<zzcqv> zzephVar4) {
        this.zzgjg = zzephVar;
        this.zzesr = zzephVar2;
        this.zzgjh = zzephVar3;
        this.zzgji = zzephVar4;
    }

    public static zzcom zzd(zzeph<zzdzb> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzcpt> zzephVar3, zzeph<zzcqv> zzephVar4) {
        return new zzcom(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcoi(this.zzgjg.get(), this.zzesr.get(), this.zzgjh.get(), zzeov.zzat(this.zzgji));
    }
}
