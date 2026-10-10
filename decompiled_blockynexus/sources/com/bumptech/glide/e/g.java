package com.bumptech.glide.e;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Executors.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f4165a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f4166b = new f();

    public static Executor a() {
        return f4166b;
    }

    public static Executor b() {
        return f4165a;
    }

    public static void a(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
            } else {
                throw new RuntimeException("Failed to shutdown");
            }
        } catch (InterruptedException e2) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e2);
        }
    }
}
