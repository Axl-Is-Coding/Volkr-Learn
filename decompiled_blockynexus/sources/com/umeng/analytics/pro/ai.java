package com.umeng.analytics.pro;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ThreadPoolUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class ai {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static BlockingQueue<Runnable> f20638d = new ArrayBlockingQueue(64);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f20635a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f20636b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f20637c = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f20639e = new ThreadPoolExecutor(f20635a, f20636b, f20637c, TimeUnit.SECONDS, f20638d);

    private ai() {
    }

    public static void a(Runnable runnable) {
        f20639e.execute(runnable);
    }
}
