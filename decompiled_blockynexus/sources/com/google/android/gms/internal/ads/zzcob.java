package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcob implements zzdyr<String> {
    final /* synthetic */ zzcnu zzgis;

    zzcob(zzcnu zzcnuVar) {
        this.zzgis = zzcnuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(String str) {
        final String str2 = str;
        synchronized (this) {
            zzcnu.zza(this.zzgis, true);
            this.zzgis.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgis.zzgig));
            this.zzgis.executor.execute(new Runnable(this, str2) { // from class: com.google.android.gms.internal.ads.zzcoe
                private final String zzdgm;
                private final zzcob zzgix;

                {
                    this.zzgix = this;
                    this.zzdgm = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcob zzcobVar = this.zzgix;
                    zzcobVar.zzgis.zzgl(this.zzdgm);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        synchronized (this) {
            zzcnu.zza(this.zzgis, true);
            this.zzgis.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgis.zzgig));
            this.zzgis.zzgih.setException(new Exception());
        }
    }
}
