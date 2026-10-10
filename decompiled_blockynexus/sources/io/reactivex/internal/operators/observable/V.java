package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableLastMaybe.java */
/* JADX INFO: loaded from: classes5.dex */
public final class V<T> extends io.reactivex.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22337a;

    /* JADX INFO: compiled from: ObservableLastMaybe.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.k<? super T> f22338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f22340c;

        a(io.reactivex.k<? super T> kVar) {
            this.f22338a = kVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22339b.dispose();
            this.f22339b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22339b == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22339b = DisposableHelper.DISPOSED;
            T t = this.f22340c;
            if (t == null) {
                this.f22338a.onComplete();
            } else {
                this.f22340c = null;
                this.f22338a.onSuccess(t);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22339b = DisposableHelper.DISPOSED;
            this.f22340c = null;
            this.f22338a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22340c = t;
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22339b, bVar)) {
                this.f22339b = bVar;
                this.f22338a.onSubscribe(this);
            }
        }
    }

    public V(io.reactivex.u<T> uVar) {
        this.f22337a = uVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.k<? super T> kVar) {
        this.f22337a.subscribe(new a(kVar));
    }
}
