package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2894a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends AbstractC2894a implements io.reactivex.c.a.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.c> f22117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f22118c;

    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, io.reactivex.w<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final io.reactivex.b downstream;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.c> mapper;
        io.reactivex.disposables.b upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.b, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onComplete() {
                FlatMapCompletableMainObserver.this.innerComplete(this);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.innerError(this, th);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        FlatMapCompletableMainObserver(io.reactivex.b bVar, io.reactivex.b.o<? super T, ? extends io.reactivex.c> oVar, boolean z) {
            this.downstream = bVar;
            this.mapper = oVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            onComplete();
        }

        void innerError(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thTerminate = this.errors.terminate();
                if (thTerminate != null) {
                    this.downstream.onError(thTerminate);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.downstream.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.downstream.onError(this.errors.terminate());
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            try {
                io.reactivex.c cVarApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(cVarApply, "The mapper returned a null CompletableSource");
                io.reactivex.c cVar = cVarApply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.disposed || !this.set.b(innerObserver)) {
                    return;
                }
                cVar.a(innerObserver);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.c> oVar, boolean z) {
        this.f22116a = uVar;
        this.f22117b = oVar;
        this.f22118c = z;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<T> a() {
        return io.reactivex.e.a.a(new ObservableFlatMapCompletable(this.f22116a, this.f22117b, this.f22118c));
    }

    @Override // io.reactivex.AbstractC2894a
    protected void b(io.reactivex.b bVar) {
        this.f22116a.subscribe(new FlatMapCompletableMainObserver(bVar, this.f22117b, this.f22118c));
    }
}
