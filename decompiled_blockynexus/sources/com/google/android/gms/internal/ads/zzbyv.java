package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyv implements zzeoy<Set<zzcab<zzbuy>>> {
    private final zzbys zzfwg;

    private zzbyv(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbyv zzh(zzbys zzbysVar) {
        return new zzbyv(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setEmptySet = Collections.emptySet();
        zzepe.zza(setEmptySet, "Cannot return null from a non-@Nullable @Provides method");
        return setEmptySet;
    }
}
