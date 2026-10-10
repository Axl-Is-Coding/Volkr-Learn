package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxu implements zzeoy<zzcxr> {
    private final zzeph<zzcyy> zzgra;

    private zzcxu(zzeph<zzcyy> zzephVar) {
        this.zzgra = zzephVar;
    }

    public static zzcxu zzai(zzeph<zzcyy> zzephVar) {
        return new zzcxu(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcxr(this.zzgra.get());
    }
}
