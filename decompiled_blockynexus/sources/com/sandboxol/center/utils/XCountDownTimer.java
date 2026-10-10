package com.sandboxol.center.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public abstract class XCountDownTimer {
    private static final int MSG = 1;
    private final long mCountdownInterval;
    private long mMillisInFuture;
    private long mStopTimeInFuture;
    private boolean mCancelled = false;
    private Handler mHandler = new Handler() { // from class: com.sandboxol.center.utils.XCountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            synchronized (XCountDownTimer.this) {
                if (XCountDownTimer.this.mCancelled) {
                    return;
                }
                long jElapsedRealtime = XCountDownTimer.this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    XCountDownTimer.this.onFinish();
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    XCountDownTimer.this.onTick(jElapsedRealtime);
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    if (jElapsedRealtime < XCountDownTimer.this.mCountdownInterval) {
                        j = jElapsedRealtime - jElapsedRealtime3;
                        if (j < 0) {
                            j = 0;
                        }
                    } else {
                        j = XCountDownTimer.this.mCountdownInterval - jElapsedRealtime3;
                        while (j < 0) {
                            j += XCountDownTimer.this.mCountdownInterval;
                        }
                    }
                    sendMessageDelayed(obtainMessage(1), j);
                }
            }
        }
    };

    public XCountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public final synchronized void cancel() {
        this.mCancelled = true;
        this.mHandler.removeMessages(1);
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    public void setMillisInFuture(long j) {
        this.mMillisInFuture = j;
    }

    public final synchronized XCountDownTimer start() {
        this.mCancelled = false;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            return this;
        }
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        return this;
    }
}
