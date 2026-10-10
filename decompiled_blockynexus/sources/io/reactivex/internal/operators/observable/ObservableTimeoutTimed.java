package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTimeoutTimed<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.x f22259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22260e;

    static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.disposables.b, b {
        private static final long serialVersionUID = 3764492702657003550L;
        final io.reactivex.w<? super T> downstream;
        io.reactivex.u<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final x.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicLong index = new AtomicLong();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutFallbackObserver(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar, io.reactivex.u<? extends T> uVar) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = uVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                io.reactivex.u<? extends T> uVar = this.fallback;
                this.fallback = null;
                uVar.subscribe(new a(this.downstream, this));
                this.worker.dispose();
            }
        }

        void startTimeout(long j) {
            this.task.replace(this.worker.a(new c(j, this), this.timeout, this.unit));
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements io.reactivex.w<T>, io.reactivex.disposables.b, b {
        private static final long serialVersionUID = 3764492702657003550L;
        final io.reactivex.w<? super T> downstream;
        final long timeout;
        final TimeUnit unit;
        final x.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutObserver(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException(ExceptionHelper.a(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        void startTimeout(long j) {
            this.task.replace(this.worker.a(new c(j, this), this.timeout, this.unit));
        }
    }

    static final class a<T> implements io.reactivex.w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f22262b;

        a(io.reactivex.w<? super T> wVar, AtomicReference<io.reactivex.disposables.b> atomicReference) {
            this.f22261a = wVar;
            this.f22262b = atomicReference;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22261a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22261a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22261a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f22262b, bVar);
        }
    }

    interface b {
        void onTimeout(long j);
    }

    static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f22263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f22264b;

        c(long j, b bVar) {
            this.f22264b = j;
            this.f22263a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22263a.onTimeout(this.f22264b);
        }
    }

    public ObservableTimeoutTimed(io.reactivex.p<T> pVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, io.reactivex.u<? extends T> uVar) {
        super(pVar);
        this.f22257b = j;
        this.f22258c = timeUnit;
        this.f22259d = xVar;
        this.f22260e = uVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        if (this.f22260e == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(wVar, this.f22257b, this.f22258c, this.f22259d.a());
            wVar.onSubscribe(timeoutObserver);
            timeoutObserver.startTimeout(0L);
            this.f22358a.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(wVar, this.f22257b, this.f22258c, this.f22259d.a(), this.f22260e);
        wVar.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.startTimeout(0L);
        this.f22358a.subscribe(timeoutFallbackObserver);
    }
}
