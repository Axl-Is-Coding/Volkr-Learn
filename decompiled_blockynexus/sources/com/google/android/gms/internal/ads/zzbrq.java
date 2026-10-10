package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbrq implements zzdyr<zzatc> {
    private final /* synthetic */ zzbrl zzfsx;

    zzbrq(zzbrl zzbrlVar) {
        this.zzfsx = zzbrlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzatc zzatcVar) {
        this.zzfsx.zzfso.zzbg(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzfsx.zzfso.zzbg(false);
    }
}
