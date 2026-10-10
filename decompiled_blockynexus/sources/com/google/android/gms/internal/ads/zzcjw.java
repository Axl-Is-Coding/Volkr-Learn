package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcjw implements com.google.android.gms.ads.internal.zzk {
    private final /* synthetic */ zzcjt zzgfl;

    zzcjw(zzcjt zzcjtVar) {
        this.zzgfl = zzcjtVar;
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void zzkn() {
        this.zzgfl.zzgfh.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void zzko() {
        this.zzgfl.zzgfh.onResume();
    }
}
