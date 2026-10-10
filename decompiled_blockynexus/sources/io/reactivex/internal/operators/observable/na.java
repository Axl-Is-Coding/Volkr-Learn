package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableSkip.java */
/* JADX INFO: loaded from: classes5.dex */
public final class na<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22487b;

    /* JADX INFO: compiled from: ObservableSkip.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f22489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22490c;

        a(io.reactivex.w<? super T> wVar, long j) {
            this.f22488a = wVar;
            this.f22489b = j;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22490c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22490c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22488a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22488a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            long j = this.f22489b;
            if (j != 0) {
                this.f22489b = j - 1;
            } else {
                this.f22488a.onNext(t);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22490c, bVar)) {
                this.f22490c = bVar;
                this.f22488a.onSubscribe(this);
            }
        }
    }

    public na(io.reactivex.u<T> uVar, long j) {
        super(uVar);
        this.f22487b = j;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22487b));
    }
}
