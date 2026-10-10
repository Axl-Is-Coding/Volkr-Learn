package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdeg implements zzeoy<zzdec> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzfth;

    private zzdeg(zzeph<Context> zzephVar, zzeph<zzdzb> zzephVar2) {
        this.zzfth = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzdec zza(Context context, zzdzb zzdzbVar) {
        return new zzdec(context, zzdzbVar);
    }

    public static zzdeg zzaz(zzeph<Context> zzephVar, zzeph<zzdzb> zzephVar2) {
        return new zzdeg(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfth.get(), this.zzesr.get());
    }
}
