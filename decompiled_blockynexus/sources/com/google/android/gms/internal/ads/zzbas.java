package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbas {
    private HandlerThread zzedb = null;
    private Handler handler = null;
    private int zzedc = 0;
    private final Object lock = new Object();

    public final Handler getHandler() {
        return this.handler;
    }

    public final Looper zzyj() {
        Looper looper;
        synchronized (this.lock) {
            if (this.zzedc != 0) {
                Preconditions.checkNotNull(this.zzedb, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzedb == null) {
                zzayp.zzei("Starting the looper thread.");
                this.zzedb = new HandlerThread("LooperProvider");
                this.zzedb.start();
                this.handler = new zzdvo(this.zzedb.getLooper());
                zzayp.zzei("Looper thread started.");
            } else {
                zzayp.zzei("Resuming the looper thread");
                this.lock.notifyAll();
            }
            this.zzedc++;
            looper = this.zzedb.getLooper();
        }
        return looper;
    }
}
