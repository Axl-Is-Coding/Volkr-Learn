package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzh implements zzeoy<Set<zzcab<zzbwl>>> {
    private final zzbys zzfwg;

    private zzbzh(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzh zzu(zzbys zzbysVar) {
        return new zzbzh(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzbwl>> setZzako = this.zzfwg.zzako();
        zzepe.zza(setZzako, "Cannot return null from a non-@Nullable @Provides method");
        return setZzako;
    }
}
