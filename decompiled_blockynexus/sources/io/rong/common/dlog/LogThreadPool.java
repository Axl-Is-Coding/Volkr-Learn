package io.rong.common.dlog;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class LogThreadPool {
    private ScheduledThreadPoolExecutor executorService;

    public LogThreadPool(int i) {
        this.executorService = new ScheduledThreadPoolExecutor(i, threadFactory("Upload Dispatcher", false));
        this.executorService.setMaximumPoolSize(5);
        this.executorService.setKeepAliveTime(60L, TimeUnit.SECONDS);
        this.executorService.allowCoreThreadTimeOut(true);
    }

    private ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: io.rong.common.dlog.LogThreadPool.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public ScheduledThreadPoolExecutor getExecutorService() {
        return this.executorService;
    }
}
