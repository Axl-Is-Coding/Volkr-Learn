package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMap<T, U> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> f22110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f22111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f22113e;

    static final class InnerObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final MergeObserver<T, U> parent;
        volatile io.reactivex.c.a.k<U> queue;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.id = j;
            this.parent = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.parent.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            MergeObserver<T, U> mergeObserver = this.parent;
            if (!mergeObserver.delayErrors) {
                mergeObserver.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.w
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof io.reactivex.c.a.f)) {
                io.reactivex.c.a.f fVar = (io.reactivex.c.a.f) bVar;
                int iRequestFusion = fVar.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = fVar;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = fVar;
                }
            }
        }
    }

    static final class MergeObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, io.reactivex.w<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final io.reactivex.w<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile io.reactivex.c.a.j<U> queue;
        Queue<io.reactivex.u<? extends U>> sources;
        long uniqueId;
        io.reactivex.disposables.b upstream;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        MergeObserver(io.reactivex.w<? super U> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> oVar, boolean z, int i, int i2) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        boolean addInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!this.observers.compareAndSet(innerObserverArr, (InnerObserver<?, ?>[]) innerObserverArr2));
            return true;
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            Throwable thTerminate = this.errors.terminate();
            if (thTerminate != ExceptionHelper.f22722a) {
                this.downstream.onError(thTerminate);
            }
            return true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            Throwable thTerminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (thTerminate = this.errors.terminate()) == null || thTerminate == ExceptionHelper.f22722a) {
                return;
            }
            io.reactivex.e.a.b(thTerminate);
        }

        boolean disposeAll() {
            InnerObserver<?, ?>[] andSet;
            this.upstream.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
            InnerObserver<?, ?>[] innerObserverArr2 = CANCELLED;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.observers.getAndSet(innerObserverArr2)) == CANCELLED) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:129:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:121:0x00ec A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:134:0x00f4 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00f3 A[PHI: r4
          0x00f3: PHI (r4v14 int) = (r4v12 int), (r4v15 int) binds: [B:72:0x00d2, B:84:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instruction units count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.drainLoop():void");
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
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
            } else if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                io.reactivex.u<? extends U> uVarApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(uVarApply, "The mapper returned a null ObservableSource");
                io.reactivex.u<? extends U> uVar = uVarApply;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.wip == this.maxConcurrency) {
                            this.sources.offer(uVar);
                            return;
                        }
                        this.wip++;
                    }
                }
                subscribeInner(uVar);
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

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerObserverArr[i2] == innerObserver) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
        }

        void subscribeInner(io.reactivex.u<? extends U> uVar) {
            io.reactivex.u<? extends U> uVarPoll;
            while (uVar instanceof Callable) {
                if (!tryEmitScalar((Callable) uVar) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    uVarPoll = this.sources.poll();
                    if (uVarPoll == null) {
                        this.wip--;
                        z = true;
                    }
                }
                if (z) {
                    drain();
                    return;
                }
                uVar = uVarPoll;
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j);
            if (addInner(innerObserver)) {
                uVar.subscribe(innerObserver);
            }
        }

        void tryEmit(U u, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.c.a.k aVar = innerObserver.queue;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.queue.a(this.bufferSize);
                    innerObserver.queue = aVar;
                }
                aVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        boolean tryEmitScalar(Callable<? extends U> callable) {
            try {
                U uCall = callable.call();
                if (uCall == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(uCall);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    io.reactivex.c.a.j<U> aVar = this.queue;
                    if (aVar == null) {
                        int i = this.maxConcurrency;
                        aVar = i == Integer.MAX_VALUE ? new io.reactivex.internal.queue.a<>(this.bufferSize) : new SpscArrayQueue(i);
                        this.queue = aVar;
                    }
                    if (!aVar.offer(uCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.errors.addThrowable(th);
                drain();
                return true;
            }
        }
    }

    public ObservableFlatMap(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> oVar, boolean z, int i, int i2) {
        super(uVar);
        this.f22110b = oVar;
        this.f22111c = z;
        this.f22112d = i;
        this.f22113e = i2;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super U> wVar) {
        if (ObservableScalarXMap.a(this.f22358a, wVar, this.f22110b)) {
            return;
        }
        this.f22358a.subscribe(new MergeObserver(wVar, this.f22110b, this.f22111c, this.f22112d, this.f22113e));
    }
}
