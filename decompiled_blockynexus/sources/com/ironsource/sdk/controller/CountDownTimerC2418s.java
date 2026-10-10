package com.ironsource.sdk.controller;

import android.os.CountDownTimer;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class CountDownTimerC2418s extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ A f15330a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC2418s(A a2, long j, long j2) {
        super(j, j2);
        this.f15330a = a2;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.ironsource.sdk.utils.f.c(this.f15330a.f15109b, "Global Controller Timer Finish");
        this.f15330a.g();
        A.f15108a.post(new r(this));
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        com.ironsource.sdk.utils.f.c(this.f15330a.f15109b, "Global Controller Timer Tick " + j);
    }
}
