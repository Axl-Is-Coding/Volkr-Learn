package io.reactivex.internal.operators.observable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: ObservableFromPublisher.java */
/* JADX INFO: loaded from: classes5.dex */
public final class M<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final f.b.b<? extends T> f22047a;

    /* JADX INFO: compiled from: ObservableFromPublisher.java */
    static final class a<T> implements io.reactivex.h<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f.b.d f22049b;

        a(io.reactivex.w<? super T> wVar) {
            this.f22048a = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22049b.cancel();
            this.f22049b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22049b == SubscriptionHelper.CANCELLED;
        }

        @Override // f.b.c
        public void onComplete() {
            this.f22048a.onComplete();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            this.f22048a.onError(th);
        }

        @Override // f.b.c
        public void onNext(T t) {
            this.f22048a.onNext(t);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.f22049b, dVar)) {
                this.f22049b = dVar;
                this.f22048a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public M(f.b.b<? extends T> bVar) {
        this.f22047a = bVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22047a.a(new a(wVar));
    }
}
