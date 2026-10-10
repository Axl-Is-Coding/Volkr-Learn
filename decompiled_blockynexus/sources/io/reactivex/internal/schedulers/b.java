package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: InstantPeriodicTask.java */
/* JADX INFO: loaded from: classes5.dex */
final class b implements Callable<Void>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final FutureTask<Void> f22659a = new FutureTask<>(Functions.f21803b, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Runnable f22660b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final ExecutorService f22663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Thread f22664f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference<Future<?>> f22662d = new AtomicReference<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<Future<?>> f22661c = new AtomicReference<>();

    b(Runnable runnable, ExecutorService executorService) {
        this.f22660b = runnable;
        this.f22663e = executorService;
    }

    void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f22662d.get();
            if (future2 == f22659a) {
                future.cancel(this.f22664f != Thread.currentThread());
                return;
            }
        } while (!this.f22662d.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f22661c.get();
            if (future2 == f22659a) {
                future.cancel(this.f22664f != Thread.currentThread());
                return;
            }
        } while (!this.f22661c.compareAndSet(future2, future));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Future<?> andSet = this.f22662d.getAndSet(f22659a);
        if (andSet != null && andSet != f22659a) {
            andSet.cancel(this.f22664f != Thread.currentThread());
        }
        Future<?> andSet2 = this.f22661c.getAndSet(f22659a);
        if (andSet2 == null || andSet2 == f22659a) {
            return;
        }
        andSet2.cancel(this.f22664f != Thread.currentThread());
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f22662d.get() == f22659a;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f22664f = Thread.currentThread();
        try {
            this.f22660b.run();
            b(this.f22663e.submit(this));
            this.f22664f = null;
        } catch (Throwable th) {
            this.f22664f = null;
            io.reactivex.e.a.b(th);
        }
        return null;
    }
}
