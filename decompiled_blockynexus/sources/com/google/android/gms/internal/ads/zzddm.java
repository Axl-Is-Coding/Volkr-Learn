package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddm implements zzeoy<zzddk> {
    private final zzeph<zzdlf> zzftt;

    private zzddm(zzeph<zzdlf> zzephVar) {
        this.zzftt = zzephVar;
    }

    public static zzddm zzam(zzeph<zzdlf> zzephVar) {
        return new zzddm(zzephVar);
    }

    public static zzddk zzb(zzdlf zzdlfVar) {
        return new zzddk(zzdlfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzftt.get());
    }
}
