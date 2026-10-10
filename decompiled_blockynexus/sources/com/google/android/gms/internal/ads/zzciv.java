package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzciv implements com.google.android.gms.ads.internal.overlay.zzv {
    private final zzbvh zzger;

    private zzciv(zzbvh zzbvhVar) {
        this.zzger = zzbvhVar;
    }

    static com.google.android.gms.ads.internal.overlay.zzv zza(zzbvh zzbvhVar) {
        return new zzciv(zzbvhVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzv
    public final void zzvd() {
        this.zzger.onAdLeftApplication();
    }
}
