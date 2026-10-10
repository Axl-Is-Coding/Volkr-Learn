package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyx implements zzeoy<zzcyy> {
    private final zzeph<zzcku> zzgra;

    private zzcyx(zzeph<zzcku> zzephVar) {
        this.zzgra = zzephVar;
    }

    public static zzcyx zzaj(zzeph<zzcku> zzephVar) {
        return new zzcyx(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcyy(this.zzgra.get());
    }
}
