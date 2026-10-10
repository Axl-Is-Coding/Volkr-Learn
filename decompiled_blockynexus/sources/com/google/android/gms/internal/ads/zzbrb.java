package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbrb implements zzdyr<zzbqo> {
    private final /* synthetic */ zzdyr zzfsd;
    private final /* synthetic */ zzbqv zzfse;

    zzbrb(zzbqv zzbqvVar, zzdyr zzdyrVar) {
        this.zzfse = zzbqvVar;
        this.zzfsd = zzdyrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzbqo zzbqoVar) {
        this.zzfse.zzaja();
        this.zzfsd.onSuccess(zzbqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzfse.zzaja();
        this.zzfsd.zzb(th);
    }
}
