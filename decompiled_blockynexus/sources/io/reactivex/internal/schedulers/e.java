package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.x;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: NewThreadWorker.java */
/* JADX INFO: loaded from: classes5.dex */
public class e extends x.c implements io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f22683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f22684b;

    public e(ThreadFactory threadFactory) {
        this.f22683a = h.a(threadFactory);
    }

    @Override // io.reactivex.x.c
    public io.reactivex.disposables.b a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.e.a.a(runnable));
        try {
            scheduledDirectTask.setFuture(j <= 0 ? this.f22683a.submit(scheduledDirectTask) : this.f22683a.schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.e.a.b(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f22684b) {
            return;
        }
        this.f22684b = true;
        this.f22683a.shutdownNow();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f22684b;
    }

    @Override // io.reactivex.x.c
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f22684b ? EmptyDisposable.INSTANCE : a(runnable, j, timeUnit, (io.reactivex.internal.disposables.a) null);
    }

    public ScheduledRunnable a(Runnable runnable, long j, TimeUnit timeUnit, io.reactivex.internal.disposables.a aVar) {
        Future<?> futureSchedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.e.a.a(runnable), aVar);
        if (aVar != null && !aVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            if (j <= 0) {
                futureSchedule = this.f22683a.submit((Callable) scheduledRunnable);
            } else {
                futureSchedule = this.f22683a.schedule((Callable) scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(futureSchedule);
        } catch (RejectedExecutionException e2) {
            if (aVar != null) {
                aVar.a(scheduledRunnable);
            }
            io.reactivex.e.a.b(e2);
        }
        return scheduledRunnable;
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableA = io.reactivex.e.a.a(runnable);
        if (j2 <= 0) {
            b bVar = new b(runnableA, this.f22683a);
            try {
                if (j <= 0) {
                    futureSchedule = this.f22683a.submit(bVar);
                } else {
                    futureSchedule = this.f22683a.schedule(bVar, j, timeUnit);
                }
                bVar.a(futureSchedule);
                return bVar;
            } catch (RejectedExecutionException e2) {
                io.reactivex.e.a.b(e2);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableA);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f22683a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            io.reactivex.e.a.b(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void a() {
        if (this.f22684b) {
            return;
        }
        this.f22684b = true;
        this.f22683a.shutdown();
    }
}
