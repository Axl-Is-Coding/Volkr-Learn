package com.disabngo.blockynexus.view.activity.main;

import android.os.CountDownTimer;
import com.umeng.analytics.pro.au;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.lb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class CountDownTimerC1032lb extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10926a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC1032lb(MainActivity mainActivity, long j, long j2) {
        super(j, j2);
        this.f10926a = mainActivity;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.f10926a.isFinishing() || this.f10926a.f10802a == null) {
            return;
        }
        this.f10926a.f10802a.setVisibility(8);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f10926a.f10806e.setText((j / 1000) + au.ax);
    }
}
