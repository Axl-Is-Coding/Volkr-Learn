package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbv implements zzeoy<Set<zzcab<zzbzy>>> {
    private final zzeph<zzccq> zzfpj;

    private zzcbv(zzeph<zzccq> zzephVar) {
        this.zzfpj = zzephVar;
    }

    public static zzcbv zzw(zzeph<zzccq> zzephVar) {
        return new zzcbv(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setSingleton = Collections.singleton(zzcab.zzb(this.zzfpj.get(), zzbbz.zzeeu));
        zzepe.zza(setSingleton, "Cannot return null from a non-@Nullable @Provides method");
        return setSingleton;
    }
}
