package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzl implements zzeoy<Set<zzcab<zzcak>>> {
    private final zzbys zzfwg;

    private zzbzl(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzl zzy(zzbys zzbysVar) {
        return new zzbzl(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setEmptySet = Collections.emptySet();
        zzepe.zza(setEmptySet, "Cannot return null from a non-@Nullable @Provides method");
        return setEmptySet;
    }
}
