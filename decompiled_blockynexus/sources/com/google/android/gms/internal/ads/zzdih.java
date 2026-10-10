package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdih implements zzeoy<zzdif> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zztg> zzetv;

    public zzdih(zzeph<zztg> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<Context> zzephVar3) {
        this.zzetv = zzephVar;
        this.zzesr = zzephVar2;
        this.zzesu = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdif(this.zzetv.get(), this.zzesr.get(), this.zzesu.get());
    }
}
