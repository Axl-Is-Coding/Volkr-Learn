package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ThreadFactoryBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
class s implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ThreadFactory f14072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f14073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AtomicLong f14074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Boolean f14075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Integer f14076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Thread.UncaughtExceptionHandler f14077f;

    s(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f14072a = threadFactory;
        this.f14073b = str;
        this.f14074c = atomicLong;
        this.f14075d = bool;
        this.f14076e = num;
        this.f14077f = uncaughtExceptionHandler;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f14072a.newThread(runnable);
        String str = this.f14073b;
        if (str != null) {
            threadNewThread.setName(t.b(str, Long.valueOf(this.f14074c.getAndIncrement())));
        }
        Boolean bool = this.f14075d;
        if (bool != null) {
            threadNewThread.setDaemon(bool.booleanValue());
        }
        Integer num = this.f14076e;
        if (num != null) {
            threadNewThread.setPriority(num.intValue());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f14077f;
        if (uncaughtExceptionHandler != null) {
            threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return threadNewThread;
    }
}
