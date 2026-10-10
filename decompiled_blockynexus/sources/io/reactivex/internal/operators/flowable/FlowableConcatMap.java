package io.reactivex.internal.operators.flowable;

import io.reactivex.b.o;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatMap<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final o<? super T, ? extends f.b.b<? extends R>> f21862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f21863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final ErrorMode f21864e;

    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements io.reactivex.h<T>, a<R>, f.b.d {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final int limit;
        final o<? super T, ? extends f.b.b<? extends R>> mapper;
        final int prefetch;
        io.reactivex.c.a.k<T> queue;
        int sourceMode;
        f.b.d upstream;
        final ConcatMapInner<R> inner = new ConcatMapInner<>(this);
        final AtomicThrowable errors = new AtomicThrowable();

        BaseConcatMapSubscriber(o<? super T, ? extends f.b.b<? extends R>> oVar, int i) {
            this.mapper = oVar;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        abstract void drain();

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // f.b.c
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // f.b.c
        public final void onNext(T t) {
            if (this.sourceMode == 2 || this.queue.offer(t)) {
                drain();
            } else {
                this.upstream.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // io.reactivex.h, f.b.c
        public final void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof io.reactivex.c.a.h) {
                    io.reactivex.c.a.h hVar = (io.reactivex.c.a.h) dVar;
                    int iRequestFusion = hVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = hVar;
                        this.done = true;
                        subscribeActual();
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = hVar;
                        subscribeActual();
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscribeActual();
                dVar.request(this.prefetch);
            }
        }

        abstract void subscribeActual();
    }

    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final f.b.c<? super R> downstream;
        final boolean veryEnd;

        ConcatMapDelayed(f.b.c<? super R> cVar, o<? super T, ? extends f.b.b<? extends R>> oVar, int i, boolean z) {
            super(oVar, i);
            this.downstream = cVar;
            this.veryEnd = z;
        }

        @Override // f.b.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            Object objCall;
            if (getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        if (z && !this.veryEnd && this.errors.get() != null) {
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                        try {
                            T tPoll = this.queue.poll();
                            boolean z2 = tPoll == null;
                            if (z && z2) {
                                Throwable thTerminate = this.errors.terminate();
                                if (thTerminate != null) {
                                    this.downstream.onError(thTerminate);
                                    return;
                                } else {
                                    this.downstream.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                try {
                                    f.b.b<? extends R> bVarApply = this.mapper.apply(tPoll);
                                    io.reactivex.internal.functions.a.a(bVarApply, "The mapper returned a null Publisher");
                                    f.b.b<? extends R> bVar = bVarApply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            objCall = ((Callable) bVar).call();
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.b(th);
                                            this.errors.addThrowable(th);
                                            if (!this.veryEnd) {
                                                this.upstream.cancel();
                                                this.downstream.onError(this.errors.terminate());
                                                return;
                                            }
                                            objCall = null;
                                        }
                                        if (objCall == null) {
                                            continue;
                                        } else if (this.inner.isUnbounded()) {
                                            this.downstream.onNext(objCall);
                                        } else {
                                            this.active = true;
                                            ConcatMapInner<R> concatMapInner = this.inner;
                                            concatMapInner.setSubscription(new b(objCall, concatMapInner));
                                        }
                                    } else {
                                        this.active = true;
                                        bVar.a(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    this.upstream.cancel();
                                    this.errors.addThrowable(th2);
                                    this.downstream.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.upstream.cancel();
                            this.errors.addThrowable(th3);
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (!this.veryEnd) {
                this.upstream.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // f.b.d
        public void request(long j) {
            this.inner.request(j);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }
    }

    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final f.b.c<? super R> downstream;
        final AtomicInteger wip;

        ConcatMapImmediate(f.b.c<? super R> cVar, o<? super T, ? extends f.b.b<? extends R>> oVar, int i) {
            super(oVar, i);
            this.downstream = cVar;
            this.wip = new AtomicInteger();
        }

        @Override // f.b.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T tPoll = this.queue.poll();
                            boolean z2 = tPoll == null;
                            if (z && z2) {
                                this.downstream.onComplete();
                                return;
                            }
                            if (!z2) {
                                try {
                                    f.b.b<? extends R> bVarApply = this.mapper.apply(tPoll);
                                    io.reactivex.internal.functions.a.a(bVarApply, "The mapper returned a null Publisher");
                                    f.b.b<? extends R> bVar = bVarApply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) bVar).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (!this.inner.isUnbounded()) {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.setSubscription(new b(objCall, concatMapInner));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.downstream.onNext(objCall);
                                                if (!compareAndSet(1, 0)) {
                                                    this.downstream.onError(this.errors.terminate());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.b(th);
                                            this.upstream.cancel();
                                            this.errors.addThrowable(th);
                                            this.downstream.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        bVar.a(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    this.upstream.cancel();
                                    this.errors.addThrowable(th2);
                                    this.downstream.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.upstream.cancel();
                            this.errors.addThrowable(th3);
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.downstream.onError(this.errors.terminate());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.a
        public void innerNext(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.downstream.onError(this.errors.terminate());
            }
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.downstream.onError(this.errors.terminate());
            }
        }

        @Override // f.b.d
        public void request(long j) {
            this.inner.request(j);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }
    }

    static final class ConcatMapInner<R> extends SubscriptionArbiter implements io.reactivex.h<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final a<R> parent;
        long produced;

        ConcatMapInner(a<R> aVar) {
            super(false);
            this.parent = aVar;
        }

        @Override // f.b.c
        public void onComplete() {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                produced(j);
            }
            this.parent.innerComplete();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                produced(j);
            }
            this.parent.innerError(th);
        }

        @Override // f.b.c
        public void onNext(R r) {
            this.produced++;
            this.parent.innerNext(r);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            setSubscription(dVar);
        }
    }

    interface a<T> {
        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t);
    }

    static final class b<T> implements f.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f.b.c<? super T> f21865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f21866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f21867c;

        b(T t, f.b.c<? super T> cVar) {
            this.f21866b = t;
            this.f21865a = cVar;
        }

        @Override // f.b.d
        public void cancel() {
        }

        @Override // f.b.d
        public void request(long j) {
            if (j <= 0 || this.f21867c) {
                return;
            }
            this.f21867c = true;
            f.b.c<? super T> cVar = this.f21865a;
            cVar.onNext(this.f21866b);
            cVar.onComplete();
        }
    }

    public FlowableConcatMap(io.reactivex.e<T> eVar, o<? super T, ? extends f.b.b<? extends R>> oVar, int i, ErrorMode errorMode) {
        super(eVar);
        this.f21862c = oVar;
        this.f21863d = i;
        this.f21864e = errorMode;
    }

    public static <T, R> f.b.c<T> a(f.b.c<? super R> cVar, o<? super T, ? extends f.b.b<? extends R>> oVar, int i, ErrorMode errorMode) {
        int i2 = io.reactivex.internal.operators.flowable.b.f21903a[errorMode.ordinal()];
        return i2 != 1 ? i2 != 2 ? new ConcatMapImmediate(cVar, oVar, i) : new ConcatMapDelayed(cVar, oVar, i, true) : new ConcatMapDelayed(cVar, oVar, i, false);
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super R> cVar) {
        if (m.a(this.f21902b, cVar, this.f21862c)) {
            return;
        }
        this.f21902b.a((f.b.c) a(cVar, this.f21862c, this.f21863d, this.f21864e));
    }
}
