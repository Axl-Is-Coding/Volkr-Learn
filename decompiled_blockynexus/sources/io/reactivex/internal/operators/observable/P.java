package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableHide.java */
/* JADX INFO: loaded from: classes5.dex */
public final class P<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: compiled from: ObservableHide.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22304b;

        a(io.reactivex.w<? super T> wVar) {
            this.f22303a = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22304b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22304b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22303a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22303a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22303a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22304b, bVar)) {
                this.f22304b = bVar;
                this.f22303a.onSubscribe(this);
            }
        }
    }

    public P(io.reactivex.u<T> uVar) {
        super(uVar);
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar));
    }
}
