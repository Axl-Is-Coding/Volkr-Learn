package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbs implements zzeoy<Set<zzcab<zzbuh>>> {
    private final zzeph<zzbtd> zzfpj;
    private final zzcbf zzfwx;

    private zzcbs(zzcbf zzcbfVar, zzeph<zzbtd> zzephVar) {
        this.zzfwx = zzcbfVar;
        this.zzfpj = zzephVar;
    }

    public static zzcbs zze(zzcbf zzcbfVar, zzeph<zzbtd> zzephVar) {
        return new zzcbs(zzcbfVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzbuh>> setZzb = this.zzfwx.zzb(this.zzfpj.get());
        zzepe.zza(setZzb, "Cannot return null from a non-@Nullable @Provides method");
        return setZzb;
    }
}
