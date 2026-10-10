package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzb implements zzeoy<Set<zzcab<zzbuv>>> {
    private final zzbys zzfwg;

    private zzbzb(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzb zzn(zzbys zzbysVar) {
        return new zzbzb(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzbuv>> setZzaki = this.zzfwg.zzaki();
        zzepe.zza(setZzaki, "Cannot return null from a non-@Nullable @Provides method");
        return setZzaki;
    }
}
