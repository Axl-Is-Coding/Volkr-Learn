package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdng implements zzeoy<zzdnb> {
    private final zzeph<zzbix> zzesp;
    private final zzeph<zzdoj> zzfkv;
    private final zzeph<Executor> zzfqk;
    private final zzeph<Context> zzgzy;
    private final zzeph<zzdlv<zzcjj, zzcjg>> zzgzz;
    private final zzeph<zzdmc> zzhaa;
    private final zzeph<zzdom> zzhab;

    public zzdng(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzbix> zzephVar3, zzeph<zzdlv<zzcjj, zzcjg>> zzephVar4, zzeph<zzdmc> zzephVar5, zzeph<zzdom> zzephVar6, zzeph<zzdoj> zzephVar7) {
        this.zzgzy = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzesp = zzephVar3;
        this.zzgzz = zzephVar4;
        this.zzhaa = zzephVar5;
        this.zzhab = zzephVar6;
        this.zzfkv = zzephVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdnb(this.zzgzy.get(), this.zzfqk.get(), this.zzesp.get(), this.zzgzz.get(), this.zzhaa.get(), this.zzhab.get(), this.zzfkv.get());
    }
}
