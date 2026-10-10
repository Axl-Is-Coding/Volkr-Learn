package io.reactivex.internal.operators.observable;

import a.a.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMap<T, U> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> f22089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f22090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ErrorMode f22091d;

    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final io.reactivex.w<? super R> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        io.reactivex.c.a.k<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        io.reactivex.disposables.b upstream;

        static final class DelayErrorInnerObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final io.reactivex.w<? super R> downstream;
            final ConcatMapDelayErrorObserver<?, R> parent;

            DelayErrorInnerObserver(io.reactivex.w<? super R> wVar, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.downstream = wVar;
                this.parent = concatMapDelayErrorObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.w
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (!concatMapDelayErrorObserver.error.addThrowable(th)) {
                    io.reactivex.e.a.b(th);
                    return;
                }
                if (!concatMapDelayErrorObserver.tillTheEnd) {
                    concatMapDelayErrorObserver.upstream.dispose();
                }
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // io.reactivex.w
            public void onNext(R r) {
                this.downstream.onNext(r);
            }

            @Override // io.reactivex.w
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        ConcatMapDelayErrorObserver(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar, int i, boolean z) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.bufferSize = i;
            this.tillTheEnd = z;
            this.observer = new DelayErrorInnerObserver<>(wVar, this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.w<? super R> wVar = this.downstream;
            io.reactivex.c.a.k<T> kVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        kVar.clear();
                        return;
                    }
                    if (!this.tillTheEnd && atomicThrowable.get() != null) {
                        kVar.clear();
                        this.cancelled = true;
                        wVar.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    try {
                        T tPoll = kVar.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.cancelled = true;
                            Throwable thTerminate = atomicThrowable.terminate();
                            if (thTerminate != null) {
                                wVar.onError(thTerminate);
                                return;
                            } else {
                                wVar.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            try {
                                io.reactivex.u<? extends R> uVarApply = this.mapper.apply(tPoll);
                                io.reactivex.internal.functions.a.a(uVarApply, "The mapper returned a null ObservableSource");
                                io.reactivex.u<? extends R> uVar = uVarApply;
                                if (uVar instanceof Callable) {
                                    try {
                                        h.a aVar = (Object) ((Callable) uVar).call();
                                        if (aVar != null && !this.cancelled) {
                                            wVar.onNext(aVar);
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.b(th);
                                        atomicThrowable.addThrowable(th);
                                    }
                                } else {
                                    this.active = true;
                                    uVar.subscribe(this.observer);
                                }
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.cancelled = true;
                                this.upstream.dispose();
                                kVar.clear();
                                atomicThrowable.addThrowable(th2);
                                wVar.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        this.cancelled = true;
                        this.upstream.dispose();
                        atomicThrowable.addThrowable(th3);
                        wVar.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.c.a.f) {
                    io.reactivex.c.a.f fVar = (io.reactivex.c.a.f) bVar;
                    int iRequestFusion = fVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = fVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    static final class SourceObserver<T, U> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.w<? super U> downstream;
        int fusionMode;
        final InnerObserver<U> inner;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> mapper;
        io.reactivex.c.a.k<T> queue;
        io.reactivex.disposables.b upstream;

        static final class InnerObserver<U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final io.reactivex.w<? super U> downstream;
            final SourceObserver<?, ?> parent;

            InnerObserver(io.reactivex.w<? super U> wVar, SourceObserver<?, ?> sourceObserver) {
                this.downstream = wVar;
                this.parent = sourceObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.w
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
                this.parent.dispose();
                this.downstream.onError(th);
            }

            @Override // io.reactivex.w
            public void onNext(U u) {
                this.downstream.onNext(u);
            }

            @Override // io.reactivex.w
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        SourceObserver(io.reactivex.w<? super U> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> oVar, int i) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.bufferSize = i;
            this.inner = new InnerObserver<>(wVar, this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T tPoll = this.queue.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.downstream.onComplete();
                            return;
                        }
                        if (!z2) {
                            try {
                                io.reactivex.u<? extends U> uVarApply = this.mapper.apply(tPoll);
                                io.reactivex.internal.functions.a.a(uVarApply, "The mapper returned a null ObservableSource");
                                io.reactivex.u<? extends U> uVar = uVarApply;
                                this.active = true;
                                uVar.subscribe(this.inner);
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                dispose();
                                this.queue.clear();
                                this.downstream.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        dispose();
                        this.queue.clear();
                        this.downstream.onError(th2);
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

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.c.a.f) {
                    io.reactivex.c.a.f fVar = (io.reactivex.c.a.f) bVar;
                    int iRequestFusion = fVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = fVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> oVar, int i, ErrorMode errorMode) {
        super(uVar);
        this.f22089b = oVar;
        this.f22091d = errorMode;
        this.f22090c = Math.max(8, i);
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super U> wVar) {
        if (ObservableScalarXMap.a(this.f22358a, wVar, this.f22089b)) {
            return;
        }
        ErrorMode errorMode = this.f22091d;
        if (errorMode == ErrorMode.IMMEDIATE) {
            this.f22358a.subscribe(new SourceObserver(new io.reactivex.observers.f(wVar), this.f22089b, this.f22090c));
        } else {
            this.f22358a.subscribe(new ConcatMapDelayErrorObserver(wVar, this.f22089b, this.f22090c, errorMode == ErrorMode.END));
        }
    }
}
