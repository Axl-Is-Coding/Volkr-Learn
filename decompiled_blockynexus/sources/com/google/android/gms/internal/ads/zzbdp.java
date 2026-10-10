package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public final class zzbdp {
    private long zzehg;
    private final long zzehf = TimeUnit.MILLISECONDS.toNanos(((Long) zzwm.zzpx().zzd(zzabb.zzcmp)).longValue());
    private boolean zzehh = true;

    zzbdp() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbdc zzbdcVar) {
        if (zzbdcVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.zzehh || Math.abs(timestamp - this.zzehg) >= this.zzehf) {
            this.zzehh = false;
            this.zzehg = timestamp;
            zzayu.zzeba.post(new zzbdo(this, zzbdcVar));
        }
    }

    public final void zzzd() {
        this.zzehh = true;
    }
}
