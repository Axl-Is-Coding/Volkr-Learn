package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmf implements zzeoy<zzcme> {
    private final zzeph<zzts> zzggl;
    private final zzeph<Map<zzdsf, zzcmg>> zzggt;

    private zzcmf(zzeph<zzts> zzephVar, zzeph<Map<zzdsf, zzcmg>> zzephVar2) {
        this.zzggl = zzephVar;
        this.zzggt = zzephVar2;
    }

    public static zzcmf zzah(zzeph<zzts> zzephVar, zzeph<Map<zzdsf, zzcmg>> zzephVar2) {
        return new zzcmf(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcme(this.zzggl.get(), this.zzggt.get());
    }
}
