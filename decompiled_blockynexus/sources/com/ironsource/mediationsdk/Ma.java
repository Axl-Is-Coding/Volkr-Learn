package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: compiled from: RewardedVideoManager.java */
/* JADX INFO: loaded from: classes2.dex */
class Ma extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Na f14688a;

    Ma(Na na) {
        this.f14688a = na;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        cancel();
        this.f14688a.q();
        this.f14688a.t();
    }
}
