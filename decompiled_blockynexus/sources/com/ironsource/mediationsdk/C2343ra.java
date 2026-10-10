package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ra, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgRvManager.java */
/* JADX INFO: loaded from: classes2.dex */
class C2343ra extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgRvManager f14965a;

    C2343ra(ProgRvManager progRvManager) {
        this.f14965a = progRvManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14965a.g();
    }
}
