package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzi implements zzeoy<Set<zzcab<zzbwb>>> {
    private final zzbys zzfwg;

    private zzbzi(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzi zzv(zzbys zzbysVar) {
        return new zzbzi(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzbwb>> setZzakn = this.zzfwg.zzakn();
        zzepe.zza(setZzakn, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakn;
    }
}
