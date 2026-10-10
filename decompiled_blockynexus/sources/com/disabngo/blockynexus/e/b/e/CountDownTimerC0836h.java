package com.disabngo.blockynexus.e.b.e;

import android.os.CountDownTimer;
import com.disabngo.blockynexus.R;
import com.umeng.analytics.pro.au;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.e.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindEmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class CountDownTimerC0836h extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0839k f9727a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC0836h(C0839k c0839k, long j, long j2) {
        super(j, j2);
        this.f9727a = c0839k;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f9727a.g.set(true);
        C0839k c0839k = this.f9727a;
        c0839k.f9736f.set(c0839k.f9731a.getResources().getString(R.string.resend));
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f9727a.g.set(false);
        this.f9727a.f9736f.set(this.f9727a.f9731a.getResources().getString(R.string.resend).split(" ")[0] + " " + (j / 1000) + au.ax);
    }
}
