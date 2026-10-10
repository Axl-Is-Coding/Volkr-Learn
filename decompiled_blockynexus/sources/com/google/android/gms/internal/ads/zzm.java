package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzm extends Thread {
    private static final boolean DEBUG = zzaq.DEBUG;
    private final BlockingQueue<zzaa<?>> zzl;
    private final BlockingQueue<zzaa<?>> zzm;
    private final zzk zzn;
    private final zzak zzo;
    private volatile boolean zzp = false;
    private final zzo zzq = new zzo(this);

    public zzm(BlockingQueue<zzaa<?>> blockingQueue, BlockingQueue<zzaa<?>> blockingQueue2, zzk zzkVar, zzak zzakVar) {
        this.zzl = blockingQueue;
        this.zzm = blockingQueue2;
        this.zzn = zzkVar;
        this.zzo = zzakVar;
    }

    private final void processRequest() throws InterruptedException {
        zzaa<?> zzaaVarTake = this.zzl.take();
        zzaaVarTake.zzc("cache-queue-take");
        zzaaVarTake.zzd(1);
        try {
            zzaaVarTake.isCanceled();
            zzn zznVarZzb = this.zzn.zzb(zzaaVarTake.zze());
            if (zznVarZzb == null) {
                zzaaVarTake.zzc("cache-miss");
                if (!this.zzq.zzb(zzaaVarTake)) {
                    this.zzm.put(zzaaVarTake);
                }
                return;
            }
            if (zznVarZzb.zza()) {
                zzaaVarTake.zzc("cache-hit-expired");
                zzaaVarTake.zza(zznVarZzb);
                if (!this.zzq.zzb(zzaaVarTake)) {
                    this.zzm.put(zzaaVarTake);
                }
                return;
            }
            zzaaVarTake.zzc("cache-hit");
            zzaj<?> zzajVarZza = zzaaVarTake.zza(new zzy(zznVarZzb.data, zznVarZzb.zzw));
            zzaaVarTake.zzc("cache-hit-parsed");
            if (!zzajVarZza.isSuccess()) {
                zzaaVarTake.zzc("cache-parsing-failed");
                this.zzn.zza(zzaaVarTake.zze(), true);
                zzaaVarTake.zza((zzn) null);
                if (!this.zzq.zzb(zzaaVarTake)) {
                    this.zzm.put(zzaaVarTake);
                }
                return;
            }
            if (zznVarZzb.zzv < System.currentTimeMillis()) {
                zzaaVarTake.zzc("cache-hit-refresh-needed");
                zzaaVarTake.zza(zznVarZzb);
                zzajVarZza.zzbu = true;
                if (this.zzq.zzb(zzaaVarTake)) {
                    this.zzo.zzb(zzaaVarTake, zzajVarZza);
                } else {
                    this.zzo.zza(zzaaVarTake, zzajVarZza, new zzp(this, zzaaVarTake));
                }
            } else {
                this.zzo.zzb(zzaaVarTake, zzajVarZza);
            }
        } finally {
            zzaaVarTake.zzd(2);
        }
    }

    public final void quit() {
        this.zzp = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (DEBUG) {
            zzaq.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzn.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzp) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
