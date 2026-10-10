package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.x;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ComputationScheduler.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends x implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final b f22646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final RxThreadFactory f22647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f22648d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final c f22649e = new c(new RxThreadFactory("RxComputationShutdown"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ThreadFactory f22650f;
    final AtomicReference<b> g;

    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f22656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f22657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f22658c;

        b(int i, ThreadFactory threadFactory) {
            this.f22656a = i;
            this.f22657b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f22657b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f22656a;
            if (i == 0) {
                return a.f22649e;
            }
            c[] cVarArr = this.f22657b;
            long j = this.f22658c;
            this.f22658c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        public void b() {
            for (c cVar : this.f22657b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f22649e.dispose();
        f22647c = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f22646b = new b(0, f22647c);
        f22646b.b();
    }

    public a() {
        this(f22647c);
    }

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // io.reactivex.x
    public x.c a() {
        return new C0206a(this.g.get().a());
    }

    public void b() {
        b bVar = new b(f22648d, this.f22650f);
        if (this.g.compareAndSet(f22646b, bVar)) {
            return;
        }
        bVar.b();
    }

    public a(ThreadFactory threadFactory) {
        this.f22650f = threadFactory;
        this.g = new AtomicReference<>(f22646b);
        b();
    }

    @Override // io.reactivex.x
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, j, timeUnit);
    }

    /* JADX INFO: renamed from: io.reactivex.internal.schedulers.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class C0206a extends x.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f22651a = new io.reactivex.internal.disposables.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.disposables.a f22652b = new io.reactivex.disposables.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f22653c = new io.reactivex.internal.disposables.b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c f22654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f22655e;

        C0206a(c cVar) {
            this.f22654d = cVar;
            this.f22653c.b(this.f22651a);
            this.f22653c.b(this.f22652b);
        }

        @Override // io.reactivex.x.c
        public io.reactivex.disposables.b a(Runnable runnable) {
            return this.f22655e ? EmptyDisposable.INSTANCE : this.f22654d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f22651a);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f22655e) {
                return;
            }
            this.f22655e = true;
            this.f22653c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22655e;
        }

        @Override // io.reactivex.x.c
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f22655e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f22654d.a(runnable, j, timeUnit, this.f22652b);
        }
    }

    @Override // io.reactivex.x
    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, j, j2, timeUnit);
    }
}
