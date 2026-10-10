package com.sandboxol.halloween.view.fragment.tasks;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: TasksViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
class i extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f18748a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i(j jVar, long j, long j2) {
        super(j, j2);
        this.f18748a = jVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        f fVar = this.f18748a.f18750b;
        if (fVar != null) {
            fVar.a(true);
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
