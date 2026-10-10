package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnl implements zzeoy<Set<zzcab<zzbvs>>> {
    private final zzbnj zzfpi;
    private final zzeph<zzbqf> zzfpj;

    public zzbnl(zzbnj zzbnjVar, zzeph<zzbqf> zzephVar) {
        this.zzfpi = zzbnjVar;
        this.zzfpj = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setSingleton = Collections.singleton(new zzcab(this.zzfpj.get(), zzbbz.zzeeu));
        zzepe.zza(setSingleton, "Cannot return null from a non-@Nullable @Provides method");
        return setSingleton;
    }
}
