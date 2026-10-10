package io.rong.common;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CountDownTimer {
    private static final int MSG = 1;
    private boolean isStart;
    private final long mCountdownInterval;
    private final long mMillisInFuture;
    private long mStopTimeInFuture;
    private boolean mCancelled = false;
    private Handler mHandler = new Handler() { // from class: io.rong.common.CountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            synchronized (CountDownTimer.this) {
                if (CountDownTimer.this.mCancelled) {
                    return;
                }
                long jElapsedRealtime = CountDownTimer.this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    CountDownTimer.this.onFinish();
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    CountDownTimer.this.onTick(jElapsedRealtime);
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    if (jElapsedRealtime < CountDownTimer.this.mCountdownInterval) {
                        j = jElapsedRealtime - jElapsedRealtime3;
                        if (j < 0) {
                            j = 0;
                        }
                    } else {
                        j = CountDownTimer.this.mCountdownInterval - jElapsedRealtime3;
                        while (j < 0) {
                            j += CountDownTimer.this.mCountdownInterval;
                        }
                    }
                    sendMessageDelayed(obtainMessage(1), j);
                }
            }
        }
    };

    public CountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public final synchronized void cancel() {
        this.mCancelled = true;
        this.isStart = false;
        this.mHandler.removeMessages(1);
    }

    public boolean isStart() {
        return this.isStart;
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    public final synchronized CountDownTimer start() {
        this.mCancelled = false;
        this.isStart = true;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            return this;
        }
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        return this;
    }
}
