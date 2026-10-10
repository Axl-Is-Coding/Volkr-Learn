package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: FlowableLastMaybe.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j<T> extends io.reactivex.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final f.b.b<T> f21925a;

    /* JADX INFO: compiled from: FlowableLastMaybe.java */
    static final class a<T> implements io.reactivex.h<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.k<? super T> f21926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f.b.d f21927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f21928c;

        a(io.reactivex.k<? super T> kVar) {
            this.f21926a = kVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f21927b.cancel();
            this.f21927b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21927b == SubscriptionHelper.CANCELLED;
        }

        @Override // f.b.c
        public void onComplete() {
            this.f21927b = SubscriptionHelper.CANCELLED;
            T t = this.f21928c;
            if (t == null) {
                this.f21926a.onComplete();
            } else {
                this.f21928c = null;
                this.f21926a.onSuccess(t);
            }
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            this.f21927b = SubscriptionHelper.CANCELLED;
            this.f21928c = null;
            this.f21926a.onError(th);
        }

        @Override // f.b.c
        public void onNext(T t) {
            this.f21928c = t;
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.f21927b, dVar)) {
                this.f21927b = dVar;
                this.f21926a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public j(f.b.b<T> bVar) {
        this.f21925a = bVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.k<? super T> kVar) {
        this.f21925a.a(new a(kVar));
    }
}
