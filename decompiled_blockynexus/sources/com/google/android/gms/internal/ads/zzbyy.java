package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyy implements zzeoy<Set<zzcab<zzbvs>>> {
    private final zzbys zzfwg;

    private zzbyy(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbyy zzj(zzbys zzbysVar) {
        return new zzbyy(zzbysVar);
    }

    public static Set<zzcab<zzbvs>> zzk(zzbys zzbysVar) {
        Set<zzcab<zzbvs>> setEmptySet = Collections.emptySet();
        zzepe.zza(setEmptySet, "Cannot return null from a non-@Nullable @Provides method");
        return setEmptySet;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzk(this.zzfwg);
    }
}
