package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcnr implements zzeoy<zzcns> {
    private final zzeph<zzbix> zzesp;
    private final zzeph<zzcng> zzggl;

    private zzcnr(zzeph<zzcng> zzephVar, zzeph<zzbix> zzephVar2) {
        this.zzggl = zzephVar;
        this.zzesp = zzephVar2;
    }

    public static zzcnr zzan(zzeph<zzcng> zzephVar, zzeph<zzbix> zzephVar2) {
        return new zzcnr(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcns(this.zzggl.get(), this.zzesp.get());
    }
}
