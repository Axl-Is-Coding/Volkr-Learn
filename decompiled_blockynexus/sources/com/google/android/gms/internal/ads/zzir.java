package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzir extends Thread {
    private final /* synthetic */ AudioTrack zzalx;
    private final /* synthetic */ zzio zzaly;

    zzir(zzio zzioVar, AudioTrack audioTrack) {
        this.zzaly = zzioVar;
        this.zzalx = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.zzalx.flush();
            this.zzalx.release();
        } finally {
            this.zzaly.zzaju.open();
        }
    }
}
