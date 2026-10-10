package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final x f21880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f21881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f21882e;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.h<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        io.reactivex.c.a.k<T> queue;
        final AtomicLong requested = new AtomicLong();
        int sourceMode;
        f.b.d upstream;
        final x.c worker;

        BaseObserveOnSubscriber(x.c cVar, boolean z, int i) {
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // f.b.d
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, f.b.c<?> cVar) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                this.cancelled = true;
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.cancelled = true;
                clear();
                cVar.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.cancelled = true;
            cVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.c.a.k
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.c.a.k
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // f.b.c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule();
        }

        @Override // f.b.c
        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // f.b.c
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }

        @Override // f.b.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                trySchedule();
            }
        }

        @Override // io.reactivex.c.a.g
        public final int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        final void trySchedule() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.a(this);
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final io.reactivex.c.a.a<? super T> downstream;

        ObserveOnConditionalSubscriber(io.reactivex.c.a.a<? super T> aVar, x.c cVar, boolean z, int i) {
            super(cVar, z, i);
            this.downstream = aVar;
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof io.reactivex.c.a.h) {
                    io.reactivex.c.a.h hVar = (io.reactivex.c.a.h) dVar;
                    int iRequestFusion = hVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = hVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = hVar;
                        this.downstream.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j = this.consumed + 1;
                if (j == this.limit) {
                    this.consumed = 0L;
                    this.upstream.request(j);
                } else {
                    this.consumed = j;
                }
            }
            return tPoll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            io.reactivex.c.a.a<? super T> aVar = this.downstream;
            io.reactivex.c.a.k<T> kVar = this.queue;
            long j = this.produced;
            long j2 = this.consumed;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j != j3) {
                    boolean z = this.done;
                    try {
                        T tPoll = kVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, aVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (aVar.tryOnNext(tPoll)) {
                            j++;
                        }
                        j2++;
                        if (j2 == this.limit) {
                            this.upstream.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        kVar.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j == j3 && checkTerminated(this.done, kVar.isEmpty(), aVar)) {
                    return;
                }
                int i = get();
                if (iAddAndGet == i) {
                    this.produced = j;
                    this.consumed = j2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            io.reactivex.c.a.a<? super T> aVar = this.downstream;
            io.reactivex.c.a.k<T> kVar = this.queue;
            long j = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        T tPoll = kVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            this.cancelled = true;
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (aVar.tryOnNext(tPoll)) {
                            j++;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (kVar.isEmpty()) {
                    this.cancelled = true;
                    aVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i = get();
                    if (iAddAndGet == i) {
                        this.produced = j;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i;
                    }
                }
            }
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements io.reactivex.h<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final f.b.c<? super T> downstream;

        ObserveOnSubscriber(f.b.c<? super T> cVar, x.c cVar2, boolean z, int i) {
            super(cVar2, z, i);
            this.downstream = cVar;
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof io.reactivex.c.a.h) {
                    io.reactivex.c.a.h hVar = (io.reactivex.c.a.h) dVar;
                    int iRequestFusion = hVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = hVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = hVar;
                        this.downstream.onSubscribe(this);
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j = this.produced + 1;
                if (j == this.limit) {
                    this.produced = 0L;
                    this.upstream.request(j);
                } else {
                    this.produced = j;
                }
            }
            return tPoll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            f.b.c<? super T> cVar = this.downstream;
            io.reactivex.c.a.k<T> kVar = this.queue;
            long j = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.requested.get();
                while (j != jAddAndGet) {
                    boolean z = this.done;
                    try {
                        T tPoll = kVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j++;
                        if (j == this.limit) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = this.requested.addAndGet(-j);
                            }
                            this.upstream.request(j);
                            j = 0;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        kVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j == jAddAndGet && checkTerminated(this.done, kVar.isEmpty(), cVar)) {
                    return;
                }
                int i = get();
                if (iAddAndGet == i) {
                    this.produced = j;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            f.b.c<? super T> cVar = this.downstream;
            io.reactivex.c.a.k<T> kVar = this.queue;
            long j = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        T tPoll = kVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            this.cancelled = true;
                            cVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        cVar.onNext(tPoll);
                        j++;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (kVar.isEmpty()) {
                    this.cancelled = true;
                    cVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i = get();
                    if (iAddAndGet == i) {
                        this.produced = j;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i;
                    }
                }
            }
        }
    }

    public FlowableObserveOn(io.reactivex.e<T> eVar, x xVar, boolean z, int i) {
        super(eVar);
        this.f21880c = xVar;
        this.f21881d = z;
        this.f21882e = i;
    }

    @Override // io.reactivex.e
    public void b(f.b.c<? super T> cVar) {
        x.c cVarA = this.f21880c.a();
        if (cVar instanceof io.reactivex.c.a.a) {
            this.f21902b.a((io.reactivex.h) new ObserveOnConditionalSubscriber((io.reactivex.c.a.a) cVar, cVarA, this.f21881d, this.f21882e));
        } else {
            this.f21902b.a((io.reactivex.h) new ObserveOnSubscriber(cVar, cVarA, this.f21881d, this.f21882e));
        }
    }
}
