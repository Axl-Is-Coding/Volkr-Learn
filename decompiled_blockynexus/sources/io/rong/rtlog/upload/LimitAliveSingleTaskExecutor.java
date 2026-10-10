package io.rong.rtlog.upload;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class LimitAliveSingleTaskExecutor {
    private static final long DEFAULT_THREAD_KEEP_ALIVE_TIME_MILLIS = 60000;
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, DEFAULT_THREAD_KEEP_ALIVE_TIME_MILLIS, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    LimitAliveSingleTaskExecutor() {
        this.executor.allowCoreThreadTimeOut(true);
    }

    void execute(final Runnable runnable, final long j) {
        this.executor.execute(new Runnable() { // from class: io.rong.rtlog.upload.LimitAliveSingleTaskExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                runnable.run();
            }
        });
    }

    boolean isExecutingTask() {
        return this.executor.getActiveCount() > 0;
    }

    void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }
}
