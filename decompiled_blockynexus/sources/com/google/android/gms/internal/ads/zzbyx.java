package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyx implements zzeoy<Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>>> {
    private final zzbys zzfwg;

    private zzbyx(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbyx zzi(zzbys zzbysVar) {
        return new zzbyx(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>> setZzakp = this.zzfwg.zzakp();
        zzepe.zza(setZzakp, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakp;
    }
}
