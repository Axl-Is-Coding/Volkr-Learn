package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgk implements zzeoy<zzdgi> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfmh;

    private zzdgk(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2, zzeph<zzbbx> zzephVar3) {
        this.zzesr = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfmh = zzephVar3;
    }

    public static zzdgk zzw(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2, zzeph<zzbbx> zzephVar3) {
        return new zzdgk(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdgi(this.zzesr.get(), this.zzesu.get(), this.zzfmh.get());
    }
}
