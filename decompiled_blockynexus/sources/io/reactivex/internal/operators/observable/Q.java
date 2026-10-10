package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableIgnoreElements.java */
/* JADX INFO: loaded from: classes5.dex */
public final class Q<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: compiled from: ObservableIgnoreElements.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22306b;

        a(io.reactivex.w<? super T> wVar) {
            this.f22305a = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22306b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22306b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22305a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22305a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22306b = bVar;
            this.f22305a.onSubscribe(this);
        }
    }

    public Q(io.reactivex.u<T> uVar) {
        super(uVar);
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar));
    }
}
