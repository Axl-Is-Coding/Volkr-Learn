package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfs implements zzeoy<zzdft> {
    private final zzeph<String> zzggp;

    private zzdfs(zzeph<String> zzephVar) {
        this.zzggp = zzephVar;
    }

    public static zzdfs zzap(zzeph<String> zzephVar) {
        return new zzdfs(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdft(this.zzggp.get());
    }
}
