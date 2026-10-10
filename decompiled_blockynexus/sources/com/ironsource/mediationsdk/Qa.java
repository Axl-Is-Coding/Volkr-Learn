package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: compiled from: RvLoadTrigger.java */
/* JADX INFO: loaded from: classes2.dex */
class Qa extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ta f14722a;

    Qa(Ta ta) {
        this.f14722a = ta;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14722a.f14731b.c();
    }
}
