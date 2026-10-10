package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbwk extends zzbyr<zzbwo> {
    private final Clock zzbqa;
    private boolean zzfol;
    private final ScheduledExecutorService zzfoz;
    private long zzfpb;
    private long zzfpc;
    private ScheduledFuture<?> zzfva;

    public zzbwk(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfpb = -1L;
        this.zzfpc = -1L;
        this.zzfol = false;
        this.zzfoz = scheduledExecutorService;
        this.zzbqa = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaka() {
        zza(zzbwn.zzfur);
    }

    private final synchronized void zzfe(long j) {
        if (this.zzfva != null && !this.zzfva.isDone()) {
            this.zzfva.cancel(true);
        }
        this.zzfpb = this.zzbqa.elapsedRealtime() + j;
        this.zzfva = this.zzfoz.schedule(new zzbwp(this), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void onPause() {
        if (!this.zzfol) {
            if (this.zzfva == null || this.zzfva.isCancelled()) {
                this.zzfpc = -1L;
            } else {
                this.zzfva.cancel(true);
                this.zzfpc = this.zzfpb - this.zzbqa.elapsedRealtime();
            }
            this.zzfol = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfol) {
            if (this.zzfpc > 0 && this.zzfva.isCancelled()) {
                zzfe(this.zzfpc);
            }
            this.zzfol = false;
        }
    }

    public final synchronized void zzajz() {
        this.zzfol = false;
        zzfe(0L);
    }

    public final synchronized void zzdw(int i) {
        if (i <= 0) {
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(i);
        if (!this.zzfol) {
            if (this.zzbqa.elapsedRealtime() > this.zzfpb || this.zzfpb - this.zzbqa.elapsedRealtime() > millis) {
                zzfe(millis);
            }
        } else {
            if (this.zzfpc <= 0 || millis >= this.zzfpc) {
                millis = this.zzfpc;
            }
            this.zzfpc = millis;
        }
    }
}
