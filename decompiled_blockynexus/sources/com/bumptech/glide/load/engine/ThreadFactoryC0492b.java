package com.bumptech.glide.load.engine;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
class ThreadFactoryC0492b implements ThreadFactory {
    ThreadFactoryC0492b() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(new RunnableC0491a(this, runnable), "glide-active-resources");
    }
}
