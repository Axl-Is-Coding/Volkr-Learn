package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.a f21870c;

    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.c.a.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final io.reactivex.c.a.a<? super T> downstream;
        final io.reactivex.b.a onFinally;
        io.reactivex.c.a.h<T> qs;
        boolean syncFused;
        f.b.d upstream;

        DoFinallyConditionalSubscriber(io.reactivex.c.a.a<? super T> aVar, io.reactivex.b.a aVar2) {
            this.downstream = aVar;
            this.onFinally = aVar2;
        }

        @Override // f.b.d
        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // f.b.c
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // f.b.c
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof io.reactivex.c.a.h) {
                    this.qs = (io.reactivex.c.a.h) dVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // f.b.d
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            io.reactivex.c.a.h<T> hVar = this.qs;
            if (hVar == null || (i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = hVar.requestFusion(i);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
            }
        }

        @Override // io.reactivex.c.a.a
        public boolean tryOnNext(T t) {
            return this.downstream.tryOnNext(t);
        }
    }

    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.h<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final f.b.c<? super T> downstream;
        final io.reactivex.b.a onFinally;
        io.reactivex.c.a.h<T> qs;
        boolean syncFused;
        f.b.d upstream;

        DoFinallySubscriber(f.b.c<? super T> cVar, io.reactivex.b.a aVar) {
            this.downstream = cVar;
            this.onFinally = aVar;
        }

        @Override // f.b.d
        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // f.b.c
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // f.b.c
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof io.reactivex.c.a.h) {
                    this.qs = (io.reactivex.c.a.h) dVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // f.b.d
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            io.reactivex.c.a.h<T> hVar = this.qs;
            if (hVar == null || (i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = hVar.requestFusion(i);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
            }
        }
    }

    public FlowableDoFinally(io.reactivex.e<T> eVar, io.reactivex.b.a aVar) {
        super(eVar);
        this.f21870c = aVar;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        if (cVar instanceof io.reactivex.c.a.a) {
            this.f21902b.a((io.reactivex.h) new DoFinallyConditionalSubscriber((io.reactivex.c.a.a) cVar, this.f21870c));
        } else {
            this.f21902b.a((io.reactivex.h) new DoFinallySubscriber(cVar, this.f21870c));
        }
    }
}
