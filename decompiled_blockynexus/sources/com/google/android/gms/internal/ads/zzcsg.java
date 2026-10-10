package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsg implements zzeoy<zzcsd> {
    private final zzeph<zzcsc> zzgmr;

    private zzcsg(zzeph<zzcsc> zzephVar) {
        this.zzgmr = zzephVar;
    }

    public static zzcsg zzah(zzeph<zzcsc> zzephVar) {
        return new zzcsg(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcsd(this.zzgmr.get());
    }
}
