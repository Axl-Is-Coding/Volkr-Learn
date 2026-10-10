package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSampleWithObservable<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<?> f22205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f22206c;

    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(io.reactivex.w<? super T> wVar, io.reactivex.u<?> uVar) {
            super(wVar, uVar);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(io.reactivex.w<? super T> wVar, io.reactivex.u<?> uVar) {
            super(wVar, uVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            emit();
        }
    }

    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -3517602651313910099L;
        final io.reactivex.w<? super T> downstream;
        final AtomicReference<io.reactivex.disposables.b> other = new AtomicReference<>();
        final io.reactivex.u<?> sampler;
        io.reactivex.disposables.b upstream;

        SampleMainObserver(io.reactivex.w<? super T> wVar, io.reactivex.u<?> uVar) {
            this.downstream = wVar;
            this.sampler = uVar;
        }

        public void complete() {
            this.upstream.dispose();
            completion();
        }

        abstract void completion();

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        public void error(Throwable th) {
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completion();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
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
                if (this.other.get() == null) {
                    this.sampler.subscribe(new a(this));
                }
            }
        }

        abstract void run();

        boolean setOther(io.reactivex.disposables.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }
    }

    static final class a<T> implements io.reactivex.w<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SampleMainObserver<T> f22207a;

        a(SampleMainObserver<T> sampleMainObserver) {
            this.f22207a = sampleMainObserver;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22207a.complete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22207a.error(th);
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            this.f22207a.run();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22207a.setOther(bVar);
        }
    }

    public ObservableSampleWithObservable(io.reactivex.u<T> uVar, io.reactivex.u<?> uVar2, boolean z) {
        super(uVar);
        this.f22205b = uVar2;
        this.f22206c = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        io.reactivex.observers.f fVar = new io.reactivex.observers.f(wVar);
        if (this.f22206c) {
            this.f22358a.subscribe(new SampleMainEmitLast(fVar, this.f22205b));
        } else {
            this.f22358a.subscribe(new SampleMainNoLast(fVar, this.f22205b));
        }
    }
}
