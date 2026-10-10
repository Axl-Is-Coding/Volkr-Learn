package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdc implements zzeoy<Set<String>> {
    private final zzeph<zzcep> zzfqj;

    public zzcdc(zzeph<zzcep> zzephVar) {
        this.zzfqj = zzephVar;
    }

    public static Set<String> zza(zzcep zzcepVar) {
        Set<String> setSingleton = zzcepVar.zzams() != null ? Collections.singleton("banner") : Collections.emptySet();
        zzepe.zza(setSingleton, "Cannot return null from a non-@Nullable @Provides method");
        return setSingleton;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfqj.get());
    }
}
