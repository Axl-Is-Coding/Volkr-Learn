package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbrc implements zzdyr<zzbqu> {
    private final /* synthetic */ zzdyr zzfsd;
    private final /* synthetic */ zzbqv zzfse;

    zzbrc(zzbqv zzbqvVar, zzdyr zzdyrVar) {
        this.zzfse = zzbqvVar;
        this.zzfsd = zzdyrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzbqu zzbquVar) {
        this.zzfse.zza(zzbquVar.zzfrx, this.zzfsd);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzfsd.zzb(th);
        this.zzfse.zzaja();
    }
}
