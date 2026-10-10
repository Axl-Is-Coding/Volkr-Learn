package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.x;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: IoScheduler.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final RxThreadFactory f22665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final RxThreadFactory f22666c;
    static final a g;
    final ThreadFactory h;
    final AtomicReference<a> i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TimeUnit f22668e = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f22667d = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final C0207c f22669f = new C0207c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class b extends x.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f22677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final C0207c f22678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f22679d = new AtomicBoolean();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.disposables.a f22676a = new io.reactivex.disposables.a();

        b(a aVar) {
            this.f22677b = aVar;
            this.f22678c = aVar.b();
        }

        @Override // io.reactivex.x.c
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.f22676a.isDisposed() ? EmptyDisposable.INSTANCE : this.f22678c.a(runnable, j, timeUnit, this.f22676a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f22679d.compareAndSet(false, true)) {
                this.f22676a.dispose();
                this.f22677b.a(this.f22678c);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22679d.get();
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.schedulers.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IoScheduler.java */
    static final class C0207c extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f22680c;

        C0207c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f22680c = 0L;
        }

        public void a(long j) {
            this.f22680c = j;
        }

        public long b() {
            return this.f22680c;
        }
    }

    static {
        f22669f.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f22665b = new RxThreadFactory("RxCachedThreadScheduler", iMax);
        f22666c = new RxThreadFactory("RxCachedWorkerPoolEvictor", iMax);
        g = new a(0L, null, f22665b);
        g.d();
    }

    public c() {
        this(f22665b);
    }

    @Override // io.reactivex.x
    public x.c a() {
        return new b(this.i.get());
    }

    public void b() {
        a aVar = new a(f22667d, f22668e, this.h);
        if (this.i.compareAndSet(g, aVar)) {
            return;
        }
        aVar.d();
    }

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f22670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0207c> f22671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final io.reactivex.disposables.a f22672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f22673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Future<?> f22674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ThreadFactory f22675f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.f22670a = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f22671b = new ConcurrentLinkedQueue<>();
            this.f22672c = new io.reactivex.disposables.a();
            this.f22675f = threadFactory;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, c.f22666c);
                long j2 = this.f22670a;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f22673d = scheduledExecutorServiceNewScheduledThreadPool;
            this.f22674e = scheduledFutureScheduleWithFixedDelay;
        }

        void a(C0207c c0207c) {
            c0207c.a(c() + this.f22670a);
            this.f22671b.offer(c0207c);
        }

        C0207c b() {
            if (this.f22672c.isDisposed()) {
                return c.f22669f;
            }
            while (!this.f22671b.isEmpty()) {
                C0207c c0207cPoll = this.f22671b.poll();
                if (c0207cPoll != null) {
                    return c0207cPoll;
                }
            }
            C0207c c0207c = new C0207c(this.f22675f);
            this.f22672c.b(c0207c);
            return c0207c;
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.f22672c.dispose();
            Future<?> future = this.f22674e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f22673d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        void a() {
            if (this.f22671b.isEmpty()) {
                return;
            }
            long jC = c();
            for (C0207c c0207c : this.f22671b) {
                if (c0207c.b() > jC) {
                    return;
                }
                if (this.f22671b.remove(c0207c)) {
                    this.f22672c.a(c0207c);
                }
            }
        }
    }

    public c(ThreadFactory threadFactory) {
        this.h = threadFactory;
        this.i = new AtomicReference<>(g);
        b();
    }
}
