package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcyw implements com.google.android.gms.ads.internal.zzg {
    private final /* synthetic */ zzcbg zzgsb;

    zzcyw(zzcyr zzcyrVar, zzcbg zzcbgVar) {
        this.zzgsb = zzcbgVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzh(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkc() {
        this.zzgsb.zzafb().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkd() {
        this.zzgsb.zzafc().onAdImpression();
        this.zzgsb.zzafd().zzakv();
    }
}
