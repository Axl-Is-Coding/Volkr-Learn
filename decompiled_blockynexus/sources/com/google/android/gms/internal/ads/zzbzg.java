package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzg implements zzeoy<Set<zzcab<zzbvs>>> {
    private final zzbys zzfwg;

    private zzbzg(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzg zzs(zzbys zzbysVar) {
        return new zzbzg(zzbysVar);
    }

    public static Set<zzcab<zzbvs>> zzt(zzbys zzbysVar) {
        Set<zzcab<zzbvs>> setZzakg = zzbysVar.zzakg();
        zzepe.zza(setZzakg, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakg;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzt(this.zzfwg);
    }
}
