package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbrp implements zzdyr<Void> {
    private final /* synthetic */ zzbrl zzfsx;

    zzbrp(zzbrl zzbrlVar) {
        this.zzfsx = zzbrlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Void r2) {
        this.zzfsx.zzfso.zzbh(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzfsx.zzfso.zzbh(false);
    }
}
