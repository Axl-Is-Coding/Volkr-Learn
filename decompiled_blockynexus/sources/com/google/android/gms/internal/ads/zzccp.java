package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccp implements zzeoy<zzccq> {
    private final zzeph<zzbvb> zzfts;

    private zzccp(zzeph<zzbvb> zzephVar) {
        this.zzfts = zzephVar;
    }

    public static zzccp zzx(zzeph<zzbvb> zzephVar) {
        return new zzccp(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzccq(this.zzfts.get());
    }
}
