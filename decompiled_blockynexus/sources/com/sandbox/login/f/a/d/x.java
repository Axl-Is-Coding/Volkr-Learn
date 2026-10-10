package com.sandbox.login.f.a.d;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class x extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f15842a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    x(E e2, long j, long j2) {
        super(j, j2);
        this.f15842a = e2;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f15842a.t.set(true);
        this.f15842a.f15804b = true;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
