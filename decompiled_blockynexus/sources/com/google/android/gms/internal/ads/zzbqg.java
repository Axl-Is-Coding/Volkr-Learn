package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqg implements zzeoy<zzbqd> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzbgj> zzfqh;
    private final zzeph<zzdnv> zzfrj;

    public zzbqg(zzeph<Context> zzephVar, zzeph<zzbgj> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzbbx> zzephVar4) {
        this.zzesu = zzephVar;
        this.zzfqh = zzephVar2;
        this.zzfrj = zzephVar3;
        this.zzfmh = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbqd(this.zzesu.get(), this.zzfqh.get(), this.zzfrj.get(), this.zzfmh.get());
    }
}
