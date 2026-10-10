package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final x f21898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f21899d;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements io.reactivex.h<T>, f.b.d, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final f.b.c<? super T> downstream;
        final boolean nonScheduledRequests;
        f.b.b<T> source;
        final x.c worker;
        final AtomicReference<f.b.d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final f.b.d f21900a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final long f21901b;

            a(f.b.d dVar, long j) {
                this.f21900a = dVar;
                this.f21901b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f21900a.request(this.f21901b);
            }
        }

        SubscribeOnSubscriber(f.b.c<? super T> cVar, x.c cVar2, f.b.b<T> bVar, boolean z) {
            this.downstream = cVar;
            this.worker = cVar2;
            this.source = bVar;
            this.nonScheduledRequests = !z;
        }

        @Override // f.b.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // f.b.c
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // f.b.c
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar);
                }
            }
        }

        @Override // f.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                f.b.d dVar = this.upstream.get();
                if (dVar != null) {
                    requestUpstream(j, dVar);
                    return;
                }
                io.reactivex.internal.util.b.a(this.requested, j);
                f.b.d dVar2 = this.upstream.get();
                if (dVar2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, dVar2);
                    }
                }
            }
        }

        void requestUpstream(long j, f.b.d dVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dVar.request(j);
            } else {
                this.worker.a(new a(dVar, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            f.b.b<T> bVar = this.source;
            this.source = null;
            bVar.a(this);
        }
    }

    public FlowableSubscribeOn(io.reactivex.e<T> eVar, x xVar, boolean z) {
        super(eVar);
        this.f21898c = xVar;
        this.f21899d = z;
    }

    @Override // io.reactivex.e
    public void b(f.b.c<? super T> cVar) {
        x.c cVarA = this.f21898c.a();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(cVar, cVarA, this.f21902b, this.f21899d);
        cVar.onSubscribe(subscribeOnSubscriber);
        cVarA.a(subscribeOnSubscriber);
    }
}
