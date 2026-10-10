package com.sandboxol.decorate.view.fragment.dress;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: DressViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class qa extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ va f17454a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    qa(va vaVar, long j, long j2) {
        super(j, j2);
        this.f17454a = vaVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.sandboxol.decorate.manager.v.f();
        this.f17454a.l.set(true);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
