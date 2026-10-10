package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqe implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzqe zzbmt = new zzqe();
    private final Handler handler;
    public volatile long zzbms;
    private final HandlerThread zzbmu = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer zzbmv;
    private int zzbmw;

    private zzqe() {
        this.zzbmu.start();
        this.handler = new Handler(this.zzbmu.getLooper(), this);
        this.handler.sendEmptyMessage(0);
    }

    public static zzqe zzjp() {
        return zzbmt;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.zzbms = j;
        this.zzbmv.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zzbmv = Choreographer.getInstance();
            return true;
        }
        if (i == 1) {
            this.zzbmw++;
            if (this.zzbmw == 1) {
                this.zzbmv.postFrameCallback(this);
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        this.zzbmw--;
        if (this.zzbmw == 0) {
            this.zzbmv.removeFrameCallback(this);
            this.zzbms = 0L;
        }
        return true;
    }

    public final void zzjq() {
        this.handler.sendEmptyMessage(1);
    }

    public final void zzjr() {
        this.handler.sendEmptyMessage(2);
    }
}
