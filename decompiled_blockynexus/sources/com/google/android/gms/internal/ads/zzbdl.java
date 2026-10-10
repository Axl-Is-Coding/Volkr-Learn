package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdl implements Runnable {
    private final /* synthetic */ zzbdh zzegy;

    zzbdl(zzbdh zzbdhVar) {
        this.zzegy = zzbdhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzegy.zzd("surfaceDestroyed", new String[0]);
    }
}
