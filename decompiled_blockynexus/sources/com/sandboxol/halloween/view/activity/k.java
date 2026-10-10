package com.sandboxol.halloween.view.activity;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: HalloweenHomeViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
class k extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f18659a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(l lVar, long j, long j2) {
        super(j, j2);
        this.f18659a = lVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f18659a.o.set(true);
        this.f18659a.f18665f = true;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
