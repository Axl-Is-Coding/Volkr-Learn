package com.sandbox.login.f.a.d;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class y extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f15843a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    y(E e2, long j, long j2) {
        super(j, j2);
        this.f15843a = e2;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f15843a.t.set(true);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
