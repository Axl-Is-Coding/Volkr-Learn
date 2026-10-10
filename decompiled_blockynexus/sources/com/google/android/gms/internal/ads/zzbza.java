package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbza implements zzeoy<Set<zzcab<zzbxz>>> {
    private final zzbys zzfwg;

    private zzbza(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbza zzm(zzbys zzbysVar) {
        return new zzbza(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setEmptySet = Collections.emptySet();
        zzepe.zza(setEmptySet, "Cannot return null from a non-@Nullable @Provides method");
        return setEmptySet;
    }
}
