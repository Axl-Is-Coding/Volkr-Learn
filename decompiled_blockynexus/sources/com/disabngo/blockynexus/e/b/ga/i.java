package com.disabngo.blockynexus.e.b.ga;

import android.os.CountDownTimer;
import com.disabngo.blockynexus.R;
import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: SecretQuestionUnbindViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9794a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i(j jVar, long j, long j2) {
        super(j, j2);
        this.f9794a = jVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f9794a.h.set(true);
        j jVar = this.f9794a;
        jVar.f9800f.set(jVar.f9795a.getResources().getString(R.string.resend));
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f9794a.h.set(false);
        this.f9794a.f9800f.set(this.f9794a.f9795a.getResources().getString(R.string.resend).split(" ")[0] + " " + (j / 1000) + au.ax);
    }
}
