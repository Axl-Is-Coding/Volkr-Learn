package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcqk implements zzdyr<zzdog> {
    private final /* synthetic */ zzcqi zzgkv;

    zzcqk(zzcqi zzcqiVar) {
        this.zzgkv = zzcqiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzdog zzdogVar) {
        this.zzgkv.zzgku.zzb(zzdogVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
    }
}
