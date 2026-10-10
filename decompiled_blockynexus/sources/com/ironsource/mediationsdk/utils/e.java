package com.ironsource.mediationsdk.utils;

import java.util.TimerTask;

/* JADX INFO: compiled from: DailyCappingManager.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f15024a;

    e(f fVar) {
        this.f15024a = fVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f15024a.c();
    }
}
