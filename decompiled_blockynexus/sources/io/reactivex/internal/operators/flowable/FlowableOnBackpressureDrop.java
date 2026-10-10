package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements io.reactivex.b.g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.g<? super T> f21887c;

    static final class BackpressureDropSubscriber<T> extends AtomicLong implements io.reactivex.h<T>, f.b.d {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final f.b.c<? super T> downstream;
        final io.reactivex.b.g<? super T> onDrop;
        f.b.d upstream;

        BackpressureDropSubscriber(f.b.c<? super T> cVar, io.reactivex.b.g<? super T> gVar) {
            this.downstream = cVar;
            this.onDrop = gVar;
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
            if (get() != 0) {
                this.downstream.onNext(t);
                io.reactivex.internal.util.b.c(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                onError(th);
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

    public FlowableOnBackpressureDrop(io.reactivex.e<T> eVar) {
        super(eVar);
        this.f21887c = this;
    }

    @Override // io.reactivex.b.g
    public void accept(T t) {
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        this.f21902b.a((io.reactivex.h) new BackpressureDropSubscriber(cVar, this.f21887c));
    }
}
