package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccc implements com.google.android.gms.ads.internal.overlay.zzp {
    private final zzbwa zzfwy;
    private final zzbzx zzfwz;

    public zzccc(zzbwa zzbwaVar, zzbzx zzbzxVar) {
        this.zzfwy = zzbwaVar;
        this.zzfwz = zzbzxVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
        this.zzfwy.onPause();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
        this.zzfwy.onResume();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
        this.zzfwy.zzum();
        this.zzfwz.onHide();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
        this.zzfwy.zzun();
        this.zzfwz.zzaku();
    }
}
