package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdw implements Runnable {
    private boolean zzbsu = false;
    private zzbdh zzehd;

    zzbdw(zzbdh zzbdhVar) {
        this.zzehd = zzbdhVar;
    }

    private final void zzaab() {
        zzayu.zzeba.removeCallbacks(this);
        zzayu.zzeba.postDelayed(this, 250L);
    }

    public final void pause() {
        this.zzbsu = true;
        this.zzehd.zzzk();
    }

    public final void resume() {
        this.zzbsu = false;
        zzaab();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbsu) {
            return;
        }
        this.zzehd.zzzk();
        zzaab();
    }
}
