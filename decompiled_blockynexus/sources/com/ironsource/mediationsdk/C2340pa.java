package com.ironsource.mediationsdk;

import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.pa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgRvManager.java */
/* JADX INFO: loaded from: classes2.dex */
class C2340pa extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgRvManager f14961a;

    C2340pa(ProgRvManager progRvManager) {
        this.f14961a = progRvManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14961a.h();
    }
}
