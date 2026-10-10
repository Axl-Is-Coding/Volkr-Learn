package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqr<AdT> implements zzeoy<zzbqs<AdT>> {
    private final zzeph<Map<String, zzcta<AdT>>> zzfrv;

    private zzbqr(zzeph<Map<String, zzcta<AdT>>> zzephVar) {
        this.zzfrv = zzephVar;
    }

    public static <AdT> zzbqr<AdT> zzd(zzeph<Map<String, zzcta<AdT>>> zzephVar) {
        return new zzbqr<>(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbqs(this.zzfrv.get());
    }
}
