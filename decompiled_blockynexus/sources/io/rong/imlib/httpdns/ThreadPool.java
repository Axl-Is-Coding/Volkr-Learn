package io.rong.imlib.httpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
final class ThreadPool {
    private static final int corePoolSize = 1;
    private static final int keepAliveTime = 20;
    private static final int maximumBlockingQueue = 50;
    private static final int maximumPoolSize = 1;
    private static volatile ThreadPool threadPool;
    private final Executor executor = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private ThreadPool() {
    }

    static ThreadPool getInstance() {
        if (threadPool == null) {
            synchronized (ThreadPool.class) {
                if (threadPool == null) {
                    threadPool = new ThreadPool();
                }
            }
        }
        return threadPool;
    }

    Executor getExecutor() {
        return this.executor;
    }
}
