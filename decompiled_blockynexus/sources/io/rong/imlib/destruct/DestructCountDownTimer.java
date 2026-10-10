package io.rong.imlib.destruct;

import io.rong.common.CountDownTimer;
import io.rong.imlib.RongIMClient;

/* JADX INFO: loaded from: classes5.dex */
public class DestructCountDownTimer {
    private static final int COUNTDOWN_INTERVAL = 1000;
    private CountDownTimer mCountDownTimer;
    private RongIMClient.DestructCountDownTimerListener mListener;
    private String mMessageId;

    DestructCountDownTimer(String str, RongIMClient.DestructCountDownTimerListener destructCountDownTimerListener, long j) {
        this.mMessageId = str;
        this.mListener = destructCountDownTimerListener;
        this.mCountDownTimer = new CountDownTimer(j + (j / 100), 1000L) { // from class: io.rong.imlib.destruct.DestructCountDownTimer.1
            @Override // io.rong.common.CountDownTimer
            public void onFinish() {
                if (DestructCountDownTimer.this.mListener != null) {
                    DestructCountDownTimer.this.mListener.onTick(0L, DestructCountDownTimer.this.mMessageId);
                }
            }

            @Override // io.rong.common.CountDownTimer
            public void onTick(long j2) {
                if (DestructCountDownTimer.this.mListener != null) {
                    DestructCountDownTimer.this.mListener.onTick(Math.round(j2 / 1000.0f), DestructCountDownTimer.this.mMessageId);
                }
            }
        };
    }

    public void cancel() {
        if (this.mCountDownTimer != null) {
            RongIMClient.DestructCountDownTimerListener destructCountDownTimerListener = this.mListener;
            if (destructCountDownTimerListener != null) {
                destructCountDownTimerListener.onStop(this.mMessageId);
            }
            this.mCountDownTimer.cancel();
        }
    }

    public void start() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer == null || countDownTimer.isStart()) {
            return;
        }
        this.mCountDownTimer.start();
    }
}
