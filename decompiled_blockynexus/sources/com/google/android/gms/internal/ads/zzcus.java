package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcus implements zzdyr<zzboq> {
    private final /* synthetic */ zzcun zzgpa;

    zzcus(zzcun zzcunVar) {
        this.zzgpa = zzcunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzboq zzboqVar) {
        zzboqVar.zzaih();
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzva zzvaVarZze = this.zzgpa.zzgov.zzaev().zze(th);
        this.zzgpa.zzfwd.zzk(zzvaVarZze);
        zzdox.zza(zzvaVarZze.errorCode, th, "DelayedBannerAd.onFailure");
    }
}
