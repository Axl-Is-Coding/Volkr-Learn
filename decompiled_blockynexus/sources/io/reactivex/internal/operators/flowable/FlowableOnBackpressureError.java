package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureError<T> extends a<T, T> {

    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements io.reactivex.h<T>, f.b.d {
        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final f.b.c<? super T> downstream;
        f.b.d upstream;

        BackpressureErrorSubscriber(f.b.c<? super T> cVar) {
            this.downstream = cVar;
        }

        @Override // f.b.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // f.b.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // f.b.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() == 0) {
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            } else {
                this.downstream.onNext(t);
                io.reactivex.internal.util.b.c(this, 1L);
            }
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // f.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }
    }

    public FlowableOnBackpressureError(io.reactivex.e<T> eVar) {
        super(eVar);
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        this.f21902b.a((io.reactivex.h) new BackpressureErrorSubscriber(cVar));
    }
}
