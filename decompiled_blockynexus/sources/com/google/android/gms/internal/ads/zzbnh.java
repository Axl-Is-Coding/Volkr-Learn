package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnh implements zzrh {
    private final Clock zzbqa;
    private final ScheduledExecutorService zzfoz;
    private ScheduledFuture<?> zzfpa;
    private long zzfpb = -1;
    private long zzfpc = -1;
    private Runnable zzeae = null;
    private boolean zzfpd = false;

    public zzbnh(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfoz = scheduledExecutorService;
        this.zzbqa = clock;
        com.google.android.gms.ads.internal.zzp.zzku().zza(this);
    }

    @VisibleForTesting
    private final synchronized void zzahj() {
        if (!this.zzfpd) {
            if (this.zzfpa == null || this.zzfpa.isDone()) {
                this.zzfpc = -1L;
            } else {
                this.zzfpa.cancel(true);
                this.zzfpc = this.zzfpb - this.zzbqa.elapsedRealtime();
            }
            this.zzfpd = true;
        }
    }

    @VisibleForTesting
    private final synchronized void zzahk() {
        if (this.zzfpd) {
            if (this.zzfpc > 0 && this.zzfpa != null && this.zzfpa.isCancelled()) {
                this.zzfpa = this.zzfoz.schedule(this.zzeae, this.zzfpc, TimeUnit.MILLISECONDS);
            }
            this.zzfpd = false;
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.zzeae = runnable;
        long j = i;
        this.zzfpb = this.zzbqa.elapsedRealtime() + j;
        this.zzfpa = this.zzfoz.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzrh
    public final void zzp(boolean z) {
        if (z) {
            zzahk();
        } else {
            zzahj();
        }
    }
}
