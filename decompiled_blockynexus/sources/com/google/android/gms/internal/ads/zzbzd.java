package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzd implements zzeoy<Set<zzcab<zzbuh>>> {
    private final zzbys zzfwg;

    private zzbzd(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzd zzp(zzbys zzbysVar) {
        return new zzbzd(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzbuh>> setZzakf = this.zzfwg.zzakf();
        zzepe.zza(setZzakf, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakf;
    }
}
