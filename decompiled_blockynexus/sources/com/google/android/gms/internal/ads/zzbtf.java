package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbtf implements zzdyr<Boolean> {
    private final /* synthetic */ zzbtd zzftp;

    zzbtf(zzbtd zzbtdVar) {
        this.zzftp = zzbtdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Boolean bool) {
        this.zzftp.zzftk.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
    }
}
