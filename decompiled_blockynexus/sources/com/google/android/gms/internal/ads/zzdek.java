package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdek implements zzeoy<zzdei> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;

    private zzdek(zzeph<Context> zzephVar, zzeph<zzdzb> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzdek zzba(zzeph<Context> zzephVar, zzeph<zzdzb> zzephVar2) {
        return new zzdek(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdei(this.zzesu.get(), this.zzesr.get());
    }
}
