package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgv implements zzeoy<zzdgo> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzfth;

    private zzdgv(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzfth = zzephVar2;
    }

    public static zzdgo zza(zzdzb zzdzbVar, Context context) {
        return new zzdgo(zzdzbVar, context);
    }

    public static zzdgv zzbf(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2) {
        return new zzdgv(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzesr.get(), this.zzfth.get());
    }
}
