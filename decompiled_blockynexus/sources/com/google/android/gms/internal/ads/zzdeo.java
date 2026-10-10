package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdeo implements zzeoy<zzdem> {
    private final zzeph<zzdzb> zzesr;

    private zzdeo(zzeph<zzdzb> zzephVar) {
        this.zzesr = zzephVar;
    }

    public static zzdeo zzan(zzeph<zzdzb> zzephVar) {
        return new zzdeo(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdem(this.zzesr.get());
    }
}
