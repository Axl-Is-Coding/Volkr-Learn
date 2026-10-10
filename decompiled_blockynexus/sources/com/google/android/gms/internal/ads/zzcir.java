package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcir implements zzdyr<zzbgj> {
    private final /* synthetic */ String zzgen;
    private final /* synthetic */ Map zzgeo;

    zzcir(zzcil zzcilVar, String str, Map map) {
        this.zzgen = str;
        this.zzgeo = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzbgj zzbgjVar) {
        zzbgjVar.zza(this.zzgen, this.zzgeo);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
    }
}
