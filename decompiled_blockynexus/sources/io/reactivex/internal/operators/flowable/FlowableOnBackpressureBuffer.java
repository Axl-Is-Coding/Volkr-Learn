package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f21883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f21884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f21885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final io.reactivex.b.a f21886f;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.h<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final f.b.c<? super T> downstream;
        Throwable error;
        final io.reactivex.b.a onOverflow;
        boolean outputFused;
        final io.reactivex.c.a.j<T> queue;
        final AtomicLong requested = new AtomicLong();
        f.b.d upstream;

        BackpressureBufferSubscriber(f.b.c<? super T> cVar, int i, boolean z, boolean z2, io.reactivex.b.a aVar) {
            this.downstream = cVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            this.queue = z ? new io.reactivex.internal.queue.a<>(i) : new SpscArrayQueue<>(i);
        }

        @Override // f.b.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, f.b.c<? super T> cVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.c.a.j<T> jVar = this.queue;
                f.b.c<? super T> cVar = this.downstream;
                int iAddAndGet = 1;
                while (!checkTerminated(this.done, jVar.isEmpty(), cVar)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        T tPoll = jVar.poll();
                        boolean z2 = tPoll == null;
                        if (checkTerminated(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(tPoll);
                        j2++;
                    }
                    if (j2 == j && checkTerminated(this.done, jVar.isEmpty(), cVar)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // f.b.c
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                drain();
            }
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th);
            } else {
                drain();
            }
        }

        @Override // f.b.c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                if (this.outputFused) {
                    this.downstream.onNext(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            this.upstream.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // f.b.d
        public void request(long j) {
            if (this.outputFused || !SubscriptionHelper.validate(j)) {
                return;
            }
            io.reactivex.internal.util.b.a(this.requested, j);
            drain();
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public FlowableOnBackpressureBuffer(io.reactivex.e<T> eVar, int i, boolean z, boolean z2, io.reactivex.b.a aVar) {
        super(eVar);
        this.f21883c = i;
        this.f21884d = z;
        this.f21885e = z2;
        this.f21886f = aVar;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        this.f21902b.a((io.reactivex.h) new BackpressureBufferSubscriber(cVar, this.f21883c, this.f21884d, this.f21885e, this.f21886f));
    }
}
