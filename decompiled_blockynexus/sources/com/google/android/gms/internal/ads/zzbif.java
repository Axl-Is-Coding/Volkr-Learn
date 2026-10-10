package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbif implements com.google.android.gms.ads.internal.overlay.zzp {
    private com.google.android.gms.ads.internal.overlay.zzp zzdpm;
    private zzbgj zzenk;

    public zzbif(zzbgj zzbgjVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar) {
        this.zzenk = zzbgjVar;
        this.zzdpm = zzpVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzdpm;
        if (zzpVar != null) {
            zzpVar.zzum();
        }
        this.zzenk.zzabp();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzdpm;
        if (zzpVar != null) {
            zzpVar.zzun();
        }
        this.zzenk.zzuy();
    }
}
