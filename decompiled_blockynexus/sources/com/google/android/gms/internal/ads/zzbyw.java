package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyw implements zzeoy<zzbug> {
    private final zzbys zzfwg;
    private final zzeph<Set<zzcab<zzbui>>> zzfwh;

    private zzbyw(zzbys zzbysVar, zzeph<Set<zzcab<zzbui>>> zzephVar) {
        this.zzfwg = zzbysVar;
        this.zzfwh = zzephVar;
    }

    public static zzbyw zza(zzbys zzbysVar, zzeph<Set<zzcab<zzbui>>> zzephVar) {
        return new zzbyw(zzbysVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbug zzbugVarZzc = this.zzfwg.zzc(this.zzfwh.get());
        zzepe.zza(zzbugVarZzc, "Cannot return null from a non-@Nullable @Provides method");
        return zzbugVarZzc;
    }
}
