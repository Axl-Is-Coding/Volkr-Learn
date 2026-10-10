package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcx implements zzeoy<zzdcv> {
    private final zzeph<zzbsa> zzevm;
    private final zzeph<zzdpj> zzewx;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<String> zzgvp;
    private final zzeph<String> zzgvz;

    private zzdcx(zzeph<String> zzephVar, zzeph<String> zzephVar2, zzeph<zzbsa> zzephVar3, zzeph<zzdpj> zzephVar4, zzeph<zzdok> zzephVar5) {
        this.zzgvp = zzephVar;
        this.zzgvz = zzephVar2;
        this.zzevm = zzephVar3;
        this.zzewx = zzephVar4;
        this.zzfqr = zzephVar5;
    }

    public static zzdcx zzg(zzeph<String> zzephVar, zzeph<String> zzephVar2, zzeph<zzbsa> zzephVar3, zzeph<zzdpj> zzephVar4, zzeph<zzdok> zzephVar5) {
        return new zzdcx(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdcv(this.zzgvp.get(), this.zzgvz.get(), this.zzevm.get(), this.zzewx.get(), this.zzfqr.get());
    }
}
