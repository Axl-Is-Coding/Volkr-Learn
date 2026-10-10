package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.x;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: TrampolineScheduler.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j f22698b = new j();

    /* JADX INFO: compiled from: TrampolineScheduler.java */
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f22699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f22700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f22701c;

        a(Runnable runnable, c cVar, long j) {
            this.f22699a = runnable;
            this.f22700b = cVar;
            this.f22701c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22700b.f22709d) {
                return;
            }
            long jA = this.f22700b.a(TimeUnit.MILLISECONDS);
            long j = this.f22701c;
            if (j > jA) {
                try {
                    Thread.sleep(j - jA);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    io.reactivex.e.a.b(e2);
                    return;
                }
            }
            if (this.f22700b.f22709d) {
                return;
            }
            this.f22699a.run();
        }
    }

    /* JADX INFO: compiled from: TrampolineScheduler.java */
    static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f22702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f22703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f22705d;

        b(Runnable runnable, Long l, int i) {
            this.f22702a = runnable;
            this.f22703b = l.longValue();
            this.f22704c = i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iA = io.reactivex.internal.functions.a.a(this.f22703b, bVar.f22703b);
            return iA == 0 ? io.reactivex.internal.functions.a.a(this.f22704c, bVar.f22704c) : iA;
        }
    }

    /* JADX INFO: compiled from: TrampolineScheduler.java */
    static final class c extends x.c implements io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue<b> f22706a = new PriorityBlockingQueue<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f22707b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f22708c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f22709d;

        /* JADX INFO: compiled from: TrampolineScheduler.java */
        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f22710a;

            a(b bVar) {
                this.f22710a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = this.f22710a;
                bVar.f22705d = true;
                c.this.f22706a.remove(bVar);
            }
        }

        c() {
        }

        @Override // io.reactivex.x.c
        public io.reactivex.disposables.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22709d = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22709d;
        }

        @Override // io.reactivex.x.c
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, jA), jA);
        }

        io.reactivex.disposables.b a(Runnable runnable, long j) {
            if (this.f22709d) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f22708c.incrementAndGet());
            this.f22706a.add(bVar);
            if (this.f22707b.getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f22709d) {
                    b bVarPoll = this.f22706a.poll();
                    if (bVarPoll == null) {
                        iAddAndGet = this.f22707b.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                    } else if (!bVarPoll.f22705d) {
                        bVarPoll.f22702a.run();
                    }
                }
                this.f22706a.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.a(new a(bVar));
        }
    }

    j() {
    }

    public static j b() {
        return f22698b;
    }

    @Override // io.reactivex.x
    public x.c a() {
        return new c();
    }

    @Override // io.reactivex.x
    public io.reactivex.disposables.b a(Runnable runnable) {
        io.reactivex.e.a.a(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.x
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.e.a.a(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            io.reactivex.e.a.b(e2);
        }
        return EmptyDisposable.INSTANCE;
    }
}
