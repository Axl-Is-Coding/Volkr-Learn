package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: compiled from: RvLoadTrigger.java */
/* JADX INFO: loaded from: classes2.dex */
class Ra extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ta f14723a;

    Ra(Ta ta) {
        this.f14723a = ta;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14723a.f14731b.c();
    }
}
