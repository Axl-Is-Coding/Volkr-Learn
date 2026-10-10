package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbze implements zzeoy<Set<zzcab<zzbuz>>> {
    private final zzbys zzfwg;

    private zzbze(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbze zzq(zzbys zzbysVar) {
        return new zzbze(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzbuz>> setZzakm = this.zzfwg.zzakm();
        zzepe.zza(setZzakm, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakm;
    }
}
