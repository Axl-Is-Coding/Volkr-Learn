package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdi implements Runnable {
    private final /* synthetic */ zzbdh zzegy;

    zzbdi(zzbdh zzbdhVar) {
        this.zzegy = zzbdhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzegy.zzd("surfaceCreated", new String[0]);
    }
}
