package io.reactivex.internal.operators.flowable;

import io.reactivex.b.o;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFlatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final o<? super T, ? extends f.b.b<? extends U>> f21871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f21872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f21873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f21874f;

    static final class InnerSubscriber<T, U> extends AtomicReference<f.b.d> implements io.reactivex.h<U>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile io.reactivex.c.a.k<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.id = j;
            this.parent = mergeSubscriber;
            this.bufferSize = mergeSubscriber.bufferSize;
            this.limit = this.bufferSize >> 2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // f.b.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // f.b.c
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof io.reactivex.c.a.h) {
                    io.reactivex.c.a.h hVar = (io.reactivex.c.a.h) dVar;
                    int iRequestFusion = hVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = hVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = hVar;
                    }
                }
                dVar.request(this.bufferSize);
            }
        }

        void requestMore(long j) {
            if (this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 < this.limit) {
                    this.produced = j2;
                } else {
                    this.produced = 0L;
                    get().request(j2);
                }
            }
        }
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements io.reactivex.h<T>, f.b.d {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final f.b.c<? super U> downstream;
        long lastId;
        int lastIndex;
        final o<? super T, ? extends f.b.b<? extends U>> mapper;
        final int maxConcurrency;
        volatile io.reactivex.c.a.j<U> queue;
        int scalarEmitted;
        final int scalarLimit;
        long uniqueId;
        f.b.d upstream;
        static final InnerSubscriber<?, ?>[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] CANCELLED = new InnerSubscriber[0];
        final AtomicThrowable errs = new AtomicThrowable();
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        MergeSubscriber(f.b.c<? super U> cVar, o<? super T, ? extends f.b.b<? extends U>> oVar, boolean z, int i, int i2) {
            this.downstream = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        boolean addInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, (InnerSubscriber<?, ?>[]) innerSubscriberArr2));
            return true;
        }

        @Override // f.b.d
        public void cancel() {
            io.reactivex.c.a.j<U> jVar;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (jVar = this.queue) == null) {
                return;
            }
            jVar.clear();
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            }
            if (this.delayErrors || this.errs.get() == null) {
                return false;
            }
            clearScalarQueue();
            Throwable thTerminate = this.errs.terminate();
            if (thTerminate != ExceptionHelper.f22722a) {
                this.downstream.onError(thTerminate);
            }
            return true;
        }

        void clearScalarQueue() {
            io.reactivex.c.a.j<U> jVar = this.queue;
            if (jVar != null) {
                jVar.clear();
            }
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = CANCELLED;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) == CANCELLED) {
                return;
            }
            for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            Throwable thTerminate = this.errs.terminate();
            if (thTerminate == null || thTerminate == ExceptionHelper.f22722a) {
                return;
            }
            io.reactivex.e.a.b(thTerminate);
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            long j;
            int i;
            long j2;
            long j3;
            boolean z;
            InnerSubscriber<T, U>[] innerSubscriberArr;
            int i2;
            long j4;
            Object obj;
            f.b.c<? super U> cVar = this.downstream;
            int iAddAndGet = 1;
            while (!checkTerminate()) {
                io.reactivex.c.a.j<U> jVar = this.queue;
                long jAddAndGet = this.requested.get();
                boolean z2 = jAddAndGet == Long.MAX_VALUE;
                long j5 = 0;
                if (jVar != null) {
                    j = 0;
                    do {
                        long j6 = 0;
                        obj = null;
                        while (true) {
                            if (jAddAndGet == 0) {
                                break;
                            }
                            U uPoll = jVar.poll();
                            if (checkTerminate()) {
                                return;
                            }
                            if (uPoll == null) {
                                obj = uPoll;
                                break;
                            }
                            cVar.onNext(uPoll);
                            j++;
                            j6++;
                            jAddAndGet--;
                            obj = uPoll;
                        }
                        if (j6 != 0) {
                            jAddAndGet = z2 ? Long.MAX_VALUE : this.requested.addAndGet(-j6);
                        }
                        if (jAddAndGet == 0) {
                            break;
                        }
                    } while (obj != null);
                } else {
                    j = 0;
                }
                boolean z3 = this.done;
                io.reactivex.c.a.j<U> jVar2 = this.queue;
                InnerSubscriber<?, ?>[] innerSubscriberArr2 = this.subscribers.get();
                int length = innerSubscriberArr2.length;
                if (z3 && ((jVar2 == null || jVar2.isEmpty()) && length == 0)) {
                    Throwable thTerminate = this.errs.terminate();
                    if (thTerminate != ExceptionHelper.f22722a) {
                        if (thTerminate == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            cVar.onError(thTerminate);
                            return;
                        }
                    }
                    return;
                }
                if (length != 0) {
                    i = iAddAndGet;
                    long j7 = this.lastId;
                    int i3 = this.lastIndex;
                    if (length <= i3 || innerSubscriberArr2[i3].id != j7) {
                        if (length <= i3) {
                            i3 = 0;
                        }
                        int i4 = i3;
                        for (int i5 = 0; i5 < length && innerSubscriberArr2[i4].id != j7; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = innerSubscriberArr2[i4].id;
                        i3 = i4;
                    }
                    int i6 = i3;
                    z = false;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            innerSubscriberArr = innerSubscriberArr2;
                            break;
                        }
                        if (checkTerminate()) {
                            return;
                        }
                        InnerSubscriber<T, U> innerSubscriber = innerSubscriberArr2[i6];
                        Object obj2 = null;
                        while (!checkTerminate()) {
                            io.reactivex.c.a.k<U> kVar = innerSubscriber.queue;
                            if (kVar == null) {
                                innerSubscriberArr = innerSubscriberArr2;
                                i2 = length;
                            } else {
                                i2 = length;
                                Object obj3 = obj2;
                                innerSubscriberArr = innerSubscriberArr2;
                                long j8 = j5;
                                while (true) {
                                    if (jAddAndGet == j5) {
                                        break;
                                    }
                                    try {
                                        U uPoll2 = kVar.poll();
                                        if (uPoll2 == null) {
                                            obj3 = uPoll2;
                                            j5 = 0;
                                            break;
                                        }
                                        cVar.onNext(uPoll2);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        jAddAndGet--;
                                        j8++;
                                        obj3 = uPoll2;
                                        j5 = 0;
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.b(th);
                                        innerSubscriber.dispose();
                                        this.errs.addThrowable(th);
                                        if (!this.delayErrors) {
                                            this.upstream.cancel();
                                        }
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(innerSubscriber);
                                        i7++;
                                        z = true;
                                    }
                                }
                                if (j8 != j5) {
                                    jAddAndGet = !z2 ? this.requested.addAndGet(-j8) : Long.MAX_VALUE;
                                    innerSubscriber.requestMore(j8);
                                    j4 = 0;
                                } else {
                                    j4 = j5;
                                }
                                if (jAddAndGet != j4 && obj3 != null) {
                                    innerSubscriberArr2 = innerSubscriberArr;
                                    length = i2;
                                    obj2 = obj3;
                                    j5 = 0;
                                }
                            }
                            boolean z4 = innerSubscriber.done;
                            io.reactivex.c.a.k<U> kVar2 = innerSubscriber.queue;
                            if (z4 && (kVar2 == null || kVar2.isEmpty())) {
                                removeInner(innerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                j++;
                                z = true;
                            }
                            if (jAddAndGet == 0) {
                                break;
                            }
                            int i8 = i6 + 1;
                            i6 = i8 == i2 ? 0 : i8;
                            i7++;
                            innerSubscriberArr2 = innerSubscriberArr;
                            length = i2;
                            j5 = 0;
                        }
                        return;
                    }
                    this.lastIndex = i6;
                    this.lastId = innerSubscriberArr[i6].id;
                    j3 = j;
                    j2 = 0;
                } else {
                    i = iAddAndGet;
                    j2 = 0;
                    j3 = j;
                    z = false;
                }
                if (j3 != j2 && !this.cancelled) {
                    this.upstream.request(j3);
                }
                if (z) {
                    iAddAndGet = i;
                } else {
                    iAddAndGet = addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        io.reactivex.c.a.k<U> getInnerQueue(InnerSubscriber<T, U> innerSubscriber) {
            io.reactivex.c.a.k<U> kVar = innerSubscriber.queue;
            if (kVar != null) {
                return kVar;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        io.reactivex.c.a.k<U> getMainQueue() {
            io.reactivex.c.a.j<U> aVar = this.queue;
            if (aVar == null) {
                int i = this.maxConcurrency;
                aVar = i == Integer.MAX_VALUE ? new io.reactivex.internal.queue.a<>(this.bufferSize) : new SpscArrayQueue(i);
                this.queue = aVar;
            }
            return aVar;
        }

        void innerError(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (!this.errs.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            innerSubscriber.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                for (InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(CANCELLED)) {
                    innerSubscriber2.dispose();
                }
            }
            drain();
        }

        @Override // f.b.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
            } else if (!this.errs.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                f.b.b<? extends U> bVarApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(bVarApply, "The mapper returned a null Publisher");
                f.b.b<? extends U> bVar = bVarApply;
                if (!(bVar instanceof Callable)) {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    if (addInner(innerSubscriber)) {
                        bVar.a(innerSubscriber);
                        return;
                    }
                    return;
                }
                try {
                    Object objCall = ((Callable) bVar).call();
                    if (objCall != null) {
                        tryEmitScalar(objCall);
                        return;
                    }
                    if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                        return;
                    }
                    int i = this.scalarEmitted + 1;
                    this.scalarEmitted = i;
                    int i2 = this.scalarLimit;
                    if (i == i2) {
                        this.scalarEmitted = 0;
                        this.upstream.request(i2);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.errs.addThrowable(th);
                    drain();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request(i);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i2] == innerSubscriber) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        @Override // f.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        void tryEmit(U u, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                io.reactivex.c.a.k<U> innerQueue = innerSubscriber.queue;
                if (j == 0 || !(innerQueue == null || innerQueue.isEmpty())) {
                    if (innerQueue == null) {
                        innerQueue = getInnerQueue(innerSubscriber);
                    }
                    if (!innerQueue.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.requestMore(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.c.a.k spscArrayQueue = innerSubscriber.queue;
                if (spscArrayQueue == null) {
                    spscArrayQueue = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = spscArrayQueue;
                }
                if (!spscArrayQueue.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void tryEmitScalar(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                io.reactivex.c.a.k<U> mainQueue = this.queue;
                if (j == 0 || !(mainQueue == null || mainQueue.isEmpty())) {
                    if (mainQueue == null) {
                        mainQueue = getMainQueue();
                    }
                    if (!mainQueue.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    public FlowableFlatMap(io.reactivex.e<T> eVar, o<? super T, ? extends f.b.b<? extends U>> oVar, boolean z, int i, int i2) {
        super(eVar);
        this.f21871c = oVar;
        this.f21872d = z;
        this.f21873e = i;
        this.f21874f = i2;
    }

    public static <T, U> io.reactivex.h<T> a(f.b.c<? super U> cVar, o<? super T, ? extends f.b.b<? extends U>> oVar, boolean z, int i, int i2) {
        return new MergeSubscriber(cVar, oVar, z, i, i2);
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super U> cVar) {
        if (m.a(this.f21902b, cVar, this.f21871c)) {
            return;
        }
        this.f21902b.a((io.reactivex.h) a(cVar, this.f21871c, this.f21872d, this.f21873e, this.f21874f));
    }
}
