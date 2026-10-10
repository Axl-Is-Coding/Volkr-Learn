package io.reactivex.subjects;

import io.reactivex.c.a.k;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.p;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class UnicastSubject<T> extends b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f22777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<w<? super T>> f22778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<Runnable> f22779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f22780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile boolean f22781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f22782f;
    Throwable g;
    final AtomicBoolean h;
    final BasicIntQueueDisposable<T> i;
    boolean j;

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            UnicastSubject.this.f22777a.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (UnicastSubject.this.f22781e) {
                return;
            }
            UnicastSubject unicastSubject = UnicastSubject.this;
            unicastSubject.f22781e = true;
            unicastSubject.d();
            UnicastSubject.this.f22778b.lazySet(null);
            if (UnicastSubject.this.i.getAndIncrement() == 0) {
                UnicastSubject.this.f22778b.lazySet(null);
                UnicastSubject.this.f22777a.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return UnicastSubject.this.f22781e;
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return UnicastSubject.this.f22777a.isEmpty();
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            return UnicastSubject.this.f22777a.poll();
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.j = true;
            return 2;
        }
    }

    UnicastSubject(int i, boolean z) {
        io.reactivex.internal.functions.a.a(i, "capacityHint");
        this.f22777a = new io.reactivex.internal.queue.a<>(i);
        this.f22779c = new AtomicReference<>();
        this.f22780d = z;
        this.f22778b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> a(int i) {
        return new UnicastSubject<>(i, true);
    }

    public static <T> UnicastSubject<T> c() {
        return new UnicastSubject<>(p.bufferSize(), true);
    }

    void b(w<? super T> wVar) {
        io.reactivex.internal.queue.a<T> aVar = this.f22777a;
        boolean z = !this.f22780d;
        boolean z2 = true;
        int iAddAndGet = 1;
        while (!this.f22781e) {
            boolean z3 = this.f22782f;
            T tPoll = this.f22777a.poll();
            boolean z4 = tPoll == null;
            if (z3) {
                if (z && z2) {
                    if (a(aVar, wVar)) {
                        return;
                    } else {
                        z2 = false;
                    }
                }
                if (z4) {
                    c(wVar);
                    return;
                }
            }
            if (z4) {
                iAddAndGet = this.i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                wVar.onNext(tPoll);
            }
        }
        this.f22778b.lazySet(null);
        aVar.clear();
    }

    void d() {
        Runnable runnable = this.f22779c.get();
        if (runnable == null || !this.f22779c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void e() {
        if (this.i.getAndIncrement() != 0) {
            return;
        }
        w<? super T> wVar = this.f22778b.get();
        int iAddAndGet = 1;
        while (wVar == null) {
            iAddAndGet = this.i.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                wVar = this.f22778b.get();
            }
        }
        if (this.j) {
            a(wVar);
        } else {
            b(wVar);
        }
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (this.f22782f || this.f22781e) {
            return;
        }
        this.f22782f = true;
        d();
        e();
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f22782f || this.f22781e) {
            io.reactivex.e.a.b(th);
            return;
        }
        this.g = th;
        this.f22782f = true;
        d();
        e();
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f22782f || this.f22781e) {
            return;
        }
        this.f22777a.offer(t);
        e();
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f22782f || this.f22781e) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super T> wVar) {
        if (this.h.get() || !this.h.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), wVar);
            return;
        }
        wVar.onSubscribe(this.i);
        this.f22778b.lazySet(wVar);
        if (this.f22781e) {
            this.f22778b.lazySet(null);
        } else {
            e();
        }
    }

    public static <T> UnicastSubject<T> a(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    void c(w<? super T> wVar) {
        this.f22778b.lazySet(null);
        Throwable th = this.g;
        if (th != null) {
            wVar.onError(th);
        } else {
            wVar.onComplete();
        }
    }

    void a(w<? super T> wVar) {
        io.reactivex.internal.queue.a<T> aVar = this.f22777a;
        int iAddAndGet = 1;
        boolean z = !this.f22780d;
        while (!this.f22781e) {
            boolean z2 = this.f22782f;
            if (z && z2 && a(aVar, wVar)) {
                return;
            }
            wVar.onNext(null);
            if (z2) {
                c(wVar);
                return;
            } else {
                iAddAndGet = this.i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        this.f22778b.lazySet(null);
        aVar.clear();
    }

    UnicastSubject(int i, Runnable runnable, boolean z) {
        io.reactivex.internal.functions.a.a(i, "capacityHint");
        this.f22777a = new io.reactivex.internal.queue.a<>(i);
        io.reactivex.internal.functions.a.a(runnable, "onTerminate");
        this.f22779c = new AtomicReference<>(runnable);
        this.f22780d = z;
        this.f22778b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }

    boolean a(k<T> kVar, w<? super T> wVar) {
        Throwable th = this.g;
        if (th == null) {
            return false;
        }
        this.f22778b.lazySet(null);
        kVar.clear();
        wVar.onError(th);
        return true;
    }
}
