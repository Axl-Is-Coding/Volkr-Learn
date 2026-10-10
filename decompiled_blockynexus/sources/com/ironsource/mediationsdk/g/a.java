package com.ironsource.mediationsdk.g;

import java.util.TimerTask;

/* JADX INFO: compiled from: AbstractTimer.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f14825a;

    a(b bVar) {
        this.f14825a = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14825a.b();
    }
}
