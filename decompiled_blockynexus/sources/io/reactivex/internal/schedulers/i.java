package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.x;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleScheduler.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final RxThreadFactory f22691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final ScheduledExecutorService f22692c = Executors.newScheduledThreadPool(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ThreadFactory f22693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f22694e;

    /* JADX INFO: compiled from: SingleScheduler.java */
    static final class a extends x.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f22695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.disposables.a f22696b = new io.reactivex.disposables.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f22697c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f22695a = scheduledExecutorService;
        }

        @Override // io.reactivex.x.c
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f22697c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.e.a.a(runnable), this.f22696b);
            this.f22696b.b(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j <= 0 ? this.f22695a.submit((Callable) scheduledRunnable) : this.f22695a.schedule((Callable) scheduledRunnable, j, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e2) {
                dispose();
                io.reactivex.e.a.b(e2);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f22697c) {
                return;
            }
            this.f22697c = true;
            this.f22696b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22697c;
        }
    }

    static {
        f22692c.shutdown();
        f22691b = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public i() {
        this(f22691b);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return h.a(threadFactory);
    }

    public i(ThreadFactory threadFactory) {
        this.f22694e = new AtomicReference<>();
        this.f22693d = threadFactory;
        this.f22694e.lazySet(a(threadFactory));
    }

    @Override // io.reactivex.x
    public x.c a() {
        return new a(this.f22694e.get());
    }

    @Override // io.reactivex.x
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.e.a.a(runnable));
        try {
            if (j <= 0) {
                futureSchedule = this.f22694e.get().submit(scheduledDirectTask);
            } else {
                futureSchedule = this.f22694e.get().schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(futureSchedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.e.a.b(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.x
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableA = io.reactivex.e.a.a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f22694e.get();
            b bVar = new b(runnableA, scheduledExecutorService);
            try {
                if (j <= 0) {
                    futureSchedule = scheduledExecutorService.submit(bVar);
                } else {
                    futureSchedule = scheduledExecutorService.schedule(bVar, j, timeUnit);
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
            scheduledDirectPeriodicTask.setFuture(this.f22694e.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            io.reactivex.e.a.b(e3);
            return EmptyDisposable.INSTANCE;
        }
    }
}
