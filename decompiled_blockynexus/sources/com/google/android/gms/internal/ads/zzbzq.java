package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzq implements zzeoy<Set<zzcab<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbys zzfwg;

    private zzbzq(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzq zzab(zzbys zzbysVar) {
        return new zzbzq(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setEmptySet = Collections.emptySet();
        zzepe.zza(setEmptySet, "Cannot return null from a non-@Nullable @Provides method");
        return setEmptySet;
    }
}
