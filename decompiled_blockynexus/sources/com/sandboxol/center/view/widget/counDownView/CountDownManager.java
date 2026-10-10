package com.sandboxol.center.view.widget.counDownView;

import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes3.dex */
public class CountDownManager {
    private static CountDownManager sCountDownManager = new CountDownManager();
    private Vector<NormalCountDownTimer> countDownTimers = new Vector<>();

    public static CountDownManager getInstance() {
        return sCountDownManager;
    }

    public void registerCountDownTime(NormalCountDownTimer normalCountDownTimer) {
        if (normalCountDownTimer != null) {
            normalCountDownTimer.start();
            this.countDownTimers.add(normalCountDownTimer);
        }
    }

    public void unRegisterAll() {
        Iterator<NormalCountDownTimer> it = this.countDownTimers.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.countDownTimers.clear();
    }

    public void unRegisterCountDownTimer(NormalCountDownTimer normalCountDownTimer) {
        normalCountDownTimer.cancel();
        this.countDownTimers.remove(normalCountDownTimer);
    }
}
