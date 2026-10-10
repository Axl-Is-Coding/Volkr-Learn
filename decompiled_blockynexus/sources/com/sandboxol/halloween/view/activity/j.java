package com.sandboxol.halloween.view.activity;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: HalloweenHomeViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
class j extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f18658a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(l lVar, long j, long j2) {
        super(j, j2);
        this.f18658a = lVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f18658a.o.set(true);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
