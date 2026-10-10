package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzot {
    private final ExecutorService zzbje;
    private zzov<? extends zzoy> zzbjf;
    private IOException zzbjg;

    public zzot(String str) {
        this.zzbje = zzpq.zzbi(str);
    }

    public final boolean isLoading() {
        return this.zzbjf != null;
    }

    public final <T extends zzoy> long zza(T t, zzow<T> zzowVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        zzoz.checkState(looperMyLooper != null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzov(this, looperMyLooper, t, zzowVar, i, jElapsedRealtime).zzek(0L);
        return jElapsedRealtime;
    }

    public final void zzbj(int i) throws IOException {
        IOException iOException = this.zzbjg;
        if (iOException != null) {
            throw iOException;
        }
        zzov<? extends zzoy> zzovVar = this.zzbjf;
        if (zzovVar != null) {
            zzovVar.zzbj(zzovVar.zzbjl);
        }
    }

    public final void zzis() {
        this.zzbjf.zzl(false);
    }

    public final void zza(Runnable runnable) {
        zzov<? extends zzoy> zzovVar = this.zzbjf;
        if (zzovVar != null) {
            zzovVar.zzl(true);
        }
        this.zzbje.execute(runnable);
        this.zzbje.shutdown();
    }
}
