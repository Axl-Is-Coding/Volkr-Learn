package io.rong.imkit.recallEdit;

import io.rong.common.CountDownTimer;

/* JADX INFO: loaded from: classes5.dex */
public class RecallEditCountDownTimer {
    private static final int COUNTDOWN_INTERVAL = 1000;
    private CountDownTimer mCountDownTimer;
    private RecallEditCountDownTimerListener mListener;
    private String mMessageId;

    public RecallEditCountDownTimer(String str, RecallEditCountDownTimerListener recallEditCountDownTimerListener, long j) {
        this.mMessageId = str;
        this.mListener = recallEditCountDownTimerListener;
        this.mCountDownTimer = new CountDownTimer(j, 1000L) { // from class: io.rong.imkit.recallEdit.RecallEditCountDownTimer.1
            @Override // io.rong.common.CountDownTimer
            public void onFinish() {
                if (RecallEditCountDownTimer.this.mListener != null) {
                    RecallEditCountDownTimer.this.mListener.onFinish(RecallEditCountDownTimer.this.mMessageId);
                }
            }

            @Override // io.rong.common.CountDownTimer
            public void onTick(long j2) {
                if (RecallEditCountDownTimer.this.mListener != null) {
                    RecallEditCountDownTimer.this.mListener.onTick(Math.round(j2 / 1000.0f), RecallEditCountDownTimer.this.mMessageId);
                }
            }
        };
    }

    public void cancel() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void setListener(RecallEditCountDownTimerListener recallEditCountDownTimerListener) {
        this.mListener = recallEditCountDownTimerListener;
    }

    public void start() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer == null || countDownTimer.isStart()) {
            return;
        }
        this.mCountDownTimer.start();
    }
}
