package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcnl implements zzeoy<Set<zzcab<zzbws>>> {
    public static Set<zzcab<zzbws>> zza(zzcni zzcniVar, zzcns zzcnsVar, Executor executor) {
        Set<zzcab<zzbws>> setZzi = zzcni.zzi(zzcnsVar, executor);
        zzepe.zza(setZzi, "Cannot return null from a non-@Nullable @Provides method");
        return setZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
