package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import com.tendcloud.tenddata.ab;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfv extends Thread {
    private final Object zza;
    private final BlockingQueue<zzfs<?>> zzb;
    private boolean zzc = false;
    private final /* synthetic */ zzfr zzd;

    public zzfv(zzfr zzfrVar, String str, BlockingQueue<zzfs<?>> blockingQueue) {
        this.zzd = zzfrVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zza = new Object();
        this.zzb = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        synchronized (this.zzd.zzg) {
            if (!this.zzc) {
                this.zzd.zzh.release();
                this.zzd.zzg.notifyAll();
                if (this == this.zzd.zza) {
                    zzfr.zza(this.zzd, null);
                } else if (this == this.zzd.zzb) {
                    zzfr.zzb(this.zzd, null);
                } else {
                    this.zzd.zzq().zze().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzc = true;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zzd.zzh.acquire();
                z = true;
            } catch (InterruptedException e2) {
                zza(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfs<?> zzfsVarPoll = this.zzb.poll();
                if (zzfsVarPoll == null) {
                    synchronized (this.zza) {
                        if (this.zzb.peek() == null && !this.zzd.zzi) {
                            try {
                                this.zza.wait(ab.R);
                            } catch (InterruptedException e3) {
                                zza(e3);
                            }
                        }
                    }
                    synchronized (this.zzd.zzg) {
                        if (this.zzb.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(zzfsVarPoll.zza ? threadPriority : 10);
                    zzfsVarPoll.run();
                }
            }
            if (this.zzd.zzs().zza(zzas.zzbq)) {
                zzb();
            }
        } finally {
            zzb();
        }
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.notifyAll();
        }
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzd.zzq().zzh().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
