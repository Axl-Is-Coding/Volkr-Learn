package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmh implements zzeoy<zzcmi> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdow> zzeuo;
    private final zzeph<zzcmu> zzeup;
    private final zzeph<zzdnv> zzfno;
    private final zzeph<zzdog> zzggx;
    private final zzeph<zzcsp> zzggy;

    private zzcmh(zzeph<Context> zzephVar, zzeph<zzdow> zzephVar2, zzeph<zzcmu> zzephVar3, zzeph<zzdog> zzephVar4, zzeph<zzdnv> zzephVar5, zzeph<zzcsp> zzephVar6) {
        this.zzesu = zzephVar;
        this.zzeuo = zzephVar2;
        this.zzeup = zzephVar3;
        this.zzggx = zzephVar4;
        this.zzfno = zzephVar5;
        this.zzggy = zzephVar6;
    }

    public static zzcmh zza(zzeph<Context> zzephVar, zzeph<zzdow> zzephVar2, zzeph<zzcmu> zzephVar3, zzeph<zzdog> zzephVar4, zzeph<zzdnv> zzephVar5, zzeph<zzcsp> zzephVar6) {
        return new zzcmh(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcmi(this.zzesu.get(), this.zzeuo.get(), this.zzeup.get(), this.zzggx.get(), this.zzfno.get(), this.zzggy.get());
    }
}
