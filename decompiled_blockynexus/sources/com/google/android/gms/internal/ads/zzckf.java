package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzckf implements zzaqq {
    private final /* synthetic */ zzcjv zzgfn;

    zzckf(zzcjv zzcjvVar) {
        this.zzgfn = zzcjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqq
    public final void zzc(int i, int i2, int i3, int i4) {
        this.zzgfn.zzfsg.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzaqq
    public final void zzup() {
        this.zzgfn.zzfsg.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzaqq
    public final void zzuq() {
        this.zzgfn.zzgfk.zzail();
    }
}
