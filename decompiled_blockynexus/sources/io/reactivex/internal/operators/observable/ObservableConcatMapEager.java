package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> f22092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f22093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f22095e;

    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b, io.reactivex.internal.observers.i<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;
        volatile boolean done;
        final io.reactivex.w<? super R> downstream;
        final ErrorMode errorMode;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        io.reactivex.c.a.k<T> queue;
        int sourceMode;
        io.reactivex.disposables.b upstream;
        final AtomicThrowable error = new AtomicThrowable();
        final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        ConcatMapEagerMainObserver(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar, int i, int i2, ErrorMode errorMode) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            drainAndDispose();
        }

        void disposeAll() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> innerQueuedObserverPoll = this.observers.poll();
                if (innerQueuedObserverPoll == null) {
                    return;
                } else {
                    innerQueuedObserverPoll.dispose();
                }
            }
        }

        @Override // io.reactivex.internal.observers.i
        public void drain() {
            R rPoll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.c.a.k<T> kVar = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
            io.reactivex.w<? super R> wVar = this.downstream;
            ErrorMode errorMode = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                int i = this.activeCount;
                while (i != this.maxConcurrency) {
                    if (this.cancelled) {
                        kVar.clear();
                        disposeAll();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                        kVar.clear();
                        disposeAll();
                        wVar.onError(this.error.terminate());
                        return;
                    }
                    try {
                        T tPoll = kVar.poll();
                        if (tPoll == null) {
                            break;
                        }
                        io.reactivex.u<? extends R> uVarApply = this.mapper.apply(tPoll);
                        io.reactivex.internal.functions.a.a(uVarApply, "The mapper returned a null ObservableSource");
                        io.reactivex.u<? extends R> uVar = uVarApply;
                        InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                        arrayDeque.offer(innerQueuedObserver);
                        uVar.subscribe(innerQueuedObserver);
                        i++;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.upstream.dispose();
                        kVar.clear();
                        disposeAll();
                        this.error.addThrowable(th);
                        wVar.onError(this.error.terminate());
                        return;
                    }
                }
                this.activeCount = i;
                if (this.cancelled) {
                    kVar.clear();
                    disposeAll();
                    return;
                }
                if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                    kVar.clear();
                    disposeAll();
                    wVar.onError(this.error.terminate());
                    return;
                }
                InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                if (innerQueuedObserver2 == null) {
                    if (errorMode == ErrorMode.BOUNDARY && this.error.get() != null) {
                        kVar.clear();
                        disposeAll();
                        wVar.onError(this.error.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    InnerQueuedObserver<R> innerQueuedObserverPoll = arrayDeque.poll();
                    boolean z3 = innerQueuedObserverPoll == null;
                    if (z2 && z3) {
                        if (this.error.get() == null) {
                            wVar.onComplete();
                            return;
                        }
                        kVar.clear();
                        disposeAll();
                        wVar.onError(this.error.terminate());
                        return;
                    }
                    if (!z3) {
                        this.current = innerQueuedObserverPoll;
                    }
                    innerQueuedObserver2 = innerQueuedObserverPoll;
                }
                if (innerQueuedObserver2 != null) {
                    io.reactivex.c.a.k<R> kVarQueue = innerQueuedObserver2.queue();
                    while (!this.cancelled) {
                        boolean zIsDone = innerQueuedObserver2.isDone();
                        if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                            kVar.clear();
                            disposeAll();
                            wVar.onError(this.error.terminate());
                            return;
                        }
                        try {
                            rPoll = kVarQueue.poll();
                            z = rPoll == null;
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.error.addThrowable(th2);
                            this.current = null;
                            this.activeCount--;
                        }
                        if (zIsDone && z) {
                            this.current = null;
                            this.activeCount--;
                        } else if (!z) {
                            wVar.onNext(rPoll);
                        }
                    }
                    kVar.clear();
                    disposeAll();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        void drainAndDispose() {
            if (getAndIncrement() == 0) {
                do {
                    this.queue.clear();
                    disposeAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.internal.observers.i
        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.i
        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (!this.error.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.upstream.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.i
        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.queue().offer(r);
            drain();
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
                this.queue = new io.reactivex.internal.queue.a(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar, ErrorMode errorMode, int i, int i2) {
        super(uVar);
        this.f22092b = oVar;
        this.f22093c = errorMode;
        this.f22094d = i;
        this.f22095e = i2;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super R> wVar) {
        this.f22358a.subscribe(new ConcatMapEagerMainObserver(wVar, this.f22092b, this.f22094d, this.f22095e, this.f22093c));
    }
}
