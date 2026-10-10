package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyz implements zzeoy<Set<zzcab<zzux>>> {
    private final zzbys zzfwg;

    private zzbyz(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbyz zzl(zzbys zzbysVar) {
        return new zzbyz(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzux>> setZzakl = this.zzfwg.zzakl();
        zzepe.zza(setZzakl, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakl;
    }
}
