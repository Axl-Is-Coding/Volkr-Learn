package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwo implements zzeoy<zzcwl> {
    private final zzeph<zzckp> zzetd;
    private final zzeph<zzdow> zzeuo;
    private final zzeph<zzcmu> zzeup;

    private zzcwo(zzeph<zzdow> zzephVar, zzeph<zzckp> zzephVar2, zzeph<zzcmu> zzephVar3) {
        this.zzeuo = zzephVar;
        this.zzetd = zzephVar2;
        this.zzeup = zzephVar3;
    }

    public static zzcwo zzq(zzeph<zzdow> zzephVar, zzeph<zzckp> zzephVar2, zzeph<zzcmu> zzephVar3) {
        return new zzcwo(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcwl(this.zzeuo.get(), this.zzetd.get(), this.zzeup.get());
    }
}
