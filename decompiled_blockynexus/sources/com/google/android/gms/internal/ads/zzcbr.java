package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbr implements zzeoy<zzawp> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdok> zzfqr;
    private final zzcbf zzfwx;

    private zzcbr(zzcbf zzcbfVar, zzeph<Context> zzephVar, zzeph<zzdok> zzephVar2) {
        this.zzfwx = zzcbfVar;
        this.zzesu = zzephVar;
        this.zzfqr = zzephVar2;
    }

    public static zzcbr zza(zzcbf zzcbfVar, zzeph<Context> zzephVar, zzeph<zzdok> zzephVar2) {
        return new zzcbr(zzcbfVar, zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzawp zzawpVar = new zzawp(this.zzesu.get(), this.zzfqr.get().zzhfb);
        zzepe.zza(zzawpVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzawpVar;
    }
}
