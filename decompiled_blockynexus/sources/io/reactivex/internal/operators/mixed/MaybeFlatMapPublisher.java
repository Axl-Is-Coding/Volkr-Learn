package io.reactivex.internal.operators.mixed;

import f.b.b;
import f.b.c;
import f.b.d;
import io.reactivex.b.o;
import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapPublisher<T, R> extends e<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final m<T> f21956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final o<? super T, ? extends b<? extends R>> f21957c;

    public MaybeFlatMapPublisher(m<T> mVar, o<? super T, ? extends b<? extends R>> oVar) {
        this.f21956b = mVar;
        this.f21957c = oVar;
    }

    @Override // io.reactivex.e
    protected void b(c<? super R> cVar) {
        this.f21956b.a(new FlatMapPublisherSubscriber(cVar, this.f21957c));
    }

    static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<d> implements h<R>, k<T>, d {
        private static final long serialVersionUID = -8948264376121066672L;
        final c<? super R> downstream;
        final o<? super T, ? extends b<? extends R>> mapper;
        final AtomicLong requested = new AtomicLong();
        io.reactivex.disposables.b upstream;

        FlatMapPublisherSubscriber(c<? super R> cVar, o<? super T, ? extends b<? extends R>> oVar) {
            this.downstream = cVar;
            this.mapper = oVar;
        }

        @Override // f.b.d
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // f.b.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // f.b.c
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.k
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.k
        public void onSuccess(T t) {
            try {
                b<? extends R> bVarApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(bVarApply, "The mapper returned a null Publisher");
                bVarApply.a(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.downstream.onError(th);
            }
        }

        @Override // f.b.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
        }
    }
}
