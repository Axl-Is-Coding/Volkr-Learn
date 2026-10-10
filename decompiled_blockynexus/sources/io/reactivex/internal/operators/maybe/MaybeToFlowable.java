package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.k;
import io.reactivex.m;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeToFlowable<T> extends io.reactivex.e<T> implements io.reactivex.c.a.c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final m<T> f21940b;

    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements k<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b upstream;

        MaybeToFlowableSubscriber(f.b.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, f.b.d
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.k
        public void onError(Throwable th) {
            this.downstream.onError(th);
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
            complete(t);
        }
    }

    public MaybeToFlowable(m<T> mVar) {
        this.f21940b = mVar;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        this.f21940b.a(new MaybeToFlowableSubscriber(cVar));
    }
}
