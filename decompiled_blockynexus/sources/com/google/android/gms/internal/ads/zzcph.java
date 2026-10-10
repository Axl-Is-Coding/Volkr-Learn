package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcph implements zzdya {
    static final zzdya zzboo = new zzcph();

    private zzcph() {
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final zzdzc zzf(Object obj) {
        return zzdyq.immediateFailedFuture(new zzcof(zzdpg.NETWORK_ERROR, "Timed out waiting for ad response."));
    }
}
