package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzclo implements zzeoy<Set<zzcab<zzdso>>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcme> zzfop;

    private zzclo(zzeph<Executor> zzephVar, zzeph<zzcme> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzfop = zzephVar2;
    }

    public static zzclo zzaf(zzeph<Executor> zzephVar, zzeph<zzcme> zzephVar2) {
        return new zzclo(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Executor executor = this.zzesr.get();
        Set setSingleton = ((Boolean) zzwm.zzpx().zzd(zzabb.zzctw)).booleanValue() ? Collections.singleton(new zzcab(this.zzfop.get(), executor)) : Collections.emptySet();
        zzepe.zza(setSingleton, "Cannot return null from a non-@Nullable @Provides method");
        return setSingleton;
    }
}
