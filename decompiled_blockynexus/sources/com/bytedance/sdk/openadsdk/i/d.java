package com.bytedance.sdk.openadsdk.i;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TTThreadPool.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6999a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f7002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f7003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f7004f;
    private static final PriorityBlockingQueue<Runnable> g;
    private static final ArrayBlockingQueue<Runnable> h;

    static {
        int i = f6999a;
        f7000b = (i / 2) + 1 < 4 ? 4 : (i / 2) + 1;
        int i2 = f6999a;
        f7001c = (i2 / 2) + 1 < 4 ? 4 : (i2 / 2) + 1;
        int i3 = f6999a;
        f7002d = (i3 / 2) + 1 > 4 ? 4 : (i3 / 2) + 1;
        f7003e = new PriorityBlockingQueue<>();
        f7004f = new PriorityBlockingQueue<>();
        g = new PriorityBlockingQueue<>();
        h = new ArrayBlockingQueue<>(4);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, f7000b, 5L, TimeUnit.SECONDS, f7003e, new c(5, "tt-api-thread-"), f());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, f7001c, 5L, TimeUnit.SECONDS, f7004f, new c(5, "tt-background-thread-"), f());
    }

    public static ScheduledExecutorService c() {
        return Executors.newSingleThreadScheduledExecutor(new c(1, "tt-delay-thread-"));
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, g, new c(5, "tt-aidl-thread-"), f());
    }

    public static ThreadPoolExecutor e() {
        return new ThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS, h, new c(5, "tt-file-log-upload-thread-"), f());
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.i.d.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
