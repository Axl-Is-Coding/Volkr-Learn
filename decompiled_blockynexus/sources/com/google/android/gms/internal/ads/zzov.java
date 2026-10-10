package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzoy;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"HandlerLeak"})
final class zzov<T extends zzoy> extends Handler implements Runnable {
    private volatile boolean zzagi;
    private final T zzbjj;
    private final zzow<T> zzbjk;
    public final int zzbjl;
    private final long zzbjm;
    private IOException zzbjn;
    private int zzbjo;
    private volatile Thread zzbjp;
    private final /* synthetic */ zzot zzbjq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzov(zzot zzotVar, Looper looper, T t, zzow<T> zzowVar, int i, long j) {
        super(looper);
        this.zzbjq = zzotVar;
        this.zzbjj = t;
        this.zzbjk = zzowVar;
        this.zzbjl = i;
        this.zzbjm = j;
    }

    private final void execute() {
        this.zzbjn = null;
        this.zzbjq.zzbje.execute(this.zzbjq.zzbjf);
    }

    private final void finish() {
        this.zzbjq.zzbjf = null;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzagi) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            execute();
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        finish();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.zzbjm;
        if (this.zzbjj.zzhx()) {
            this.zzbjk.zza((zzoy) this.zzbjj, jElapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            this.zzbjk.zza((zzoy) this.zzbjj, jElapsedRealtime, j, false);
            return;
        }
        if (i2 == 2) {
            this.zzbjk.zza(this.zzbjj, jElapsedRealtime, j);
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.zzbjn = (IOException) message.obj;
        int iZza = this.zzbjk.zza(this.zzbjj, jElapsedRealtime, j, this.zzbjn);
        if (iZza == 3) {
            this.zzbjq.zzbjg = this.zzbjn;
        } else if (iZza != 2) {
            this.zzbjo = iZza == 1 ? 1 : this.zzbjo + 1;
            zzek(Math.min((this.zzbjo - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzbjp = Thread.currentThread();
            if (!this.zzbjj.zzhx()) {
                String strValueOf = String.valueOf(this.zzbjj.getClass().getSimpleName());
                zzpn.beginSection(strValueOf.length() != 0 ? "load:".concat(strValueOf) : new String("load:"));
                try {
                    this.zzbjj.zzhy();
                    zzpn.endSection();
                } catch (Throwable th) {
                    zzpn.endSection();
                    throw th;
                }
            }
            if (this.zzagi) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e2) {
            if (this.zzagi) {
                return;
            }
            obtainMessage(3, e2).sendToTarget();
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (this.zzagi) {
                return;
            }
            obtainMessage(3, new zzox(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.zzagi) {
                return;
            }
            obtainMessage(3, new zzox(e4)).sendToTarget();
        } catch (Error e5) {
            Log.e("LoadTask", "Unexpected error loading stream", e5);
            if (!this.zzagi) {
                obtainMessage(4, e5).sendToTarget();
            }
            throw e5;
        } catch (InterruptedException unused) {
            zzoz.checkState(this.zzbjj.zzhx());
            if (this.zzagi) {
                return;
            }
            sendEmptyMessage(2);
        }
    }

    public final void zzbj(int i) throws IOException {
        IOException iOException = this.zzbjn;
        if (iOException != null && this.zzbjo > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzoz.checkState(this.zzbjq.zzbjf == null);
        this.zzbjq.zzbjf = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzagi = z;
        this.zzbjn = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbjj.cancelLoad();
            if (this.zzbjp != null) {
                this.zzbjp.interrupt();
            }
        }
        if (z) {
            finish();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjk.zza((zzoy) this.zzbjj, jElapsedRealtime, jElapsedRealtime - this.zzbjm, true);
        }
    }
}
