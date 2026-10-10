package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnk implements zzeoy<zzdnj> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdoj> zzfkv;
    private final zzeph<String> zzhae;
    private final zzeph<zzdnb> zzhaf;
    private final zzeph<zzdmc> zzhag;

    public zzdnk(zzeph<String> zzephVar, zzeph<zzdnb> zzephVar2, zzeph<Context> zzephVar3, zzeph<zzdmc> zzephVar4, zzeph<zzdoj> zzephVar5) {
        this.zzhae = zzephVar;
        this.zzhaf = zzephVar2;
        this.zzesu = zzephVar3;
        this.zzhag = zzephVar4;
        this.zzfkv = zzephVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdnj(this.zzhae.get(), this.zzhaf.get(), this.zzesu.get(), this.zzhag.get(), this.zzfkv.get());
    }
}
