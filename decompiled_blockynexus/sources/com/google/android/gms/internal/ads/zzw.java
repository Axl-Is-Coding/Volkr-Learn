package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzw extends Thread {
    private final BlockingQueue<zzaa<?>> zzak;
    private final zzx zzal;
    private final zzk zzn;
    private final zzak zzo;
    private volatile boolean zzp = false;

    public zzw(BlockingQueue<zzaa<?>> blockingQueue, zzx zzxVar, zzk zzkVar, zzak zzakVar) {
        this.zzak = blockingQueue;
        this.zzal = zzxVar;
        this.zzn = zzkVar;
        this.zzo = zzakVar;
    }

    private final void processRequest() throws InterruptedException {
        zzaa<?> zzaaVarTake = this.zzak.take();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        zzaaVarTake.zzd(3);
        try {
            zzaaVarTake.zzc("network-queue-take");
            zzaaVarTake.isCanceled();
            TrafficStats.setThreadStatsTag(zzaaVarTake.zzd());
            zzy zzyVarZzc = this.zzal.zzc(zzaaVarTake);
            zzaaVarTake.zzc("network-http-complete");
            if (zzyVarZzc.zzan && zzaaVarTake.zzl()) {
                zzaaVarTake.zzd("not-modified");
                zzaaVarTake.zzm();
                return;
            }
            zzaj<?> zzajVarZza = zzaaVarTake.zza(zzyVarZzc);
            zzaaVarTake.zzc("network-parse-complete");
            if (zzaaVarTake.zzh() && zzajVarZza.zzbs != null) {
                this.zzn.zza(zzaaVarTake.zze(), zzajVarZza.zzbs);
                zzaaVarTake.zzc("network-cache-written");
            }
            zzaaVarTake.zzk();
            this.zzo.zzb(zzaaVarTake, zzajVarZza);
            zzaaVarTake.zza(zzajVarZza);
        } catch (zzao e2) {
            e2.zza(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.zzo.zza(zzaaVarTake, e2);
            zzaaVarTake.zzm();
        } catch (Exception e3) {
            zzaq.zza(e3, "Unhandled exception %s", e3.toString());
            zzao zzaoVar = new zzao(e3);
            zzaoVar.zza(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.zzo.zza(zzaaVarTake, zzaoVar);
            zzaaVarTake.zzm();
        } finally {
            zzaaVarTake.zzd(4);
        }
    }

    public final void quit() {
        this.zzp = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzp) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
