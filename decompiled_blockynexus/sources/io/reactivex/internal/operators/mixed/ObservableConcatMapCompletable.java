package io.reactivex.internal.operators.mixed;

import io.reactivex.AbstractC2894a;
import io.reactivex.b.o;
import io.reactivex.c;
import io.reactivex.c.a.f;
import io.reactivex.c.a.k;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.p;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMapCompletable<T> extends AbstractC2894a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final p<T> f21958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends c> f21959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f21960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f21961d;

    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements w<T>, b {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.b downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        final o<? super T, ? extends c> mapper;
        final int prefetch;
        k<T> queue;
        b upstream;

        static final class ConcatMapInnerObserver extends AtomicReference<b> implements io.reactivex.b {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        ConcatMapCompletableObserver(io.reactivex.b bVar, o<? super T, ? extends c> oVar, ErrorMode errorMode, int i) {
            this.downstream = bVar;
            this.mapper = oVar;
            this.errorMode = errorMode;
            this.prefetch = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable atomicThrowable = this.errors;
            ErrorMode errorMode = this.errorMode;
            while (!this.disposed) {
                if (!this.active) {
                    if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.disposed = true;
                        this.queue.clear();
                        this.downstream.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    c cVar = null;
                    try {
                        T tPoll = this.queue.poll();
                        if (tPoll != null) {
                            c cVarApply = this.mapper.apply(tPoll);
                            io.reactivex.internal.functions.a.a(cVarApply, "The mapper returned a null CompletableSource");
                            cVar = cVarApply;
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z2 && z) {
                            this.disposed = true;
                            Throwable thTerminate = atomicThrowable.terminate();
                            if (thTerminate != null) {
                                this.downstream.onError(thTerminate);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        }
                        if (!z) {
                            this.active = true;
                            cVar.a(this.inner);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.disposed = true;
                        this.queue.clear();
                        this.upstream.dispose();
                        atomicThrowable.addThrowable(th);
                        this.downstream.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.active = false;
                drain();
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            Throwable thTerminate = this.errors.terminate();
            if (thTerminate != ExceptionHelper.f22722a) {
                this.downstream.onError(thTerminate);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.done = true;
                drain();
                return;
            }
            this.disposed = true;
            this.inner.dispose();
            Throwable thTerminate = this.errors.terminate();
            if (thTerminate != ExceptionHelper.f22722a) {
                this.downstream.onError(thTerminate);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof f) {
                    f fVar = (f) bVar;
                    int iRequestFusion = fVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.queue = fVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(p<T> pVar, o<? super T, ? extends c> oVar, ErrorMode errorMode, int i) {
        this.f21958a = pVar;
        this.f21959b = oVar;
        this.f21960c = errorMode;
        this.f21961d = i;
    }

    @Override // io.reactivex.AbstractC2894a
    protected void b(io.reactivex.b bVar) {
        if (a.a(this.f21958a, this.f21959b, bVar)) {
            return;
        }
        this.f21958a.subscribe(new ConcatMapCompletableObserver(bVar, this.f21959b, this.f21960c, this.f21961d));
    }
}
