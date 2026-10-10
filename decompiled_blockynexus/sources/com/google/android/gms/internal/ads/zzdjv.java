package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdjv implements zzeoy<zzdjo> {
    private final zzeph<zzbix> zzesp;
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<String> zzhae;
    private final zzeph<zzdjm> zzhaf;
    private final zzeph<zzdkc> zzhag;

    public zzdjv(zzeph<zzbix> zzephVar, zzeph<Context> zzephVar2, zzeph<String> zzephVar3, zzeph<zzdjm> zzephVar4, zzeph<zzdkc> zzephVar5, zzeph<zzbbx> zzephVar6) {
        this.zzesp = zzephVar;
        this.zzesu = zzephVar2;
        this.zzhae = zzephVar3;
        this.zzhaf = zzephVar4;
        this.zzhag = zzephVar5;
        this.zzfov = zzephVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdjo(this.zzesp.get(), this.zzesu.get(), this.zzhae.get(), this.zzhaf.get(), this.zzhag.get(), this.zzfov.get());
    }
}
