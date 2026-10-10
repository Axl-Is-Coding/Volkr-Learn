package com.ironsource.sdk.controller;

import android.os.CountDownTimer;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.na, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class CountDownTimerC2410na extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f15314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController f15315b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC2410na(WebController webController, long j, long j2, int i) {
        super(j, j2);
        this.f15315b = webController;
        this.f15314a = i;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.ironsource.sdk.utils.f.c(this.f15315b.TAG, "Loading Controller Timer Finish");
        int i = this.f15314a;
        if (i == 3) {
            this.f15315b.mControllerListener.a("controller failed to load");
        } else {
            this.f15315b.load(i + 1);
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        com.ironsource.sdk.utils.f.c(this.f15315b.TAG, "Loading Controller Timer Tick " + j);
    }
}
