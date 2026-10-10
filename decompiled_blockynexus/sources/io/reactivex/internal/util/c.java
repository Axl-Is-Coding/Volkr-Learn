package io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static void a(CountDownLatch countDownLatch, io.reactivex.disposables.b bVar) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            a();
            countDownLatch.await();
        } catch (InterruptedException e2) {
            bVar.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    public static void a() {
        if (io.reactivex.e.a.a()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.f) || io.reactivex.e.a.b()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
