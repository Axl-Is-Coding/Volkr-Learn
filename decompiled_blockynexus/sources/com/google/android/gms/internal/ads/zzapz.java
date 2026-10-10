package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapz implements Runnable {
    private final /* synthetic */ AdOverlayInfoParcel zzdmu;
    private final /* synthetic */ zzapx zzdmv;

    zzapz(zzapx zzapxVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdmv = zzapxVar;
        this.zzdmu = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzp.zzkq();
        com.google.android.gms.ads.internal.overlay.zzl.zza(this.zzdmv.zzdms, this.zzdmu, true);
    }
}
