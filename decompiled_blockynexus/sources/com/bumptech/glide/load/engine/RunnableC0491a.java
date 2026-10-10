package com.bumptech.glide.load.engine;

import android.os.Process;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0491a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f4465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ThreadFactoryC0492b f4466b;

    RunnableC0491a(ThreadFactoryC0492b threadFactoryC0492b, Runnable runnable) {
        this.f4466b = threadFactoryC0492b;
        this.f4465a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.f4465a.run();
    }
}
