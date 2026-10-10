package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfr implements zzeoy<zzcfm> {
    private final zzeph<zzceq> zzfeg;
    private final zzeph<zzcil> zzffj;
    private final zzeph<zzcjt> zzgbz;
    private final zzeph<zzbnd> zzgca;

    public zzcfr(zzeph<zzcjt> zzephVar, zzeph<zzcil> zzephVar2, zzeph<zzbnd> zzephVar3, zzeph<zzceq> zzephVar4) {
        this.zzgbz = zzephVar;
        this.zzffj = zzephVar2;
        this.zzgca = zzephVar3;
        this.zzfeg = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcfm(this.zzgbz.get(), this.zzffj.get(), this.zzgca.get(), this.zzfeg.get());
    }
}
