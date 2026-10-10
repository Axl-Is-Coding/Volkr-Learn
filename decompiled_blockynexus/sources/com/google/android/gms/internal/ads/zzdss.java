package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdss implements zzeoy<zzamb> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfup;
    private final zzdsp zzhlm;

    public zzdss(zzdsp zzdspVar, zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2) {
        this.zzhlm = zzdspVar;
        this.zzesu = zzephVar;
        this.zzfup = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzamb zzambVarZzb = new zzalw().zzb(this.zzesu.get(), this.zzfup.get());
        zzepe.zza(zzambVarZzb, "Cannot return null from a non-@Nullable @Provides method");
        return zzambVarZzb;
    }
}
