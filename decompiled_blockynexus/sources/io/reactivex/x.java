package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Scheduler.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f22787a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: compiled from: Scheduler.java */
    static final class a implements io.reactivex.disposables.b, io.reactivex.f.a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f22788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f22789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Thread f22790c;

        a(Runnable runnable, c cVar) {
            this.f22788a = runnable;
            this.f22789b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f22790c == Thread.currentThread()) {
                c cVar = this.f22789b;
                if (cVar instanceof io.reactivex.internal.schedulers.e) {
                    ((io.reactivex.internal.schedulers.e) cVar).a();
                    return;
                }
            }
            this.f22789b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22789b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22790c = Thread.currentThread();
            try {
                this.f22788a.run();
            } finally {
                dispose();
                this.f22790c = null;
            }
        }
    }

    /* JADX INFO: compiled from: Scheduler.java */
    static final class b implements io.reactivex.disposables.b, io.reactivex.f.a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f22791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f22792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f22793c;

        b(Runnable runnable, c cVar) {
            this.f22791a = runnable;
            this.f22792b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22793c = true;
            this.f22792b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22793c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22793c) {
                return;
            }
            try {
                this.f22791a.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22792b.dispose();
                throw ExceptionHelper.b(th);
            }
        }
    }

    /* JADX INFO: compiled from: Scheduler.java */
    public static abstract class c implements io.reactivex.disposables.b {

        /* JADX INFO: compiled from: Scheduler.java */
        final class a implements io.reactivex.f.a, Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Runnable f22794a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final SequentialDisposable f22795b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f22796c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f22797d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            long f22798e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            long f22799f;

            a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f22794a = runnable;
                this.f22795b = sequentialDisposable;
                this.f22796c = j3;
                this.f22798e = j2;
                this.f22799f = j;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r11 = this;
                    java.lang.Runnable r0 = r11.f22794a
                    r0.run()
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r11.f22795b
                    boolean r0 = r0.isDisposed()
                    if (r0 != 0) goto L55
                    io.reactivex.x$c r0 = io.reactivex.x.c.this
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r0 = r0.a(r1)
                    long r2 = io.reactivex.x.f22787a
                    long r4 = r0 + r2
                    long r6 = r11.f22798e
                    r8 = 1
                    int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r10 < 0) goto L35
                    long r4 = r11.f22796c
                    long r6 = r6 + r4
                    long r6 = r6 + r2
                    int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                    if (r2 < 0) goto L2a
                    goto L35
                L2a:
                    long r2 = r11.f22799f
                    long r6 = r11.f22797d
                    long r6 = r6 + r8
                    r11.f22797d = r6
                    long r6 = r6 * r4
                    long r2 = r2 + r6
                    goto L45
                L35:
                    long r2 = r11.f22796c
                    long r4 = r0 + r2
                    long r6 = r11.f22797d
                    long r6 = r6 + r8
                    r11.f22797d = r6
                    long r2 = r2 * r6
                    long r2 = r4 - r2
                    r11.f22799f = r2
                    r2 = r4
                L45:
                    r11.f22798e = r0
                    long r2 = r2 - r0
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r11.f22795b
                    io.reactivex.x$c r1 = io.reactivex.x.c.this
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
                    io.reactivex.disposables.b r1 = r1.a(r11, r2, r4)
                    r0.replace(r1)
                L55:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.reactivex.x.c.a.run():void");
            }
        }

        public io.reactivex.disposables.b a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableA = io.reactivex.e.a.a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long jA = a(TimeUnit.NANOSECONDS);
            io.reactivex.disposables.b bVarA = a(new a(jA + timeUnit.toNanos(j), runnableA, jA, sequentialDisposable2, nanos), j, timeUnit);
            if (bVarA == EmptyDisposable.INSTANCE) {
                return bVarA;
            }
            sequentialDisposable.replace(bVarA);
            return sequentialDisposable2;
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public abstract c a();

    public io.reactivex.disposables.b a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        c cVarA = a();
        a aVar = new a(io.reactivex.e.a.a(runnable), cVarA);
        cVarA.a(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c cVarA = a();
        b bVar = new b(io.reactivex.e.a.a(runnable), cVarA);
        io.reactivex.disposables.b bVarA = cVarA.a(bVar, j, j2, timeUnit);
        return bVarA == EmptyDisposable.INSTANCE ? bVarA : bVar;
    }
}
