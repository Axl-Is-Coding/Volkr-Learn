package com.disabngo.blockynexus.e.b.s;

import android.os.CountDownTimer;
import com.disabngo.blockynexus.R;
import com.umeng.analytics.pro.au;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.s.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class CountDownTimerC0918g extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0921j f10159a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC0918g(C0921j c0921j, long j, long j2) {
        super(j, j2);
        this.f10159a = c0921j;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f10159a.l.set(true);
        C0921j c0921j = this.f10159a;
        c0921j.j.set(c0921j.f10162a.getResources().getString(R.string.resend));
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f10159a.l.set(false);
        this.f10159a.j.set(this.f10159a.f10162a.getResources().getString(R.string.resend).split(" ")[0] + " " + (j / 1000) + au.ax);
    }
}
