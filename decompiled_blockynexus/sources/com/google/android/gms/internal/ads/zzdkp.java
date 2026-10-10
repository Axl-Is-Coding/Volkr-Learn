package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdkp implements zzeoy<zzdkm> {
    private final zzeph<zzbix> zzesp;
    private final zzeph<Executor> zzfqk;
    private final zzeph<Context> zzgzy;
    private final zzeph<zzdlv<zzbob, zzboh>> zzgzz;
    private final zzeph<zzdkc> zzhaa;
    private final zzeph<zzdom> zzhab;

    public zzdkp(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzbix> zzephVar3, zzeph<zzdlv<zzbob, zzboh>> zzephVar4, zzeph<zzdkc> zzephVar5, zzeph<zzdom> zzephVar6) {
        this.zzgzy = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzesp = zzephVar3;
        this.zzgzz = zzephVar4;
        this.zzhaa = zzephVar5;
        this.zzhab = zzephVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdkm(this.zzgzy.get(), this.zzfqk.get(), this.zzesp.get(), this.zzgzz.get(), this.zzhaa.get(), this.zzhab.get());
    }
}
