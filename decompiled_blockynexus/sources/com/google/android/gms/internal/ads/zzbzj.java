package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzj implements zzeoy<zzbys> {
    private final zzbys zzfwg;

    private zzbzj(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzj zzw(zzbys zzbysVar) {
        return new zzbzj(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbys zzbysVar = this.zzfwg;
        if (zzbysVar == null) {
            throw null;
        }
        zzepe.zza(zzbysVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbysVar;
    }
}
