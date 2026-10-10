package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcpg implements zzdyr<zzdog> {
    private final /* synthetic */ zzcpd zzgjv;

    zzcpg(zzcpd zzcpdVar) {
        this.zzgjv = zzcpdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzdog zzdogVar) {
        this.zzgjv.zzgjr.zzb(zzdogVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
    }
}
