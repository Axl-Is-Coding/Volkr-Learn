package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDelaySubscriptionOther.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2923t<T, U> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<U> f22556b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t$a */
    /* JADX INFO: compiled from: ObservableDelaySubscriptionOther.java */
    final class a implements io.reactivex.w<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SequentialDisposable f22557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.w<? super T> f22558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22559c;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableDelaySubscriptionOther.java */
        final class C0203a implements io.reactivex.w<T> {
            C0203a() {
            }

            @Override // io.reactivex.w
            public void onComplete() {
                a.this.f22558b.onComplete();
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
                a.this.f22558b.onError(th);
            }

            @Override // io.reactivex.w
            public void onNext(T t) {
                a.this.f22558b.onNext(t);
            }

            @Override // io.reactivex.w
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                a.this.f22557a.update(bVar);
            }
        }

        a(SequentialDisposable sequentialDisposable, io.reactivex.w<? super T> wVar) {
            this.f22557a = sequentialDisposable;
            this.f22558b = wVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22559c) {
                return;
            }
            this.f22559c = true;
            C2923t.this.f22555a.subscribe(new C0203a());
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22559c) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22559c = true;
                this.f22558b.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22557a.update(bVar);
        }
    }

    public C2923t(io.reactivex.u<? extends T> uVar, io.reactivex.u<U> uVar2) {
        this.f22555a = uVar;
        this.f22556b = uVar2;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        wVar.onSubscribe(sequentialDisposable);
        this.f22556b.subscribe(new a(sequentialDisposable, wVar));
    }
}
