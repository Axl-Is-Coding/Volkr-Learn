package com.sandboxol.common.threadpoollib.factory;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadCreator implements ThreadFactory {
    private int priority;

    public ThreadCreator(int i) {
        this.priority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(this.priority);
        return thread;
    }
}
