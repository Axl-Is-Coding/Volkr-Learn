package com.tendcloud.tenddata;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f19754a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f19758e = 30;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f19755b = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19756c = Math.max(2, Math.min(f19755b - 1, 4));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f19757d = (f19755b * 2) + 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f19759f = new ThreadFactory() { // from class: com.tendcloud.tenddata.ad.1
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ThreadPoolUtils #" + this.mCount.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue(128);

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f19756c, f19757d, 30L, TimeUnit.SECONDS, g, f19759f);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f19754a = threadPoolExecutor;
    }
}
