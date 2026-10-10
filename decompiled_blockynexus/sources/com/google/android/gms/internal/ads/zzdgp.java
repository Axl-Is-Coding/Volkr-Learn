package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgp implements zzeoy<zzdgn> {
    private final zzeph<zzdmd> zzftt;

    private zzdgp(zzeph<zzdmd> zzephVar) {
        this.zzftt = zzephVar;
    }

    public static zzdgp zzaq(zzeph<zzdmd> zzephVar) {
        return new zzdgp(zzephVar);
    }

    public static zzdgn zzb(zzdmd zzdmdVar) {
        return new zzdgn(zzdmdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzftt.get());
    }
}
