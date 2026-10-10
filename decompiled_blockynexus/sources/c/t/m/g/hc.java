package c.t.m.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class hc implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f3229a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadGroup f3230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f3231c = new AtomicInteger(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3232d;

    public hc(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f3230b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f3232d = str + "_" + f3229a.getAndIncrement() + "_thread_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f3230b, runnable, this.f3232d + this.f3231c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        try {
            thread.setPriority(5);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return thread;
    }
}
