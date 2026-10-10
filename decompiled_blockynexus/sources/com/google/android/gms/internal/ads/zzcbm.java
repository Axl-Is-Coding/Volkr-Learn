package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbm implements zzeoy<Set<zzcab<zzbyc>>> {
    private final zzeph<zzbtd> zzfpj;
    private final zzcbf zzfwx;

    private zzcbm(zzcbf zzcbfVar, zzeph<zzbtd> zzephVar) {
        this.zzfwx = zzcbfVar;
        this.zzfpj = zzephVar;
    }

    public static zzcbm zzb(zzcbf zzcbfVar, zzeph<zzbtd> zzephVar) {
        return new zzcbm(zzcbfVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setSingleton = Collections.singleton(zzcab.zzb(this.zzfpj.get(), zzbbz.zzeeu));
        zzepe.zza(setSingleton, "Cannot return null from a non-@Nullable @Provides method");
        return setSingleton;
    }
}
