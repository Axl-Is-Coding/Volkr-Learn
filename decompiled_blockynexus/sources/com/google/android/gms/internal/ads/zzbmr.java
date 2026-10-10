package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmr implements zzeoy<zzbms> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzqo> zzfnv;

    private zzbmr(zzeph<Context> zzephVar, zzeph<zzqo> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzfnv = zzephVar2;
    }

    public static zzbmr zza(zzeph<Context> zzephVar, zzeph<zzqo> zzephVar2) {
        return new zzbmr(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbms(this.zzesu.get(), this.zzfnv.get());
    }
}
