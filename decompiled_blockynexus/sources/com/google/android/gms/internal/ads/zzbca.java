package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbca implements Executor {
    private final Handler zzeev = new zzayo(Looper.getMainLooper());

    zzbca() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.zzeev.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.zzkr();
            zzayu.zza(com.google.android.gms.ads.internal.zzp.zzkv().getApplicationContext(), th);
            throw th;
        }
    }
}
