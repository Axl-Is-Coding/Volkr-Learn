package com.sandboxol.center.utils;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes3.dex */
public class DelayExecutor {

    public interface OnDelayExecutorListener {
        void onFinish();
    }

    public static void doDelay(long j, final OnDelayExecutorListener onDelayExecutorListener) {
        new CountDownTimer(j, 1000L) { // from class: com.sandboxol.center.utils.DelayExecutor.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                onDelayExecutorListener.onFinish();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        }.start();
    }
}
