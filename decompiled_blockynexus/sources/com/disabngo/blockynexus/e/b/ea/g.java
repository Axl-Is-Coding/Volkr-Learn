package com.disabngo.blockynexus.e.b.ea;

import android.os.CountDownTimer;
import com.disabngo.blockynexus.R;
import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: SecretEmailVerifyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9742a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(k kVar, long j, long j2) {
        super(j, j2);
        this.f9742a = kVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f9742a.i.set(true);
        k kVar = this.f9742a;
        kVar.g.set(kVar.f9747a.getResources().getString(R.string.resend));
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f9742a.i.set(false);
        this.f9742a.g.set(this.f9742a.f9747a.getResources().getString(R.string.resend).split(" ")[0] + " " + (j / 1000) + au.ax);
    }
}
