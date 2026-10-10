package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: compiled from: LWSProgRvManager.java */
/* JADX INFO: loaded from: classes2.dex */
class X extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LWSProgRvManager f14743a;

    X(LWSProgRvManager lWSProgRvManager) {
        this.f14743a = lWSProgRvManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14743a.g();
    }
}
