package com.sandboxol.common.threadpoollib.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class DelayTaskDispatcher {
    private static DelayTaskDispatcher instance = new DelayTaskDispatcher();
    private ScheduledExecutorService dispatcher = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: com.sandboxol.common.threadpoollib.utils.DelayTaskDispatcher.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BM-Delay-Task-Dispatcher");
            thread.setPriority(10);
            return thread;
        }
    });

    private DelayTaskDispatcher() {
    }

    public static DelayTaskDispatcher get() {
        return instance;
    }

    public void postDelay(long j, final ExecutorService executorService, final Runnable runnable) {
        if (j == 0) {
            executorService.execute(runnable);
        } else {
            this.dispatcher.schedule(new Runnable() { // from class: com.sandboxol.common.threadpoollib.utils.DelayTaskDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    executorService.execute(runnable);
                }
            }, j, TimeUnit.MILLISECONDS);
        }
    }
}
