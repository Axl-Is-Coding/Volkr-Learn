package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbw implements zzeoy<Set<zzcab<zzbzu>>> {
    public static Set<zzcab<zzbzu>> zza(zzcbf zzcbfVar, zzbtd zzbtdVar) {
        Set<zzcab<zzbzu>> setZzc = zzcbfVar.zzc(zzbtdVar);
        zzepe.zza(setZzc, "Cannot return null from a non-@Nullable @Provides method");
        return setZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
