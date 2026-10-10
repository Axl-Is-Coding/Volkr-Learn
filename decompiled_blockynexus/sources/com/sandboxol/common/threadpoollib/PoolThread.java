package com.sandboxol.common.threadpoollib;

import android.text.TextUtils;
import com.sandboxol.common.threadpoollib.callback.AsyncListener;
import com.sandboxol.common.threadpoollib.callback.ThreadListener;
import com.sandboxol.common.threadpoollib.config.ThreadConfigs;
import com.sandboxol.common.threadpoollib.executor.AndroidExecutor;
import com.sandboxol.common.threadpoollib.factory.ThreadCreator;
import com.sandboxol.common.threadpoollib.utils.DelayTaskDispatcher;
import com.sandboxol.common.threadpoollib.wrapper.CallableWrapper;
import com.sandboxol.common.threadpoollib.wrapper.RunnableWrapper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class PoolThread implements Executor {
    private Executor defaultExecutor;
    private ThreadListener defaultListener;
    private String defaultName;
    private ThreadLocal<ThreadConfigs> local;
    private ExecutorService pool;

    public static class Builder {
        static final int TYPE_CACHE = 0;
        static final int TYPE_FIXED = 1;
        static final int TYPE_SCHEDULED = 3;
        static final int TYPE_SINGLE = 2;
        Executor executor;
        ThreadListener listener;
        String name;
        ExecutorService pool;
        int priority = 5;
        int size;
        int type;

        private Builder(int i, int i2, ExecutorService executorService) {
            this.size = Math.max(1, i);
            this.type = i2;
            this.pool = executorService;
        }

        public static Builder create(ExecutorService executorService) {
            return new Builder(1, 2, executorService);
        }

        public static Builder createCacheable() {
            return new Builder(0, 0, null);
        }

        public static Builder createFixed(int i) {
            return new Builder(i, 1, null);
        }

        public static Builder createScheduled(int i) {
            return new Builder(i, 3, null);
        }

        public static Builder createSingle() {
            return new Builder(0, 2, null);
        }

        public PoolThread build() {
            this.priority = Math.max(1, this.priority);
            this.priority = Math.min(10, this.priority);
            this.size = Math.max(1, this.size);
            if (TextUtils.isEmpty(this.name)) {
                int i = this.type;
                if (i == 0) {
                    this.name = "BM-CACHE";
                } else if (i == 1) {
                    this.name = "BM-FIXED";
                } else if (i != 2) {
                    this.name = "BM-POOL_THREAD";
                } else {
                    this.name = "BM-SINGLE";
                }
            }
            if (this.executor == null) {
                this.executor = AndroidExecutor.getInstance();
            }
            return new PoolThread(this.type, this.size, this.priority, this.name, this.listener, this.executor, this.pool);
        }

        public Builder setExecutor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public Builder setListener(ThreadListener threadListener) {
            this.listener = threadListener;
            return this;
        }

        public Builder setName(String str) {
            if (str.length() > 0) {
                this.name = str;
            }
            return this;
        }

        public Builder setPriority(int i) {
            this.priority = i;
            return this;
        }
    }

    private synchronized ExecutorService createPool(int i, int i2, int i3) {
        if (i == 0) {
            return Executors.newCachedThreadPool(new ThreadCreator(i3));
        }
        if (i == 1) {
            return Executors.newFixedThreadPool(i2, new ThreadCreator(i3));
        }
        if (i != 3) {
            return Executors.newSingleThreadExecutor(new ThreadCreator(i3));
        }
        return Executors.newScheduledThreadPool(i2, new ThreadCreator(i3));
    }

    private synchronized ThreadConfigs getLocalConfigs() {
        ThreadConfigs threadConfigs;
        threadConfigs = this.local.get();
        if (threadConfigs == null) {
            threadConfigs = new ThreadConfigs();
            threadConfigs.threadName = this.defaultName;
            threadConfigs.listener = this.defaultListener;
            threadConfigs.executor = this.defaultExecutor;
            this.local.set(threadConfigs);
        }
        return threadConfigs;
    }

    private synchronized void resetLocalConfigs() {
        this.local.set(null);
    }

    public <T> void async(Callable<T> callable, AsyncListener<T> asyncListener) {
        ThreadConfigs localConfigs = getLocalConfigs();
        localConfigs.asyncListener = asyncListener;
        DelayTaskDispatcher.get().postDelay(localConfigs.delay, this.pool, new RunnableWrapper(localConfigs).setCallable(callable));
        resetLocalConfigs();
    }

    public void close() {
        ThreadLocal<ThreadConfigs> threadLocal = this.local;
        if (threadLocal != null) {
            threadLocal.remove();
            this.local = null;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ThreadConfigs localConfigs = getLocalConfigs();
        DelayTaskDispatcher.get().postDelay(localConfigs.delay, this.pool, new RunnableWrapper(localConfigs).setRunnable(runnable));
        resetLocalConfigs();
    }

    public ExecutorService getExecutor() {
        return this.pool;
    }

    public PoolThread setDelay(long j, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j);
        getLocalConfigs().delay = Math.max(0L, millis);
        return this;
    }

    public PoolThread setDeliver(Executor executor) {
        getLocalConfigs().executor = executor;
        return this;
    }

    public PoolThread setListener(ThreadListener threadListener) {
        getLocalConfigs().listener = threadListener;
        return this;
    }

    public PoolThread setName(String str) {
        getLocalConfigs().threadName = str;
        return this;
    }

    public void stop() {
        try {
            try {
                this.pool.shutdown();
                if (!this.pool.awaitTermination(0L, TimeUnit.MILLISECONDS)) {
                    this.pool.shutdownNow();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        } finally {
            this.pool.shutdownNow();
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        Future<T> futureSubmit = this.pool.submit(new CallableWrapper(getLocalConfigs(), callable));
        resetLocalConfigs();
        return futureSubmit;
    }

    private PoolThread(int i, int i2, int i3, String str, ThreadListener threadListener, Executor executor, ExecutorService executorService) {
        this.pool = executorService == null ? createPool(i, i2, i3) : executorService;
        this.defaultName = str;
        this.defaultExecutor = executor;
        this.defaultListener = threadListener;
        this.local = new ThreadLocal<>();
    }
}
