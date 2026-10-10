package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqa implements com.google.android.gms.ads.internal.overlay.zzp {
    private final /* synthetic */ zzapx zzdmv;

    zzaqa(zzapx zzapxVar) {
        this.zzdmv = zzapxVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
        zzbbq.zzef("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
        zzbbq.zzef("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
        zzbbq.zzef("AdMobCustomTabsAdapter overlay is closed.");
        this.zzdmv.zzdmt.onAdClosed(this.zzdmv);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
        zzbbq.zzef("Opening AdMobCustomTabsAdapter overlay.");
        this.zzdmv.zzdmt.onAdOpened(this.zzdmv);
    }
}
