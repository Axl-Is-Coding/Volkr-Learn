package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzc implements zzeoy<Set<zzcab<zzbui>>> {
    private final zzbys zzfwg;

    private zzbzc(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzc zzo(zzbys zzbysVar) {
        return new zzbzc(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzbui>> setZzakh = this.zzfwg.zzakh();
        zzepe.zza(setZzakh, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakh;
    }
}
