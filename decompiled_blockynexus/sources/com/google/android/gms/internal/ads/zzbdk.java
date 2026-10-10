package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdk implements Runnable {
    private final /* synthetic */ zzbdh zzegy;
    private final /* synthetic */ boolean zzehb;

    zzbdk(zzbdh zzbdhVar, boolean z) {
        this.zzegy = zzbdhVar;
        this.zzehb = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzegy.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzehb));
    }
}
