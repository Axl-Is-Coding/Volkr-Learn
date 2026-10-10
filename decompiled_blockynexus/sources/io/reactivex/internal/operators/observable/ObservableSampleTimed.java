package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSampleTimed<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.x f22203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f22204e;

    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            super(wVar, j, timeUnit, xVar);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            super(wVar, j, timeUnit, xVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final io.reactivex.w<? super T> downstream;
        final long period;
        final io.reactivex.x scheduler;
        final AtomicReference<io.reactivex.disposables.b> timer = new AtomicReference<>();
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;

        SampleTimedObserver(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            this.downstream = wVar;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = xVar;
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        abstract void complete();

        @Override // io.reactivex.disposables.b
        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            cancelTimer();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                io.reactivex.x xVar = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, xVar.a(this, j, j, this.unit));
            }
        }
    }

    public ObservableSampleTimed(io.reactivex.u<T> uVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, boolean z) {
        super(uVar);
        this.f22201b = j;
        this.f22202c = timeUnit;
        this.f22203d = xVar;
        this.f22204e = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        io.reactivex.observers.f fVar = new io.reactivex.observers.f(wVar);
        if (this.f22204e) {
            this.f22358a.subscribe(new SampleTimedEmitLast(fVar, this.f22201b, this.f22202c, this.f22203d));
        } else {
            this.f22358a.subscribe(new SampleTimedNoLast(fVar, this.f22201b, this.f22202c, this.f22203d));
        }
    }
}
