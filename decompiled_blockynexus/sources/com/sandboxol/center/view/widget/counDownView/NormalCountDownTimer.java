package com.sandboxol.center.view.widget.counDownView;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes3.dex */
public class NormalCountDownTimer extends CountDownTimer {
    private ICountDownOverProvider iCountDownOverProvider;
    private ICountDownProvider iCountDownProvider;

    public NormalCountDownTimer(long j, long j2) {
        super(j, j2);
    }

    public ICountDownOverProvider getICountDownOverProvider() {
        return this.iCountDownOverProvider;
    }

    public ICountDownProvider getiCountDownProvider() {
        return this.iCountDownProvider;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        ICountDownOverProvider iCountDownOverProvider = this.iCountDownOverProvider;
        if (iCountDownOverProvider != null) {
            iCountDownOverProvider.onFinish();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        ICountDownProvider iCountDownProvider = this.iCountDownProvider;
        if (iCountDownProvider != null) {
            iCountDownProvider.onUpdate(j);
        }
    }

    public void setiCountDownOverProvider(ICountDownOverProvider iCountDownOverProvider) {
        this.iCountDownOverProvider = iCountDownOverProvider;
    }

    public void setiCountDownProvider(ICountDownProvider iCountDownProvider) {
        this.iCountDownProvider = iCountDownProvider;
    }
}
