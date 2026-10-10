package com.twitter.sdk.android.core.internal;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f20170a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f20171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20172c;

    static {
        int i = f20170a;
        f20171b = i + 1;
        f20172c = (i * 2) + 1;
    }

    public static ExecutorService a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f20171b, f20172c, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b(str));
        a(str, threadPoolExecutor);
        return threadPoolExecutor;
    }

    static ThreadFactory b(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1L);
        return new ThreadFactory() { // from class: com.twitter.sdk.android.core.internal.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return h.a(str, atomicLong, runnable);
            }
        };
    }

    static /* synthetic */ Thread a(String str, AtomicLong atomicLong, Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
        threadNewThread.setName(str + atomicLong.getAndIncrement());
        return threadNewThread;
    }

    static void a(String str, ExecutorService executorService) {
        a(str, executorService, 1L, TimeUnit.SECONDS);
    }

    static void a(final String str, final ExecutorService executorService, final long j, final TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() { // from class: com.twitter.sdk.android.core.internal.c
            @Override // java.lang.Runnable
            public final void run() {
                h.a(executorService, j, timeUnit, str);
            }
        }, "Twitter Shutdown Hook for " + str));
    }

    static /* synthetic */ void a(ExecutorService executorService, long j, TimeUnit timeUnit, String str) {
        try {
            executorService.shutdown();
            if (executorService.awaitTermination(j, timeUnit)) {
                return;
            }
            com.twitter.sdk.android.core.n.e().d("Twitter", str + " did not shutdown in the allocated time. Requesting immediate shutdown.");
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            com.twitter.sdk.android.core.n.e().d("Twitter", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", str));
            executorService.shutdownNow();
        }
    }
}
