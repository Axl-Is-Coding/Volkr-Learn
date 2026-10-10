package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMapCompletable<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.c> f22114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f22115c;

    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements io.reactivex.w<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final io.reactivex.w<? super T> downstream;
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

        FlatMapCompletableMainObserver(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.c> oVar, boolean z) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
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

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return true;
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

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public ObservableFlatMapCompletable(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.c> oVar, boolean z) {
        super(uVar);
        this.f22114b = oVar;
        this.f22115c = z;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new FlatMapCompletableMainObserver(wVar, this.f22114b, this.f22115c));
    }
}
